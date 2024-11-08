package com.springcloud.ecommerce.items.view;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Products {

    @JsonProperty("products")
    private List<Product> products;

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}
