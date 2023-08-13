package org.josuejs.v6_lambdas;
import org.josuejs.v6_lambdas.interfaces.*;

import java.util.List;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        new Main();
    }

    public Main(){
        Random random = new Random();
        Integer total1 = Stream.provide(10,()->random.nextInt() )
                .filter( value  -> value % 2 == 0)
                .transform( value -> value * value)
                .act((Integer value ) -> System.out.println(value))
                .reduce( 0, (value1, value2)-> value1 + value2);

        System.out.println("total1 = " + total1);
    }

}