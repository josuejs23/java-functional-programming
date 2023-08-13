package org.josuejs.v6_lambdas;

import org.josuejs.v6_lambdas.interfaces.*;

import java.util.ArrayList;
import java.util.List;

public class Stream<T> {

    private final List<T> values;

    public Stream(List<T> values){
        this.values = values;
    }

    public static <T> Stream<T> provide(int size, Provider<T> provider){
        List<T> result = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            result.add(provider.get());
        }
        return new Stream<>(result);
    }
    public Stream<T> filter(Predicate<T> predicate){
        List<T> result = new ArrayList<>();
        for(T value : values){
            if(predicate.test(value)){
                result.add(value);
            }
        }
        return new Stream<>(result);
    }

    public <R> Stream<R> transform( Function<T, R> function){
        List<R> results = new ArrayList<>();
        for(T num : values){
            results.add(function.apply(num));
        }
        return new Stream<>(results);
    }

    public  Stream<T> act( Consumer<T> consumer){
        for(T value : values){
            consumer.accept(value);
        }
        return new Stream<>(values);
    }

    public void consume( Consumer<T> consumer){
        for(T value : values){
            consumer.accept(value);
        }
    }

    public  T reduce( T indentity, BinaryOperator<T> binaryOperator){
        T total = indentity;
        for(T value : values){
            total = binaryOperator.apply( total, value);
        }
        return total;
    }

    @Override
    public String toString() {
        return values.toString();
    }
}
