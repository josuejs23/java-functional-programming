package org.josuejs.v11_stream;

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
