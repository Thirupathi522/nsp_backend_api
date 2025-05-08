package com.nlc.nps.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class NpsCustomerRequestDTO {

	private Long custId;

	private String firstName;
	private String middleName;
	private String lastName;
	private String custEmail;
	private String custPhone;
	private String custAccountId;
	private String custAirmileId;

}
