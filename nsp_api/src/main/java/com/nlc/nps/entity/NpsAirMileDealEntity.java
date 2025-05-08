package com.nlc.nps.entity;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Table(name = "NLC_AIR_MILE_ITEM")
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Data
public class NpsAirMileDealEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "airmile_seq_gen")
	@SequenceGenerator(name = "airmile_seq_gen", sequenceName = "NLC_AIRMILE_SEQ", allocationSize = 1)
	private Long orgId;

	private String itemId;

	private String airmailCalculationMethod;

	private BigDecimal airmailCalculationAction;

}
