package com.nlc.nps.NspMapper;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.nlc.nps.dto.NpsAddressDTO;
import com.nlc.nps.entity.NpsAddress;
import com.nlc.nps.entity.NpsLineItem;
import com.nlc.nps.entity.NpsPaymentDetails;
import com.nlc.nps.entity.NpsPaymentMethod;
import com.nlc.nps.entity.NpsSummary;
import com.nlc.nps.entity.NpsTransactionEntity;
import com.nlc.nps.entity.NpsTransactionRequest;
import com.nlc.nps.entity.NpsTrxCustomer;

@Component
public class NpsTransactionMapper {

	public NpsTransactionEntity dtoToEntity(NpsTransactionRequest dto) {
	    NpsTransactionEntity entity = new NpsTransactionEntity();

	    // Map Customer
	    NpsTrxCustomer customer = new NpsTrxCustomer();
	    customer.setFirstName(dto.getCustomer().getFirstName());
	    customer.setLastName(dto.getCustomer().getLastName());
	    customer.setAirMileId(dto.getCustomer().getAirMileId());
	    customer.setPhones(dto.getCustomer().getPhones());
	    customer.setEmails(dto.getCustomer().getEmails());

	    NpsAddressDTO dtoAddress = dto.getCustomer().getAddress();
	    if (dtoAddress != null) {
	        NpsAddress address = new NpsAddress();
	        address.setCountryCode(dtoAddress.getCountryCode());
	        address.setCity(dtoAddress.getCity());
	        address.setStreet(dtoAddress.getStreet());
	        address.setPostal(dtoAddress.getPostal());
	        customer.setAddress(address);
	    }

	    entity.setCustomer(customer);

	    // Map Payment Details
	    NpsPaymentDetails paymentDetails = new NpsPaymentDetails();
	    paymentDetails.setPaymentDate(dto.getPaymentDetails().getPaymentDate());

	    List<NpsPaymentMethod> paymentMethods = dto.getPaymentDetails().getPaymentMethods().stream().map(pmDto -> {
	        NpsPaymentMethod pm = new NpsPaymentMethod();
	        pm.setTenderId(pmDto.getTenderId());
	        pm.setTenderName(pmDto.getTenderName());
	        pm.setAmount(pmDto.getAmount());
	        return pm;
	    }).collect(Collectors.toList());

	    paymentDetails.setPaymentMethods(paymentMethods);
	    entity.setPaymentDetails(paymentDetails);

	    List<NpsLineItem> lineItems = dto.getLineitemdetails().stream().map(liDto -> {
	        NpsLineItem li = new NpsLineItem();
	        li.setLineSeq(liDto.getLineSeq());
	        li.setItemId(liDto.getItemId());
	        li.setDescriptions(liDto.getDescriptions());
	        li.setQuantity(liDto.getQuantity());
	        li.setUnitPrice(liDto.getUnitPrice());
	        li.setNetTotal(liDto.getNetTotal());
	        li.setTotal(liDto.getTotal());
	        li.setDiscountTotal(liDto.getDiscountTotal());
	        li.setVatTotal(liDto.getVatTotal());
	        li.setTransaction(entity);
	        return li;
	    }).collect(Collectors.toList());

	    entity.setLineitemdetails(lineItems); 


	    // Map Summary
	    if (dto.getSummary() != null) {
	        NpsSummary summary = new NpsSummary();
	        summary.setTotalNetAmount(dto.getSummary().getTotalNetAmount());
	        summary.setTotalVATAmount(dto.getSummary().getTotalVATAmount());
	        summary.setTotalGrossAmount(dto.getSummary().getTotalGrossAmount());
	        summary.setTotaldiscountAmount(dto.getSummary().getTotaldiscountAmount());
	        entity.setSummary(summary);
	    }

	    return entity;
	}

}
