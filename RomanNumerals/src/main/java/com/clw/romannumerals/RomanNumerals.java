package com.clw.romannumerals;

import com.clw.converter.Converter;
import com.clw.converter.ConverterFactory;


public class RomanNumerals {

    private Converter romanConvertor;

    public RomanNumerals() {
        this.romanConvertor = ConverterFactory.getRomanConvertor();
    }

    /**
     * Convert a number from to the roman format.
     *
     * @param number to translate
     * @return roman format.
     */
    public String fromArabicToRoman(Integer number) {
        return romanConvertor.convert(number + "");
    }
}
