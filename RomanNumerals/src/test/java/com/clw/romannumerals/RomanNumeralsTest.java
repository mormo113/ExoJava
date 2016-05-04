package com.clw.romannumerals;

import static org.junit.Assert.assertEquals;

import java.util.HashMap;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

public class RomanNumeralsTest {
	
	private RomanNumerals romanNumerals;

    @Before
    public void setUp() {
    	romanNumerals = new RomanNumerals();;
    }

    @Test
    public void shouldTranslateDirectTranslations() {
        Map<Integer, String> arabicNumbers = getDirectRomanConvertorMap();
        for (Integer arabicNumber : arabicNumbers.keySet()) {
            String romanTranslation = romanNumerals.fromArabicToRoman(arabicNumber);
            String expectedTranslation = arabicNumbers.get(arabicNumber);

            assertEquals(expectedTranslation, romanTranslation);
        }
    }

    @Test
    public void shouldTranslateNotDirectTranslation() {
        Map<Integer, String> arabicNumbers = getNotDirectRomanConvertorMap();
        for (Integer arabicNumber : arabicNumbers.keySet()) {
            String romanTranslation = romanNumerals.fromArabicToRoman(arabicNumber);
            String expectedTranslation = arabicNumbers.get(arabicNumber);

            assertEquals(expectedTranslation, romanTranslation);
        }
    }

    
    private Map<Integer, String> getDirectRomanConvertorMap() {
        Map<Integer, String> romanConvertorMap = new HashMap<Integer, String>();
        romanConvertorMap.put(1, "I");
        romanConvertorMap.put(5, "V");
        romanConvertorMap.put(10, "X");
        romanConvertorMap.put(50, "L");
        romanConvertorMap.put(100, "C");
        romanConvertorMap.put(500, "D");
        romanConvertorMap.put(1000, "M");
        return romanConvertorMap;
    }
    
    private Map<Integer, String> getNotDirectRomanConvertorMap() {
        Map<Integer, String> directTranslations = new HashMap<Integer, String>();
        directTranslations.put(3000, "MMM");
        directTranslations.put(2008, "MMVIII");
        directTranslations.put(78, "LXXVIII");
        directTranslations.put(11, "XI");
        directTranslations.put(20, "XX");
        directTranslations.put(99, "XCIX");
        directTranslations.put(1990, "MCMXC");
        return directTranslations;
    }

}
