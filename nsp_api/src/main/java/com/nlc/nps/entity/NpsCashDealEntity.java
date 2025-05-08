package com.nlc.nps.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name = "NLC_DEAL")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class NpsCashDealEntity {

	// @Column(name = "DEAL_ID")
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "deal_seq_gen")
	@SequenceGenerator(name = "deal_seq_gen", sequenceName = "NLC_DEAL_SEQ", allocationSize = 1)
	private Long dealId;

	private String dealName;

	private String dealCalculationMethod;

	private String dealCalculationMethodCode;

	private Double minAmount;

	private Double maxAmount;

	private Integer minQty;

	private Integer maxQty;

	private Integer custGroupId;

}
