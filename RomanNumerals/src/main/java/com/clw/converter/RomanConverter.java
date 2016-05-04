package com.clw.converter;


public class RomanConverter implements Converter {

	    private RomanConverterMap romanConvertorMap;

	    public RomanConverter(RomanConverterMap romanConvertorMap) {
	        this.romanConvertorMap = romanConvertorMap;
	    }
	    
	    public String convert(String number) {
			return recursiveTranslation(Integer.parseInt(number)) + "";
		}

	    private StringBuilder recursiveTranslation(int number) {
	    	StringBuilder sb = new StringBuilder();
	    	while(number > 0){
	    		int betterTranslation = getBetterTranslation(number + "");
		        sb.append(getTranslation(betterTranslation));
		        number -= betterTranslation;
	    	}
	    	return sb;

	    }
	    
	    private String getTranslation(int betterTranslation) {
	        return romanConvertorMap.getTranslationFor(betterTranslation + "");
	    }

	    private int getBetterTranslation(String arabicNumber) {
	        return romanConvertorMap.getBetterTranslation(arabicNumber);
	    }

}
