package com.micoservice.billingservice.service;

import com.micoservice.billingservice.model.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.hateoas.PagedModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name="inventory-service")
public interface InventoryServiceClient {
@GetMapping("/products/{id}?projection=fullProduct")
    Product findProductById(@PathVariable("id") Long id);
@GetMapping("/products?projection=fullProduct")
    PagedModel<Product> findAll();
}
