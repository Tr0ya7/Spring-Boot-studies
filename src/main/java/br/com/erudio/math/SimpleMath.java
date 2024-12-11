package br.com.erudio.math;

import org.springframework.web.bind.annotation.PathVariable;

import br.com.erudio.converters.NumberConverter;
import br.com.erudio.exceptions.UnsupportedMathOperation;

public class SimpleMath {
	public static Double math(String operation, Double numOne, Double numTwo) {	// Method who receives PathVariable
		switch (operation) {
			case "sum":
				return numOne + numTwo;
			case "subtraction":
				return numOne - numTwo;
			case "multiplication":
				return numOne * numTwo;
			case "division":
				return numOne / numTwo;
			case "mean":
				return (numOne + numTwo) / 2;
			case "squareRoot":
				return Math.sqrt(numOne);
			default:
				throw new UnsupportedMathOperation("Something goes wrong!");
		}
	}
}