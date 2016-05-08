package com.clw.romannumerals;

public class RomanNumeralBean {
	
	int arabicNum;
	String romanNum;

	public RomanNumeralBean(int i, String romanNumeral) {
		super();
		this.arabicNum = i;
		this.romanNum = romanNumeral;
	}

	public int getArabicNum() {
		return arabicNum;
	}

	public void setArabicNum(int arabicNum) {
		this.arabicNum = arabicNum;
	}

	public String getRomanNum() {
		return romanNum;
	}

	public void setRomanNum(String romanNum) {
		this.romanNum = romanNum;
	}

	
	

}
