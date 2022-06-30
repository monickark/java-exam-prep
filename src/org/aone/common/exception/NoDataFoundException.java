package org.aone.common.exception;

import org.aone.common.constant.ErrorCodeConstant;


public class NoDataFoundException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String message = ErrorCodeConstant.NO_RECORD_FOUND;

	public String getMessage() {
		return message;
	}


}
