package com.nlc.nps.dto;
import java.util.List;

import lombok.Data;

@Data
public class NpsPaymentDetailsDTO {
    private List<NpsPaymentMethodDTO> paymentMethods;
    private String paymentDate;
}
