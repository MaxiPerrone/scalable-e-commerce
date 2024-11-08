
package com.springcloud.ecommerce.products.controller;

import org.springframework.web.bind.annotation.RestController;

import com.springcloud.ecommerce.products.service.ProductService;
import com.springcloud.ecommerce.products.view.ProductResponse;
import com.springcloud.ecommerce.products.view.ProductsResponse;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/products")
public class ProductController {

    private final ProductService service;

    public ProductController(ProductService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<ProductsResponse> list() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> get(@PathVariable Long id) {
        ProductResponse productResponse = service.findById(id);

        if (productResponse == null) {
            return ResponseEntity.notFound().build();
        }
        
        return ResponseEntity.ok(productResponse);
    }
}
