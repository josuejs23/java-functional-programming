package org.josuejs.v2_superfunctions_classes.classes;

import org.josuejs.v2_superfunctions_classes.interfaces.Predicate;

public class JustOdds implements Predicate {
    @Override
    public boolean test(Integer value) {
        return value % 2 != 0;
    }
}
