package org.aone.common.exception;


public class DeleteFailedException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String message = "DELETE_FAILED";

	public String getMessage() {
		return message;
	}

}
