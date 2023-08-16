package org.josuejs.v11_stream;

import java.util.Comparator;
import java.util.Optional;
import java.util.OptionalInt;
import java.util.Random;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        new Main();
    }

    Random random = new Random();

    public Main(){

        Integer total = random.ints(10, 1, 10)
                //.filter(NumbersUtils::isPrime)
                .boxed()
                .filter(value -> value % 2 == 0)
                .sorted(Integer::compareTo)
                .map(NumbersUtils::squared)
                .map(Despcription::new)
                .peek(System.out::println)
                .map(Despcription::getValue)
                .mapToInt(Integer::intValue)
                .sum();
//                .peek(System.out::println)
//                .max(Comparator.reverseOrder());
//                .reduce(0, (acumulator, current) -> acumulator + current);
//                .ifPresentOrElse(System.out::println,()->System.out.println("Not value"));
                //.reduce( 0, Integer::sum);
        System.out.println(total);
    }

    private java.util.stream.Stream<Integer> getRandomNumbers(Integer size){
        return random.ints(size, 0, 10).boxed();
    }

    private int randomInt(){
        return this.random.nextInt(10);
    }

}