package com.springcloud.ecommerce.products.view;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ProductsResponse {

    @JsonProperty("products")
    private List<ProductResponse> products;

    public List<ProductResponse> getProducts() {
        return products;
    }

    public void setProducts(List<ProductResponse> products) {
        this.products = products;
    }
}
