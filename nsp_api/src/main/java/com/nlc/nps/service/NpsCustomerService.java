package com.nlc.nps.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nlc.nps.entity.NpsCustomerEntity;
import com.nlc.nps.exception.NpsCustomerNotFoundException;
import com.nlc.nps.repository.NpsCustomerRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@RequiredArgsConstructor
public class NpsCustomerService {

	@Autowired
	private NpsCustomerRepository customerRepository;

	/*
	 * NspCustomerService(NspCustomerRepository customerRepository) {
	 * this.customerRepository = customerRepository; }
	 */

	public List<NpsCustomerEntity> getAllCustomers() {
		return customerRepository.findAll();
	}

	public NpsCustomerEntity getCustomerById(Long id) {
		return customerRepository.findById(id)
				.orElseThrow(() -> new NpsCustomerNotFoundException("Customer not found with id: " + id));
	}

	public NpsCustomerEntity createCustomer(NpsCustomerEntity customer) {
		return customerRepository.save(customer);
	}

	public NpsCustomerEntity updateCustomer(Long id, NpsCustomerEntity updatedCustomer) {
		NpsCustomerEntity existing = getCustomerById(id);
		existing.setFirstName(updatedCustomer.getFirstName());
		existing.setMiddleName(updatedCustomer.getMiddleName());
		existing.setLastName(updatedCustomer.getLastName());
		existing.setCustEmail(updatedCustomer.getCustEmail());
		existing.setCustPhone(updatedCustomer.getCustPhone());
		existing.setCustAccountId(updatedCustomer.getCustAccountId());
		existing.setCustAirmileId(updatedCustomer.getCustAirmileId());
		return customerRepository.save(existing);
	}

	public void deleteCustomer(Long id) {
		if (!customerRepository.existsById(id)) {
			throw new NpsCustomerNotFoundException("Customer not found with id: " + id);
		}
		customerRepository.deleteById(id);
	}
}
