package com.micoservice.customerservice;

import com.micoservice.customerservice.model.Customer;
import com.micoservice.customerservice.repository.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CustomerServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CustomerServiceApplication.class, args);
	}

	@Bean
	CommandLineRunner start(CustomerRepository customerRepository){
		return args -> {
			customerRepository.save(new Customer(null,"Enset","contact@enset-media.ma"));
			customerRepository.save(new Customer(null, "FStM", "contact@fstm.ma"));
			customerRepository.save(new Customer(null, "ENSAM","contact@ensam.ma"));
			customerRepository.findAll().forEach(System.out::println);
		};
	}
}
