package com.springcloud.ecommerce.products.service;

import com.springcloud.ecommerce.products.view.ProductResponse;
import com.springcloud.ecommerce.products.view.ProductsResponse;

public interface ProductService {

    ProductsResponse findAll();

    ProductResponse findById(Long id);
}
