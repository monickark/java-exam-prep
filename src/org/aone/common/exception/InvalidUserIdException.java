package org.aone.common.exception;

import org.aone.common.constant.ErrorCodeConstant;


public class InvalidUserIdException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String message = ErrorCodeConstant.INVALID_USERID;

	@Override
	public String getMessage() {
		return message;
	}

}
