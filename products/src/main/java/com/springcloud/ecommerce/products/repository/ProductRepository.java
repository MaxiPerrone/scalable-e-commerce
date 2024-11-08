package com.springcloud.ecommerce.products.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.springcloud.ecommerce.products.domain.Product;

@Repository
public interface ProductRepository extends CrudRepository<Product, Long> {

}
