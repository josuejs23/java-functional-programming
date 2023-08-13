package org.josuejs.v5_stream;
import org.josuejs.v5_stream.interfaces.*;

import java.util.List;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        new Main();
    }

    public Main(){

        Integer total1 = Stream
                .provide(10, new Provider<Integer>(){
                    Random random = new Random();
                    @Override
                    public Integer get() {
                        return random.nextInt(100);
                    }
                })
                .filter(new Predicate<>() {
                    @Override
                    public boolean test(Integer value) {
                        return value % 2 == 0;
                    }
                })
                .transform( new UnaryOperator<>(){
                    @Override
                    public Integer apply(Integer value) {
                        return value * value;
                    }
                })
                .act(new Consumer<>() {
                    @Override
                    public void accept(Integer value) {
                        System.out.println(value);
                    }
                })
                .reduce( 0, new BinaryOperator<>() {
                    @Override
                    public Integer apply(Integer value1, Integer value2) {
                        return value1 + value2;
                    }
                });

        System.out.println("total1 = " + total1);
    }

}