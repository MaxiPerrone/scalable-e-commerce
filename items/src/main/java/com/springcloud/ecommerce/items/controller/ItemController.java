package com.springcloud.ecommerce.items.controller;

import org.springframework.web.bind.annotation.RestController;

import com.springcloud.ecommerce.items.service.ItemService;
import com.springcloud.ecommerce.items.view.ItemResponse;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;


@RestController
@RequestMapping("/items")
public class ItemController {

    private final ItemService service;

    public ItemController(@Qualifier("itemServiceWebClient") ItemService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<?> list() {
        return ResponseEntity.ok(service.findAll());
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<?> get(@PathVariable Long id) {
        ItemResponse item = service.findById(id);

        if (item == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(item);
    }
}
