package com.nlc.nps.entity;

import java.util.List;

import com.nlc.nps.dto.NpsLineItemDTO;
import com.nlc.nps.dto.NpsPaymentDetailsDTO;
import com.nlc.nps.dto.NpsSummaryDTO;
import com.nlc.nps.dto.NpsTrxCustomerDTO;

import lombok.Data;

@Data
public class NpsTransactionRequest {
	
	private NpsTrxCustomerDTO customer;
    private NpsPaymentDetailsDTO paymentDetails;
    private List<NpsLineItemDTO> lineitemdetails;
    private NpsSummaryDTO summary;
}

