package com.nlc.nps.dto;
import java.util.List;

import lombok.Data;

@Data
public class NpsTrxCustomerDTO {
    private String firstName;
    private String lastName;
    private String airMileId;
    private List<String> phones;
    private List<String> emails;
    private NpsAddressDTO address;
}
