package com.micoservice.billingservice;

import com.micoservice.billingservice.model.Bill;
import com.micoservice.billingservice.model.Customer;
import com.micoservice.billingservice.model.Product;
import com.micoservice.billingservice.model.ProductItem;
import com.micoservice.billingservice.repository.BillRepository;
import com.micoservice.billingservice.repository.ProductItemRepository;
import com.micoservice.billingservice.service.CustomerServiceClient;
import com.micoservice.billingservice.service.InventoryServiceClient;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.hateoas.PagedModel;

import java.util.Date;

@SpringBootApplication
@EnableFeignClients
public class BillingServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(BillingServiceApplication.class, args);
	}

	@Bean
	CommandLineRunner start(BillRepository billRepository, ProductItemRepository productItemRepository, CustomerServiceClient customerServiceClient, InventoryServiceClient inventoryServiceClient){

		return args->{
			Customer customer=customerServiceClient.findCustomerById(1L);
			Bill bill1=billRepository.save(new Bill(null, new Date(),null, customer.getId(),customer));
			PagedModel<Product> products=inventoryServiceClient.findAll();
			products.getContent().forEach(
					product -> {
						productItemRepository.save(new ProductItem(null, product.getId(), product.getPrice(),30,bill1,product));
					});

		};
	}

}
