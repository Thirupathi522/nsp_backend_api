package com.nlc.nps.dto;

import java.util.List;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.nlc.nps.entity.NpsTransactionEntity;

import lombok.Data;

@Data
public class NpsLineItemDTO {
    private int lineSeq;
    private String itemId;
    private List<String> descriptions;
    private int quantity;
    private double unitPrice;
    private double netTotal;
    private double total;
    private double discountTotal;
    private double vatTotal;

}
