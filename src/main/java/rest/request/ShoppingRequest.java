package rest.request;

import java.util.List;

public class ShoppingRequest {
    private List<ItemDetails> itemDetails;

    public List<ItemDetails> getItemDetails() {
        return itemDetails;
    }

    public void setItemDetails(List<ItemDetails> itemDetails) {
        this.itemDetails = itemDetails;
    }
}
