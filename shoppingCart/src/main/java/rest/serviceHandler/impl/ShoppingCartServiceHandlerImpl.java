package rest.serviceHandler.impl;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import rest.request.ItemDetails;
import rest.common.ShoppingCartConstant;
import rest.request.ShoppingRequest;
import rest.response.ShoppingResponse;
import rest.serviceHandler.ShoppingCartServiceHandler;

import java.util.List;

@Service
public class ShoppingCartServiceHandlerImpl implements ShoppingCartServiceHandler {
    double caTax = ShoppingCartConstant.CATAXRATE;
    double nyTax = ShoppingCartConstant.NYTAXRATE;
    String[] foodExempt = ShoppingCartConstant.FOODEXEMPT;
    String[] shirtExempt = ShoppingCartConstant.SHIRTEXEMPT;

    @Override
    public ResponseEntity<ShoppingResponse> getReceipt(ShoppingRequest shoppingRequest) {
        List<ItemDetails> itemDetailsList = shoppingRequest.getItemDetails();
        ShoppingResponse shoppingResponse = new ShoppingResponse();
        double subtotal = 0;
        double taxTotal = 0;
        double total = 0;
        if(!itemDetailsList.isEmpty()){
            for(ItemDetails itemDetails : itemDetailsList){
                String country = itemDetails.getCountry().toLowerCase();
                String item = itemDetails.getProductName();
                Double price = itemDetails.getPrice();
                Integer quantity = itemDetails.getQuantity();

                if(isCalifornia(country)){
                    //California tax calculation
                    double itemTotalPrice = Math.round((price * quantity) * 20) / 20;
                    double tax = 0;
                    if(!isFoodExempt(item)){
                        tax = Math.round((itemTotalPrice * caTax) * 20) / 20;
                    }
                    subtotal = subtotal + itemTotalPrice;
                    taxTotal = taxTotal + tax;
                } else if(isNewYork(country)){
                    //New York tax calculation
                    double itemTotalPrice = Math.round((price * quantity) * 20) / 20;
                    double tax = 0;
                    if(!isFoodExempt(item) && !isShirtExempt(item)){
                        tax = Math.round((itemTotalPrice * caTax) * 20) / 20;
                    } else{
                        tax = 0;
                    }
                    subtotal = subtotal + itemTotalPrice;
                    taxTotal = taxTotal + tax;

                }else{
                    //normal price without tax
                    double itemTotalPrice = Math.round((price * quantity) * 20) / 20;

                }

            }
            total = subtotal + taxTotal;
        }
        return null;
    }

    private Boolean isCalifornia(String country){
        if(country.equals("ca")  || country.equals("california")){
            return true;
        }
        return false;
    }

    private Boolean isNewYork(String country){
        if(country.equals("ny")  || country.equals("new york")){
            return true;
        }
        return false;
    }

    private Boolean isFoodExempt(String item){
        for(String food : foodExempt){
            if(item.equals(food)){
                return true;
            }
        }
        return false;
    }

    private Boolean isShirtExempt(String item){
        for(String shirt : shirtExempt){
            if(item.equals(shirt)){
                return true;
            }
        }
        return false;
    }


}
