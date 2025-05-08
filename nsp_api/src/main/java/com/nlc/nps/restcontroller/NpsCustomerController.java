package com.nlc.nps.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nlc.nps.entity.NpsCustomerEntity;
import com.nlc.nps.service.NpsCustomerService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/nlc/customers")
@Tag(name = "NLC Customer API", description = "Operations related to Customer management")
public class NpsCustomerController {

	@Autowired
	private NpsCustomerService customerService;

	@Operation(summary = "Get all customers")
	@GetMapping(value = "/getAllCustomers")
	public List<NpsCustomerEntity> getAllCustomers() {
		return customerService.getAllCustomers();
	}

	@Operation(summary = "Get a customer by ID")
	@GetMapping("/{id}")
	public NpsCustomerEntity getCustomerById(@PathVariable Long id) {
		return customerService.getCustomerById(id);
	}

	@Operation(summary = "Create a new customer")
	@PostMapping(value = "/createCustomer")
	public NpsCustomerEntity createCustomer(@RequestBody NpsCustomerEntity customer) {
		return customerService.createCustomer(customer);
	}

	@Operation(summary = "Update an existing customer")
	@PutMapping("/{id}")
	public NpsCustomerEntity updateCustomer(@PathVariable Long id, @RequestBody NpsCustomerEntity customer) {
		return customerService.updateCustomer(id, customer);
	}

	@Operation(summary = "Delete a customer")
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteCustomer(@PathVariable Long id) {
		customerService.deleteCustomer(id);
		return ResponseEntity.noContent().build();
	}

}