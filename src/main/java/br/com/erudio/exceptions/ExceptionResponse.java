package br.com.erudio.exceptions;

import java.io.Serializable;
import java.util.Date;

public class ExceptionResponse implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//Objective is return a JSON with this variables bellow
	private Date timestamp;	//Time of the occurrence of error
	private String message;	//Error message
	private String details;	//Error details
	
	public ExceptionResponse(Date timestamp, String message, String details) {
		this.timestamp = timestamp;
		this.message = message;
		this.details = details;
	}

	public Date getTimestamp() {
		return timestamp;
	}

	public String getMessage() {
		return message;
	}

	public String getDetails() {
		return details;
	}
}