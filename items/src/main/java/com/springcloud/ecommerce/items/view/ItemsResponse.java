package com.springcloud.ecommerce.items.view;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ItemsResponse {

    @JsonProperty("items")
    private List<ItemResponse> items;

    public List<ItemResponse> getItems() {
        return items;
    }

    public void setItems(List<ItemResponse> items) {
        this.items = items;
    }
}
