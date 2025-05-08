package com.nlc.nps.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nlc.nps.entity.NpsTransactionEntity;

@Repository
public interface NpsTrxRepository extends JpaRepository<NpsTransactionEntity, Long> {
	
}
