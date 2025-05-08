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

import com.nlc.nps.dto.NpsAirMileRequestDTO;
import com.nlc.nps.service.NpsAirMileDealService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/api/airmile")
@Tag(name = "NLC AirMile API", description = "Operations related to AirMile")
public class NpsAirMileDealController {

	@Autowired
	private NpsAirMileDealService service;

	@PostMapping
	@Operation(summary = "Define the new Air Mile line item")
	public ResponseEntity<NpsAirMileRequestDTO> createDeal(@RequestBody NpsAirMileRequestDTO dto) {
		return ResponseEntity.ok(service.save(dto));
	}

	@GetMapping
	@Operation(summary = "get all Air Mile line items")
	public ResponseEntity<List<NpsAirMileRequestDTO>> getAllDeals() {
		return ResponseEntity.ok(service.findAll());
	}

	@GetMapping("/{id}")
	@Operation(summary = "get the Air Mile line items by ID")
	public ResponseEntity<NpsAirMileRequestDTO> getDealById(@PathVariable Long id) {
		return service.findById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
	}

	@PutMapping("/{id}")
	@Operation(summary = "update the Air Mile line item by ID")
	public ResponseEntity<NpsAirMileRequestDTO> updateDeal(@PathVariable Long id,
			@RequestBody NpsAirMileRequestDTO dto) {
		if (!service.findById(id).isPresent()) {
			return ResponseEntity.notFound().build();
		}
		dto.setOrgId(id);
		return ResponseEntity.ok(service.save(dto));
	}

	@DeleteMapping("/{id}")
	@Operation(summary = "Delete the Air Mile line items")
	public ResponseEntity<Void> deleteDeal(@PathVariable Long id) {
		if (!service.findById(id).isPresent()) {
			return ResponseEntity.notFound().build();
		}
		service.deleteById(id);
		return ResponseEntity.noContent().build();
	}

	@GetMapping("/item/{itemId}")
	@Operation(summary = "get the Air Mile line item by Item ID")
	public ResponseEntity<NpsAirMileRequestDTO> getDealByItemId(@PathVariable String itemId) {
		return service.findByItemId(itemId).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
	}

}
