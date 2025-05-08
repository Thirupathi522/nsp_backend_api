package com.nlc.nps.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name = "NLC_CUSTOMER")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class NpsCustomerEntity {

	// @Column(name = "CUST_ID")
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "customer_seq_gen")
	@SequenceGenerator(name = "customer_seq_gen", sequenceName = "NLC_CUSTOMER_SEQ", allocationSize = 1)
	private String custId;

	private String firstName;
	private String middleName;
	private String lastName;
	private String custEmail;
	private String custPhone;
	private String custAccountId;
	private String custAirmileId;


}
