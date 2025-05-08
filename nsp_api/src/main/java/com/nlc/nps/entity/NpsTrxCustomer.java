package com.nlc.nps.entity;
import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.Embeddable;
import javax.persistence.Embedded;

import lombok.Data;

@Embeddable
@Data
public class NpsTrxCustomer {

    private String firstName;
    private String lastName;
    private String airMileId;

    @ElementCollection
    private List<String> phones;

    @ElementCollection
    private List<String> emails;

    @Embedded
    private NpsAddress address;
}
