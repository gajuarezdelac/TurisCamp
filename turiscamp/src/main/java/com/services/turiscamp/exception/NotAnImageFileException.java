package com.services.turiscamp.exception;

public class NotAnImageFileException extends Exception {
    
	private static final long serialVersionUID = 1L;

	public NotAnImageFileException(String message) {
        super(message);
    }
}