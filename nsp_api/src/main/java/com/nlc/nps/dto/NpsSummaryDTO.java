package com.nlc.nps.dto;

import lombok.Data;

@Data
public class NpsSummaryDTO {
    private double totalNetAmount;
    private double totalVATAmount;
    private double totalGrossAmount;
    private double totaldiscountAmount;
}
