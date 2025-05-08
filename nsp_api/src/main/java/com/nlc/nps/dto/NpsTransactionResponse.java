package com.nlc.nps.dto;

import java.math.BigDecimal;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NpsTransactionResponse {
	private String airMileId;
	private List<AirMilePoints> airMilePoints;

	@Data
	@AllArgsConstructor
	@NoArgsConstructor
	public static class AirMilePoints {
		private String itemId;
		private int quantity;
		private BigDecimal totalPoints;
	}
}
