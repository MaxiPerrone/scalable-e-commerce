package com.springcloud.ecommerce.products.service;

import java.util.List;
import java.util.Optional;

import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.springcloud.ecommerce.products.domain.Product;
import com.springcloud.ecommerce.products.repository.ProductRepository;
import com.springcloud.ecommerce.products.view.ProductResponse;
import com.springcloud.ecommerce.products.view.ProductsResponse;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository repository;
    private final Environment environment;

    public ProductServiceImpl(ProductRepository repository, Environment environment) {
        this.repository = repository;
        this.environment = environment;
    }

    @Override
    @Transactional(readOnly = true)
    public ProductsResponse findAll() {
        List<Product> products = (List<Product>) repository.findAll();

        ProductsResponse response = new ProductsResponse();
        response.setProducts(products.stream().map(this::productResponse).toList());
        return response;
    }

    @Override
    @Transactional(readOnly = true)
    public ProductResponse findById(Long id) {
        Optional<Product> optionalProduct = repository.findById(id);

        if (optionalProduct.isPresent()) {
            Product product = optionalProduct.get();
            return productResponse(product);
        }
                    
        return null;
    }
            
    private ProductResponse productResponse(Product product) {
        ProductResponse response = new ProductResponse();
        response.setId(product.getId());
        response.setName(product.getName());
        response.setPrice(product.getPrice());
        response.setCreatedTime(product.getCreateAt());
        response.setPort(environment.getProperty("local.server.port"));
        return response;
    }
}
