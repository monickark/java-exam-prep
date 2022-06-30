package org.aone.common.exception;

import org.aone.common.constant.ErrorCodeConstant;


public class UpdateFailedException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String message = ErrorCodeConstant.UPDATE_FAILED;

	public String getMessage() {
		return message;
	}

}
