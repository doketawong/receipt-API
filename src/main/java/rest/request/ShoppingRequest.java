package rest.request;

import javax.validation.Valid;
import java.util.List;

public class ShoppingRequest {
    @Valid
    private List<ItemDetails> itemDetails;

    public List<ItemDetails> getItemDetails() {
        return itemDetails;
    }

    public void setItemDetails(List<ItemDetails> itemDetails) {
        this.itemDetails = itemDetails;
    }
}
