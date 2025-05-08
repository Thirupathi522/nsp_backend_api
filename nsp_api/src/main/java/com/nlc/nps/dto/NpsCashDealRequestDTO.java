package com.nlc.nps.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class NpsCashDealRequestDTO {
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
