package org.josuejs.v2_superfunctions_classes.classes;

import org.josuejs.v2_superfunctions_classes.interfaces.Provider;

import java.util.Random;

public class Randon implements Provider {
    Random random = new Random();
    @Override
    public Integer get() {
        return random.nextInt(1000);
    }
}
