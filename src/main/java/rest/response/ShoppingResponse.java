package rest.response;

import java.util.List;

public class ShoppingResponse {

    private List<ItemDetailsWithTaxAndTotal> itemDetailsWithTaxAndTotals;

    private double subTotal;

    private double tax;

    private double Total;

    private String  error;


    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public List<ItemDetailsWithTaxAndTotal> getItemDetailsWithTaxAndTotals() {
        return itemDetailsWithTaxAndTotals;
    }

    public void setItemDetailsWithTaxAndTotals(List<ItemDetailsWithTaxAndTotal> itemDetailsWithTaxAndTotals) {
        this.itemDetailsWithTaxAndTotals = itemDetailsWithTaxAndTotals;
    }

    public double getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(double subTotal) {
        this.subTotal = subTotal;
    }

    public double getTax() {
        return tax;
    }

    public void setTax(double tax) {
        this.tax = tax;
    }

    public double getTotal() {
        return Total;
    }

    public void setTotal(double total) {
        Total = total;
    }
}
