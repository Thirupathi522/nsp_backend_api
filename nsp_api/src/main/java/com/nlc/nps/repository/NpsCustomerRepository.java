package com.nlc.nps.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nlc.nps.entity.NpsCustomerEntity;
@Repository
public interface NpsCustomerRepository extends JpaRepository<NpsCustomerEntity, Long> {
    Optional<NpsCustomerEntity> findByCustEmail(String custEmail);
}
