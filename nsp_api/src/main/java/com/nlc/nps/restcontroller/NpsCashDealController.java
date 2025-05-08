package com.nlc.nps.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nlc.nps.dto.NpsCashDealRequestDTO;
import com.nlc.nps.dto.NpsDealResponse;
import com.nlc.nps.entity.NpsCashDealEntity;
import com.nlc.nps.service.NpsCashDealService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/api/deals")
@Tag(name = "NLC Cash Deal API", description = "Operations related to Deals")
public class NpsCashDealController {

	@Autowired
	private NpsCashDealService dealCashService;

	/*
	 * public NspDealController(NspDealService dealService) { this.dealService =
	 * dealService; }
	 */

	@GetMapping("/getAllDeals")
	@Operation(summary = "Get all deals")
	public List<NpsCashDealEntity> getAllDeals() {
		return dealCashService.getAllDeals();
	}

	@PostMapping
	@Operation(summary = "Create a new deal")
	public ResponseEntity<NpsDealResponse> createDeal(@RequestBody NpsCashDealEntity dealRequestBody) {
		NpsDealResponse response = dealCashService.createDeal(dealRequestBody);
		return new ResponseEntity<>(response, HttpStatus.CREATED);
	}

	@Operation(summary = "Update an existing Deal")
	@PutMapping("/{id}")
	public NpsCashDealEntity updateDeal(@PathVariable Long id, @RequestBody NpsCashDealRequestDTO dealRequest) {
		return dealCashService.updateDeal(id, dealRequest);
	}

	@GetMapping("/{getDealById}")
	@Operation(summary = "Get a deals by ID")
	public NpsCashDealEntity getDealById(@PathVariable Long getDealById) {
		return dealCashService.getDealById(getDealById);
	}

	@DeleteMapping("/{id}")
	@Operation(summary = "Delete a deals")
	public ResponseEntity<Void> deleteDeal(@PathVariable Long id) {
		dealCashService.deleteDeal(id);
		return ResponseEntity.noContent().build();
	}
}
