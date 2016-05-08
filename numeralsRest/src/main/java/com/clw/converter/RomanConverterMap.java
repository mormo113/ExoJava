package com.clw.converter;

import java.util.LinkedHashSet;
import java.util.Set;



public class RomanConverterMap extends ConverterBeanMap {

	RomanConverterMap() {
        this(new LinkedHashSet<ConverterBean>());
    }

	RomanConverterMap(Set<ConverterBean> convertorBean) {
        super(convertorBean);
        initializeDirectTranslationsTrable(convertorBean);
    }

    private void initializeDirectTranslationsTrable(Set<ConverterBean> convertorBeans) {

    	convertorBeans.add(new ConverterBean("1000", "M"));
        convertorBeans.add(new ConverterBean("900", "CM"));
        convertorBeans.add(new ConverterBean("500", "D"));
        convertorBeans.add(new ConverterBean("400", "CD"));
        convertorBeans.add(new ConverterBean("100", "C"));
        convertorBeans.add(new ConverterBean("90", "XC"));
        convertorBeans.add(new ConverterBean("50", "L"));
        convertorBeans.add(new ConverterBean("40", "XL"));
        convertorBeans.add(new ConverterBean("10", "X"));
        convertorBeans.add(new ConverterBean("9", "IX"));
        convertorBeans.add(new ConverterBean("5", "V"));
        convertorBeans.add(new ConverterBean("4", "IV"));
        convertorBeans.add(new ConverterBean("1", "I"));
    }


    int getBetterTranslation(String arabicNumber) {
        int number = Integer.parseInt(arabicNumber);
        for (ConverterBean convertorBean : getDirectTranslations()) {
            if (number - Integer.parseInt(convertorBean.getFromValue()) >= 0) {
                return Integer.parseInt(convertorBean.getFromValue());
            }
        }
        return 0;
    }

}
