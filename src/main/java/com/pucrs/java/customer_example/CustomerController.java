package com.pucrs.java.customer_example;

import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class CustomerController {
	private final CustomerRepository customers;
	
	public CustomerController(CustomerRepository customers) {
		super();
		this.customers = customers;
	}
	
	@GetMapping("/customers/{id}")
	public String listAllCustomers(@PathVariable Long id, Model model) {
		Optional<Customer> c = customers.findById(id);
		model.addAttribute("customer", c.get());
		return "customerDetails";
	}
}
