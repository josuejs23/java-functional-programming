package org.josuejs.v6_lambdas.interfaces;

@FunctionalInterface
public interface BinaryFunction<T, U, R> {

    R apply(T value1, U value2);
}
