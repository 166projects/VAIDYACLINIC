package com.mphasis.training.Exception;

public class BusinessException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public BusinessException(String string) {
		super(string);
	}
}
