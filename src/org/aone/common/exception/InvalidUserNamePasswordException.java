package org.aone.common.exception;

import org.aone.common.constant.ErrorCodeConstant;

public class InvalidUserNamePasswordException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String message = ErrorCodeConstant.INVALID_USERNAME_PASSWORD;

	@Override
	public String getMessage() {
		return message;
	}

}
