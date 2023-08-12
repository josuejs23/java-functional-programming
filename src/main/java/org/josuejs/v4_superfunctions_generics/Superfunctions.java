package org.josuejs.v4_superfunctions_generics;

import org.josuejs.v4_superfunctions_generics.interfaces.*;

import java.util.ArrayList;
import java.util.List;

public class Superfunctions {
    public static <T> List<T> filter(List<T> values, Predicate<T> predicate){
        List<T> result = new ArrayList<>();
        for(T value : values){
            if(predicate.test(value)){
                result.add(value);
            }
        }
        return  result;
    }

    public static <T> List<T> provide(int size, Provider<T> provider){
        List<T> result = new ArrayList<>();
        for (int i = 0; i < size ; i++) {
            result.add((T) provider.get());
        }
        return result;
    }

    public static <T,R> List<R> transform(List<T> nums, Function<T, R> function){
        List<R> results = new ArrayList<>();
        for(T num : nums){
            results.add(function.apply(num));
        }
        return results;
    }

    public static <T> List<T> act(List<T> values, Consumer<T> consumer){
        for(T value : values){
            consumer.accept(value);
        }
        return values;
    }

    public static <T> void consume(List<T> values, Consumer<T> consumer){
        for(T value : values){
            consumer.accept(value);
        }
    }

    public static <T> T reduce(List<T> values, T indentity, BinaryOperator<T> binaryOperator){
        T total = indentity;
        for(T value : values){
            total = binaryOperator.apply( total, value);
        }
        return total;
    }
}
