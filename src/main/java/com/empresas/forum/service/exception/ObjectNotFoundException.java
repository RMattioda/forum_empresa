package com.empresas.forum.service.exception;

public class ObjectNotFoundException extends RuntimeException{
	private static final long serialVersionUID = 8704863188855825106L;

	public ObjectNotFoundException(String msg) {
		super(msg);
	}
	
	public ObjectNotFoundException(String msg, Throwable cause) {
		super(msg, cause);
	}
}
