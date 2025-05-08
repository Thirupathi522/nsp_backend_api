package com.nlc.nps.dto;

import java.math.BigDecimal;

import lombok.Data;


//@Builder
@Data
public class NpsAirMileRequestDTO {

	private Long orgId;

	private String itemId;

	private String airmailCalculationMethod;

	private BigDecimal airmailCalculationAction;
}
