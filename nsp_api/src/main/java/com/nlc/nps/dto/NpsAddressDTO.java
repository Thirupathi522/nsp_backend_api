package com.nlc.nps.dto;

import lombok.Data;

@Data
public class NpsAddressDTO {
    private String countryCode;
    private String city;
    private String street;
    private String postal;
}
