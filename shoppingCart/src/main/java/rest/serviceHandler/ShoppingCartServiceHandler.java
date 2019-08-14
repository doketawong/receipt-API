package rest.serviceHandler;

import org.springframework.http.ResponseEntity;
import rest.request.ShoppingRequest;
import rest.response.ShoppingResponse;

public interface ShoppingCartServiceHandler {
    public ResponseEntity<ShoppingResponse> getReceipt(ShoppingRequest shoppingRequest) ;
}
