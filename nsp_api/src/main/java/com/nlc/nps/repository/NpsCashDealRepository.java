package com.nlc.nps.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nlc.nps.entity.NpsCashDealEntity;

public interface NpsCashDealRepository extends JpaRepository<NpsCashDealEntity, Long> {
	List<NpsCashDealEntity> findByCustGroupId(Integer custGroupId);
}