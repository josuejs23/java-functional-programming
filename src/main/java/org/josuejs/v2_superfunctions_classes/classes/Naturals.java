package org.josuejs.v2_superfunctions_classes.classes;

import org.josuejs.v2_superfunctions_classes.interfaces.Provider;

import java.util.Random;

public class Naturals implements Provider {
    private static int next = 0;
    @Override
    public Integer get() {
        return next++;
    }
}
