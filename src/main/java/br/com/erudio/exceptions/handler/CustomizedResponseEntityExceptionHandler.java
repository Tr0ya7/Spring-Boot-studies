package br.com.erudio.exceptions.handler;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import br.com.erudio.exceptions.ExceptionResponse;	//My body exception created who returns a JSON
import br.com.erudio.exceptions.UnsupportedMathOperation;

//Errors handler, who determines what file is the corresponding error

@ControllerAdvice //Global treatment of errors if the error in specific is'nt treated
@RestController
public class CustomizedResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {
	@ExceptionHandler(Exception.class)	//This annotation show when this method is executed, in this case aways ocurrent a default Exception independent which your specific type
	public final ResponseEntity<ExceptionResponse> handleAllException(Exception ex, WebRequest request) {	//Method who return a ResponseEntity<ExceptionResponse> 
		ExceptionResponse exceptionResponse = new ExceptionResponse(new Date(), ex.getMessage(), request.getDescription(false));
		
		return new ResponseEntity<>(exceptionResponse, HttpStatus.INTERNAL_SERVER_ERROR);	//exceptionResponse is the return for the user		HttpStatus.INTERNAL_SERVER_ERROR is the type of error
	}
	
	@ExceptionHandler(UnsupportedMathOperation.class)
	public final ResponseEntity<ExceptionResponse> handleBadRequestException(Exception ex, WebRequest request) { 
		ExceptionResponse exceptionResponse = new ExceptionResponse(new Date(), ex.getMessage(), request.getDescription(false));
		
		return new ResponseEntity<>(exceptionResponse, HttpStatus.BAD_REQUEST);
	}
}