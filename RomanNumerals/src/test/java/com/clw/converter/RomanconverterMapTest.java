package com.clw.converter;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.LinkedHashSet;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;

public class RomanconverterMapTest {
	


    private static final String FROM_VALUE = "a";
    private static final String TO_VALUE = "b";
    private static final String EMPTY_RESULT = "";

    private ConverterBeanMap table;

    private Set<ConverterBean> translationSet;

    @Before
    public void setUp() {
        initializeTranslationSet();
        initializeDirectTranslationTable();
    }

    @Test
    public void shouldFindTheTranslation() {
        ConverterBean translation = new ConverterBean(FROM_VALUE, TO_VALUE);
        translationSet.add(translation);

        assertTrue(table.existsTranslationFor(FROM_VALUE));
        assertEquals(TO_VALUE, table.getTranslationFor(FROM_VALUE));
    }

    @Test
    public void shouldNotFindTheTranslation() {
    	ConverterBean translation = new ConverterBean(FROM_VALUE, TO_VALUE);
        translationSet.add(translation);

        assertFalse(table.existsTranslationFor(TO_VALUE));
        assertEquals(EMPTY_RESULT, table.getTranslationFor(TO_VALUE));
    }

    private void initializeTranslationSet() {
        translationSet = new LinkedHashSet<ConverterBean>();
    }

    private void initializeDirectTranslationTable() {
        table = new ConverterBeanMap(translationSet);
    }


}
