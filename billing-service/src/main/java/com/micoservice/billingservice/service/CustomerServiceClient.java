package com.micoservice.billingservice.service;

import com.micoservice.billingservice.model.Customer;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name="customer-service")
public interface CustomerServiceClient {

    @GetMapping("/customers/{id}")
    Customer findCustomerById(@PathVariable(name="id") Long id);
}
