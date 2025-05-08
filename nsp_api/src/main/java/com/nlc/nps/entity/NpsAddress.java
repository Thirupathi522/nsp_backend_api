package com.nlc.nps.entity;
import javax.persistence.Embeddable;

import lombok.Data;

@Embeddable
@Data
public class NpsAddress {
    private String countryCode;
    private String city;
    private String street;
    private String postal;
}
