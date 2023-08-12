package org.josuejs.v2_superfunctions_classes.classes;

import org.josuejs.v2_superfunctions_classes.interfaces.BinaryFunction;

public class Substraction implements BinaryFunction {
    @Override
    public Integer apply(Integer value1, Integer value2) {
        return value1 - value2;
    }
}
