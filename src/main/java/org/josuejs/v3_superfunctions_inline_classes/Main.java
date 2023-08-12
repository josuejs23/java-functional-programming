package org.josuejs.v3_superfunctions_inline_classes;
import org.josuejs.v3_superfunctions_inline_classes.Superfunctions;
import org.josuejs.v3_superfunctions_inline_classes.interfaces.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        new Main();
    }

    public Main(){
        // 1. Create a list of integer
        List<Integer> numbers = Superfunctions.provide(3, new Provider(){
            Random random = new Random();
            @Override
            public Integer get() {
                return random.nextInt(100);
            }
        });
        System.out.println("numbers = " + numbers);

        // 2.a Filter the even numbers
        List<Integer> filters = Superfunctions.filter(numbers, new Predicate() {
            @Override
            public boolean test(Integer value) {
                return value % 2 == 0;
            }
        });
        System.out.println("filters = " + filters);

        // 3. Get a power of 2 of each number
        List<Integer> transformed = Superfunctions.transform(filters, new Function(){

            @Override
            public Integer apply(Integer value) {
                return value * value;
            }
        });
        System.out.println("transformed = " + transformed);

        Consumer consumer = new Consumer() {
            @Override
            public void accept(Integer value) {
                System.out.println(value);
            }
        };
        // 4a. Show each number on the screen and return the list
        List<Integer> nums = Superfunctions.act(transformed, consumer);
        System.out.println("nums = " + nums);

        // 4b. Show each number on the screen
        Superfunctions.consume(transformed, consumer);

        // 5. Get the sum of all numbers
        int total = Superfunctions.reduce(transformed, 0, new BinaryFunction() {
            @Override
            public Integer apply(Integer value1, Integer value2) {
                return value1 + value2;
            }
        });
        System.out.println("total = " + total);
    }

}