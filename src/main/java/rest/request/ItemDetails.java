package rest.request;

import javax.validation.constraints.NotNull;

public class ItemDetails {
    @NotNull
    private String productName;
    @NotNull
    private String country;
    @NotNull
    private Double price;
    @NotNull
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
