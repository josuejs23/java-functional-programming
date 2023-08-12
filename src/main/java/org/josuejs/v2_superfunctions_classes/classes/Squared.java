package org.josuejs.v2_superfunctions_classes.classes;

import org.josuejs.v2_superfunctions_classes.interfaces.Function;

public class Squared implements Function {
    @Override
    public Integer apply(Integer value) {
        return value * value;
    }
}
