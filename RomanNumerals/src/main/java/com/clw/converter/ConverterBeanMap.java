package com.clw.converter;

import java.util.Set;

public class ConverterBeanMap {

    private Set<ConverterBean> convertorBeans;

    protected ConverterBeanMap(Set<ConverterBean> convertorBeans) {
        this.convertorBeans = convertorBeans;
    }
    
    String getTranslationFor(String number) {
        return searchTranslation(number);
    }
    
    boolean existsTranslationFor(String number) {
        return !searchTranslation(number).isEmpty();
    }
    
    Set<ConverterBean> getDirectTranslations() {
        return convertorBeans;
    }

    private String searchTranslation(String number) {
        String res = "";
        for (ConverterBean convertor : convertorBeans) {
            if (convertor.getFromValue().equals(number)) {
                res = convertor.getToValue();
                break;
            }
        }
        return res;
    }

}
