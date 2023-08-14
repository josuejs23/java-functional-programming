package org.josuejs.v9_advanced_method_references;

public class Despcription {

    private final Integer value;
    public Despcription(Integer value) {
        this.value = value;
    }

    public Integer getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "Value{" + value + '}';
    }
}
