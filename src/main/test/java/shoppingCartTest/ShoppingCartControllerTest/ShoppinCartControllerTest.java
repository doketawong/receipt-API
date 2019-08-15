package shoppingCartTest.ShoppingCartControllerTest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import rest.request.ShoppingRequest;
import rest.serviceHandler.impl.ShoppingCartServiceHandlerImpl;


@RunWith(SpringRunner.class)
@SpringBootTest
public class ShoppinCartControllerTest {
    @Autowired
    private ShoppingCartServiceHandlerImpl shoppingCartServiceHandler;

    @Test
    public void testisCalifornia(){
        ShoppingRequest shoppingRequest = new ShoppingRequest();



    }
}
