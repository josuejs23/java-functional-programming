package org.josuejs.v2_superfunctions_classes.classes;

import org.josuejs.v2_superfunctions_classes.interfaces.Consumer;

public class Printer implements Consumer {

    @Override
    public void accept(Integer value) {
        System.out.println("value = " + value);
    }
}
