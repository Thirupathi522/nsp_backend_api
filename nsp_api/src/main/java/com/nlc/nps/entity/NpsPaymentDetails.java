package com.nlc.nps.entity;
import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.Embeddable;

import lombok.Data;

@Embeddable
@Data
public class NpsPaymentDetails {

    @ElementCollection
    private List<NpsPaymentMethod> paymentMethods;

    private String paymentDate;
}
