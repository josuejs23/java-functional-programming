package org.josuejs.v9_advanced_method_references;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        new Main();
    }

    Random random = new Random();

    public Main(){
        Integer total1 = Stream.provide(10, this::randomInt)
                .filter(NumbersUtils::isPrime)
                .sort(Integer::compare)
                .transform(NumbersUtils::squared)
                .transform(Despcription::new)
                .act(System.out::println)
                .transform(Despcription::getValue)
                .reduce( 0, Integer::sum);

        System.out.println("total1 = " + total1);
    }

    private int randomInt(){
        return this.random.nextInt(10);
    }

}