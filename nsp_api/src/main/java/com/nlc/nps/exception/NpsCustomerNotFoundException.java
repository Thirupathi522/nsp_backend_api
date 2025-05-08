package com.nlc.nps.exception;
public class NpsCustomerNotFoundException extends RuntimeException {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public NpsCustomerNotFoundException(String message) {
        super(message);
    }
}