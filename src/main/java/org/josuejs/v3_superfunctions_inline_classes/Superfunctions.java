package org.josuejs.v3_superfunctions_inline_classes;

import org.josuejs.v3_superfunctions_inline_classes.interfaces.*;

import java.util.ArrayList;
import java.util.List;

public class Superfunctions {
    public static List<Integer> filter(List<Integer> values, Predicate predicate){
        List<Integer> result = new ArrayList<>();
        for(Integer value : values){
            if(predicate.test(value)){
                result.add(value);
            }
        }
        return  result;
    }

    public static List<Integer> provide(int size, Provider provider){
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < size ; i++) {
            result.add(provider.get());
        }
        return result;
    }

    public static List<Integer> transform(List<Integer> nums, Function function){
        List<Integer> results = new ArrayList<>();
        for(Integer num : nums){
            results.add(function.apply(num));
        }
        return results;
    }

    public static List<Integer> act(List<Integer> values, Consumer consumer){
        for(Integer value : values){
            consumer.accept(value);
        }
        return values;
    }

    public static void consume(List<Integer> values, Consumer consumer){
        for(Integer value : values){
            consumer.accept(value);
        }
    }

    public static Integer reduce(List<Integer> values, Integer indentity, BinaryFunction binaryFunction){
        Integer total = indentity;
        for(Integer value : values){
            total = binaryFunction.apply(total, value);
        }
        return total;
    }
}
