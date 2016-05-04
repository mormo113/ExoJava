package com.clw.converter;


public final class ConverterFactory {

	private ConverterFactory() {
	}

	private static RomanConverterMap romanConvertorMap = new RomanConverterMap();

	public static Converter getRomanConvertor() {
		return new RomanConverter(romanConvertorMap);
	}

}
