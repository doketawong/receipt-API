package rest.request;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

public class ItemDetails {
    @Valid
    @NotNull(message = "productName may not be null")
    private String productName;
    @Valid
    @NotNull(message = "country may not be null")
    private String country;
    @Valid
    @NotNull(message = "price may not be null")
    private Double price;
    @Valid
    @NotNull(message = "quantity may not be null")
    private Integer quantity;

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
