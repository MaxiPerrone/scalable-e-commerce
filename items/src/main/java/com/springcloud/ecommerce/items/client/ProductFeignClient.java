package com.springcloud.ecommerce.items.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.springcloud.ecommerce.items.view.Product;
import com.springcloud.ecommerce.items.view.Products;

@FeignClient(name="products")
public interface ProductFeignClient {

    @GetMapping("/products")
    public Products list();

    @GetMapping("/products/{id}")
    public Product get(@PathVariable Long id);
}
