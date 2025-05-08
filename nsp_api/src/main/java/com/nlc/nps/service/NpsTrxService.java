package com.nlc.nps.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nlc.nps.dto.NpsLineItemDTO;
import com.nlc.nps.entity.NpsLineItem;
import com.nlc.nps.entity.NpsTransactionEntity;
import com.nlc.nps.repository.NpsTrxRepository;

@Service
public class NpsTrxService {

    @Autowired
    private NpsTrxRepository nspTrxRepository;

    // CREATE
    public NpsTransactionEntity createTransaction(NpsTransactionEntity entity) {
        return nspTrxRepository.save(entity);
    }

	/*
	 * // READ ALL public List<NspTransactionEntity> getAllTransactions() { return
	 * nspTrxRepository.findAll(); }
	 * 
	 * // READ ONE public Optional<NspTransactionEntity> getTransactionById(Long id)
	 * { return nspTrxRepository.findById(id); }
	 * 
	 * // UPDATE public Optional<NspTransactionEntity> updateTransaction(Long id,
	 * NspTransactionEntity updatedEntity) { return
	 * nspTrxRepository.findById(id).map(existing -> { for (NspLineItem existingItem
	 * : existing.getLineitemdetails()) { // selectively update fields instead of
	 * recreating the entity } return nspTrxRepository.save(existing); });
	 * 
	 * }
	 * 
	 * // DELETE public boolean deleteTransaction(Long id) { return
	 * nspTrxRepository.findById(id).map(entity -> {
	 * nspTrxRepository.delete(entity); return true; }).orElse(false); }
	 */
}
