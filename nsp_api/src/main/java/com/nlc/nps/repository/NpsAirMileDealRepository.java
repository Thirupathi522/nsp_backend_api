package com.nlc.nps.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nlc.nps.entity.NpsAirMileDealEntity;

public interface NpsAirMileDealRepository extends JpaRepository<NpsAirMileDealEntity, Long> {

	public Optional<NpsAirMileDealEntity> findByItemId(String itemId);
}
