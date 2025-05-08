package com.nlc.nps.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.nlc.nps.dto.NpsLineItemDTO;

import lombok.Data;

@Entity
@Table(name = "nlc_transaction")
@Data
public class NpsTransactionEntity {
	
	@OneToMany(mappedBy = "transaction", cascade = CascadeType.ALL)
    private List<NpsLineItem> lineitemdetails;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

    @Embedded
    private NpsTrxCustomer customer;

    @Embedded
    private NpsPaymentDetails paymentDetails;
    private Long trxSeq;

    
	public void setLineitemdetails(List<NpsLineItem> lineitemdetails) {
		this.lineitemdetails = lineitemdetails;
	}
    
    @Embedded
    private NpsSummary summary;
}
