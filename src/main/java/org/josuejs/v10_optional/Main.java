package org.josuejs.v10_optional;

import java.util.Comparator;
import java.util.Optional;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        new Main();
    }

    Random random = new Random();

    public Main(){
         Stream.provide(10, this::randomInt)
                //.filter(NumbersUtils::isPrime)
                .filter(value -> value >= 10)
                .sort(Integer::compare)
                .transform(NumbersUtils::squared)
                .transform(Despcription::new)
                .act(System.out::println)
                .transform(Despcription::getValue)
                .max(Comparator.reverseOrder())
                .ifPresentOrElse(System.out::println,()->System.out.println("Not value"));
                //.reduce( 0, Integer::sum);
    }

    private int randomInt(){
        return this.random.nextInt(10);
    }

}