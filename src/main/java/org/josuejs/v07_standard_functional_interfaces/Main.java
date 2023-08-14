package org.josuejs.v07_standard_functional_interfaces;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        new Main();
    }

    public Main(){
        Random random = new Random();
        Integer total1 = Stream.provide(10,()->random.nextInt(10) )
                .filter( value  -> value % 2 == 0)
                .transform( value -> value * value)
                .act((Integer value ) -> System.out.println(value))
                .reduce( 0, (value1, value2)-> value1 + value2);

        System.out.println("total1 = " + total1);
    }

}