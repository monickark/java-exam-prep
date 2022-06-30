package org.aone.common.exception;

import org.aone.common.constant.ErrorCodeConstant;



public class DuplicateEntryException extends Exception {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String message = ErrorCodeConstant.DUPLICATE_ENTRY;

	public String getMessage() {
		return message;
	}

	
}
