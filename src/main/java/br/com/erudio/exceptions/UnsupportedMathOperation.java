package br.com.erudio.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)	//The annotation ResponseStatus() must be the same in the error handler declaration
public class UnsupportedMathOperation extends RuntimeException {
	private static final long serialVersionUID = 1L;
	
	public UnsupportedMathOperation(String message) {
		super(message);
	}
}