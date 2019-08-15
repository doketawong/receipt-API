package rest.serviceHandler.impl;


import org.springframework.beans.BeanUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import rest.common.ShoppingCartConstant;
import rest.request.ItemDetails;
import rest.request.ShoppingRequest;
import rest.response.ItemDetailsWithTaxAndTotal;
import rest.response.ShoppingResponse;

import rest.serviceHandler.ShoppingCartServiceHandler;

import java.util.ArrayList;
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
        List<ItemDetailsWithTaxAndTotal> itemDetailsWithTaxAndTotalList = new ArrayList<>();
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
                ItemDetailsWithTaxAndTotal itemDetailsWithTaxAndTotal = new ItemDetailsWithTaxAndTotal();
                itemDetailsWithTaxAndTotal.setCountry(country);
                itemDetailsWithTaxAndTotal.setProductName(item);
                itemDetailsWithTaxAndTotal.setPrice(price);
                itemDetailsWithTaxAndTotal.setQuantity(quantity);


                if(isCalifornia(country)){
                    //California tax calculation
                    double itemTotalPrice = Math.ceil((price * quantity) * 20) / 20;
                    double tax = 0;
                    if(!isFoodExempt(item)){
                        tax = Math.ceil((itemTotalPrice * caTax) * 20) / 20;
                    }
                    itemDetailsWithTaxAndTotal.setTotal(itemTotalPrice);
                    itemDetailsWithTaxAndTotal.setTax(tax);
                    subtotal = subtotal + itemTotalPrice;
                    taxTotal = taxTotal + tax;
                } else if(isNewYork(country)){
                    //New York tax calculation
                    double itemTotalPrice = Math.ceil((price * quantity) * 20) / 20;
                    double tax = 0;
                    if(!isFoodExempt(item) && !isShirtExempt(item)){
                        tax = Math.ceil((itemTotalPrice * nyTax) * 20) / 20;
                    } else{
                        tax = 0;
                    }
                    itemDetailsWithTaxAndTotal.setTotal(itemTotalPrice);
                    itemDetailsWithTaxAndTotal.setTax(tax);
                    subtotal = subtotal + itemTotalPrice;
                    taxTotal = taxTotal + tax;

                }else{
                    //normal price without tax
                    double itemTotalPrice = Math.round((price * quantity) * 20) / 20;
                    itemDetailsWithTaxAndTotal.setTotal(itemTotalPrice);

                }
                itemDetailsWithTaxAndTotalList.add(itemDetailsWithTaxAndTotal);
            }
            total = subtotal + taxTotal;
        }
        shoppingResponse.setItemDetailsWithTaxAndTotals(itemDetailsWithTaxAndTotalList);
        shoppingResponse.setSubTotal(subtotal);
        shoppingResponse.setTax(taxTotal);
        shoppingResponse.setTotal(total);
        return ResponseEntity.ok(shoppingResponse);
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
