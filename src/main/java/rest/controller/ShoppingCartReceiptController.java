package rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import rest.request.ShoppingRequest;
import rest.response.ShoppingResponse;

import rest.serviceHandler.ShoppingCartServiceHandler;

@RestController
public class ShoppingCartReceiptController {
    @Autowired
    private ShoppingCartServiceHandler shoppingCartServiceHandler;

   @PostMapping(path = "/getReceipt")
   ResponseEntity<ShoppingResponse> test(@RequestBody ShoppingRequest shoppingRequest){
       ResponseEntity<ShoppingResponse> response = shoppingCartServiceHandler.getReceipt(shoppingRequest);
       return response;
   }
}
