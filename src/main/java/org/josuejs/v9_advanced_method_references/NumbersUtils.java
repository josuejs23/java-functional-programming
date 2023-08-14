package org.josuejs.v9_advanced_method_references;

public class NumbersUtils {

    private NumbersUtils() {
    }

    public static boolean isPrime(int value){
        for (int i = 2; i < value ; i++) {
            if(value % i == 0) return false;
        }
        return true;
    }

    public static Integer squared(Integer value){
        return value * value;
    }
}
