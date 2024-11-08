package com.springcloud.ecommerce.items.service;

import com.springcloud.ecommerce.items.view.ItemResponse;
import com.springcloud.ecommerce.items.view.ItemsResponse;

public interface ItemService {

    ItemsResponse findAll();

    ItemResponse findById(Long id);
}
