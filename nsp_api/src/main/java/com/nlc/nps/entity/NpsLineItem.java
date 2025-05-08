package com.nlc.nps.entity;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "trn_line_items")
@Data
public class NpsLineItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "trx_seq")
    private NpsTransactionEntity transaction;

    
    //private int trxSeq;
    private int lineSeq;
    private String itemId;

    @ElementCollection
    private List<String> descriptions;

    private int quantity;
    private double unitPrice;
    private double netTotal;
    private double total;
    private double discountTotal;
    private double vatTotal;
}
