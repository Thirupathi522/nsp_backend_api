package com.nlc.nps.dto;
import java.util.List;

import lombok.Data;

@Data
public class NpsTransactionRequest {
    private NpsTrxCustomerDTO customer;
    private NpsPaymentDetailsDTO paymentDetails;
    private List<NpsLineItemDetailDTO> lineitemdetails;
    private NpsSummaryDTO summaries;
}
