package com.micoservice.billingservice.service;

import com.micoservice.billingservice.model.Bill;
import com.micoservice.billingservice.repository.BillRepository;
import com.micoservice.billingservice.repository.ProductItemRepository;
import com.netflix.discovery.converters.Auto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.core.config.Projection;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BillRestController {
    @Autowired
private BillRepository billRepository;
@Autowired
    private ProductItemRepository productItemRepository;
@Autowired
private CustomerServiceClient customerServiceClient;
@Autowired
private InventoryServiceClient inventoryServiceClient;

@GetMapping("/fullBill/{id}")
public Bill getBill(@PathVariable(name="id") Long id){
    Bill bill=billRepository.findById(id).get();
  bill.setCustomer(customerServiceClient.findCustomerById(bill.getId()));
    bill.getProductItem().forEach(p1->{
        p1.setProduct(inventoryServiceClient.findProductById(p1.getProductID()));
    });
    return bill;
}
}
