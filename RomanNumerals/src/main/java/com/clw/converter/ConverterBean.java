package com.clw.converter;


public class ConverterBean {

    private final String fromValue;
    private final String toValue;

    ConverterBean(String fromValue, String toValue) {
        this.fromValue = fromValue;
        this.toValue = toValue;
    }

    String getFromValue() {
        return fromValue;
    }

    String getToValue() {
        return toValue;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ConverterBean)) return false;

        ConverterBean that = (ConverterBean) o;

        if (!fromValue.equals(that.fromValue)) return false;
        if (!toValue.equals(that.toValue)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = fromValue.hashCode();
        result = 31 * result + toValue.hashCode();
        return result;
    }
}
