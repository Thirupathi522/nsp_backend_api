package com.nlc.nps.entity;
import javax.persistence.Embeddable;

import lombok.Data;

@Embeddable
@Data
public class NpsPaymentMethod {
    private String tenderId;
    private String tenderName;
    private double amount;
}
