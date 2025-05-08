package com.nlc.nps.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nlc.nps.dto.NpsCashDealRequestDTO;
import com.nlc.nps.dto.NpsDealResponse;
import com.nlc.nps.entity.NpsCashDealEntity;
import com.nlc.nps.repository.NpsCashDealRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@RequiredArgsConstructor
public class NpsCashDealService {

	@Autowired
	private NpsCashDealRepository dealcashRepository;

	/*
	 * public NspDealService(NspDealRepository dealRepository) { this.dealRepository
	 * = dealRepository; }
	 */
	
	public List<NpsCashDealEntity> getAllDeals() {
		return dealcashRepository.findAll();
	}

	/*
	 * public Deal createDeal(Deal deal) { return dealRepository.save(deal); }
	 */

	public NpsDealResponse createDeal(NpsCashDealEntity dealRequestBody) {
		NpsCashDealEntity deal = new NpsCashDealEntity();
		deal.setDealName(dealRequestBody.getDealName());
		deal.setDealCalculationMethod(dealRequestBody.getDealCalculationMethod());
		deal.setDealCalculationMethodCode(dealRequestBody.getDealCalculationMethodCode());
		deal.setMinAmount(dealRequestBody.getMinAmount());
		deal.setMaxAmount(dealRequestBody.getMaxAmount());
		deal.setMinQty(dealRequestBody.getMinQty());
		deal.setMaxQty(dealRequestBody.getMaxQty());
		deal.setCustGroupId(dealRequestBody.getCustGroupId());
		
		dealcashRepository.save(deal);
		
		// Find all deals for the same custId
		List<NpsCashDealEntity> existingDeals = dealcashRepository.findByCustGroupId(dealRequestBody.getCustGroupId());

		double totalAmount = existingDeals.stream().mapToDouble(d -> d.getMaxAmount() != null ? d.getMaxAmount() : 0)
				.sum();

		// Return custom response
		return new NpsDealResponse(dealRequestBody.getCustGroupId(), totalAmount);
	}

	public NpsCashDealEntity getDealById(Long id) {
		return dealcashRepository.findById(id).orElseThrow(() -> new RuntimeException("Deal not found"));
	}

	public void deleteDeal(Long id) {
		dealcashRepository.deleteById(id);
	}

	public NpsCashDealEntity updateDeal(Long id, NpsCashDealRequestDTO dealRequest) {
		NpsCashDealEntity existing = getDealById(id);
		existing.setDealName(dealRequest.getDealName());
		existing.setDealId(dealRequest.getDealId());
		existing.setDealCalculationMethod(dealRequest.getDealCalculationMethod());
		existing.setDealCalculationMethodCode(dealRequest.getDealCalculationMethodCode());
		existing.setMaxAmount(dealRequest.getMaxAmount());
		existing.setMinAmount(dealRequest.getMinAmount());
		existing.setMaxQty(dealRequest.getMaxQty());
		existing.setMinQty(dealRequest.getMinQty());
		existing.setCustGroupId(dealRequest.getCustGroupId());
		return dealcashRepository.save(existing);
	}
}
