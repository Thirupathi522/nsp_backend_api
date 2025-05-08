package com.nlc.nps.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class NpsDealResponse {

	private Integer custGroupId;
	private Double totalAmount;

}
