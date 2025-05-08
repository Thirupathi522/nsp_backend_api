package com.nlc.nps.entity;

import javax.persistence.Embeddable;

import lombok.Data;

@Embeddable
@Data
public class NpsSummary {

    private Double totalNetAmount;
    private Double totalVATAmount;
    private Double totalGrossAmount;
    private Double totaldiscountAmount;

}
