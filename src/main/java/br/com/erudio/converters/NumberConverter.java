package br.com.erudio.converters;

public class NumberConverter {
	public static Double convertToDouble(String num) {
		if (num == null) return 0D;
		
		String number = num.replaceAll(",", ".");	// BR 10,25		US 10.25
		return Double.parseDouble(num);
	}
	
	public static boolean isNumeric(String num) {	// Method who receives a string value
		if (num == null) return false;
		
		return num.matches("[-+]?[0-9]*\\.?[0-9]+");
	}
}