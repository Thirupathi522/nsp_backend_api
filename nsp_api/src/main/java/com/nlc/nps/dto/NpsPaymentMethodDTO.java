package com.nlc.nps.dto;

import lombok.Data;

@Data
public class NpsPaymentMethodDTO {
    private String tenderId;
    private String tenderName;
    private double amount;
}
