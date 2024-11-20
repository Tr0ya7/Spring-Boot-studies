package br.com.erudio.controllers;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.erudio.converters.NumberConverter;
import br.com.erudio.exceptions.UnsupportedMathOperation;
import br.com.erudio.math.SimpleMath;

@RestController
public class MathController {
	private final AtomicLong counter = new AtomicLong();
	private SimpleMath simpleMath = new SimpleMath();
	
	@RequestMapping(value = "/{operation}/{numOne}/{numTwo}", method=RequestMethod.GET)
	public Double calculator(@PathVariable(value = "operation") String operation, @PathVariable(value = "numOne") String numOne, @PathVariable(value = "numTwo") String numTwo) throws Exception {	// Method who receives PathVariable
		if(!NumberConverter.isNumeric(numOne) || !NumberConverter.isNumeric(numTwo)) throw new UnsupportedMathOperation("Please set a numeric value!");	//Error setted in annotation in error handler file
		
		return simpleMath.math(operation, NumberConverter.convertToDouble(numOne), NumberConverter.convertToDouble(numTwo));
	};
}

// @PathVariable == take informations/data from url
// @RequestParam(value = "name") is the same as "?name=" in url