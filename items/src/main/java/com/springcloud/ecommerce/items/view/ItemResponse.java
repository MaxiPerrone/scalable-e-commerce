package com.springcloud.ecommerce.items.view;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ItemResponse {

    @JsonProperty("product")
    private Product product;

    @JsonProperty("quantity")
    private int quantity;

    public ItemResponse(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    
    public Double getTotal() {
        return product.getPrice() * quantity;
    }
}
