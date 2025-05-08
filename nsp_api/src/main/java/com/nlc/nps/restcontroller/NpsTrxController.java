package com.nlc.nps.restcontroller;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nlc.nps.NspMapper.NpsTransactionMapper;
import com.nlc.nps.dto.NpsAirMileRequestDTO;
import com.nlc.nps.dto.NpsTransactionResponse;
import com.nlc.nps.entity.NpsLineItem;
import com.nlc.nps.entity.NpsTransactionEntity;
import com.nlc.nps.entity.NpsTransactionRequest;
import com.nlc.nps.service.NpsAirMileDealService;
import com.nlc.nps.service.NpsTrxService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/api/transaction")
@Tag(name = "NLC Create Trx API", description = "Operations related to Sale Trx")
public class NpsTrxController {
	
	private static final Logger LOGGER = LogManager.getLogger(NpsTrxController.class);
	 
	 

	@Autowired
	private NpsTrxService trxService;

	@Autowired
	private NpsTransactionMapper mapper;

	@Autowired
	private NpsAirMileDealService airMileservice;

	/*
	 * @PostMapping public ResponseEntity<String> createInvoice(@RequestBody
	 * NspTransactionRequest request){ NspTransactionEntity entity =
	 * mapper.dtoToEntity(request); trxService.createTransaction(entity); return
	 * ResponseEntity.ok("Invoice created"); }
	 */

	@PostMapping
	@Operation(summary = "Create a new sale trx in NPS")
	public ResponseEntity<NpsTransactionResponse> createInvoice(@RequestBody NpsTransactionRequest request) {
		NpsTransactionEntity entity = mapper.dtoToEntity(request);

		// Save the transaction
		NpsTransactionEntity savedEntity = trxService.createTransaction(entity);

		List<NpsTransactionResponse.AirMilePoints> airMilePointsList = new ArrayList<>();

		for (NpsLineItem item : savedEntity.getLineitemdetails()) {
			String itemId = item.getItemId();
			int qty = item.getQuantity();
			BigDecimal quantity = BigDecimal.valueOf((double) qty);

			// Fetch the air mile deal by itemId
			Optional<NpsAirMileRequestDTO> dealOpt = airMileservice.findByItemId(itemId);
			
			LOGGER.info("Air Mile Item Id"+dealOpt);

			if (dealOpt.isPresent()) {
				BigDecimal factor = new BigDecimal("10.00");

				BigDecimal airmailAction = dealOpt.get().getAirmailCalculationAction();
				BigDecimal actualDealAmt = airmailAction.multiply(quantity);

				BigDecimal totalPointsForLineItem = BigDecimal.ZERO;
				if (actualDealAmt.compareTo(BigDecimal.ZERO) != 0) {
					totalPointsForLineItem = roundFractional(actualDealAmt.multiply(factor), 2, RoundingMode.HALF_UP);
				}

				airMilePointsList.add(new NpsTransactionResponse.AirMilePoints(itemId, qty, totalPointsForLineItem));
			}
		}

		NpsTransactionResponse response = new NpsTransactionResponse(savedEntity.getCustomer().getAirMileId(),
				airMilePointsList);

		return ResponseEntity.ok(response);
	}

	public static BigDecimal roundFractional(BigDecimal value, int scale, RoundingMode roundingMode) {
		if (value == null) {
			return BigDecimal.ZERO;
		}
		return value.setScale(scale, roundingMode);
	}

	public static BigDecimal nonNull(BigDecimal value) {
		return value != null ? value : BigDecimal.ZERO;
	}

	/*
	 * @GetMapping public ResponseEntity<List<NspTransactionEntity>>
	 * getAllInvoices() { return ResponseEntity.ok(trxService.getAllTransactions());
	 * }
	 * 
	 * @GetMapping("/{id}") public ResponseEntity<NspTransactionEntity>
	 * getInvoiceById(@PathVariable Long id) { return
	 * trxService.getTransactionById(id) .map(ResponseEntity::ok)
	 * .orElse(ResponseEntity.notFound().build()); }
	 * 
	 * @PutMapping("/{id}") public ResponseEntity<NspTransactionEntity>
	 * updateInvoice(@PathVariable Long id, @RequestBody NspTransactionEntity
	 * request) { return trxService.updateTransaction(id, request)
	 * .map(ResponseEntity::ok) .orElse(ResponseEntity.notFound().build()); }
	 * 
	 * @DeleteMapping("/{id}") public ResponseEntity<Void>
	 * deleteInvoice(@PathVariable Long id) { boolean deleted =
	 * trxService.deleteTransaction(id); return deleted ?
	 * ResponseEntity.noContent().build() : ResponseEntity.notFound().build(); }
	 */
}
