package dev;

import java.util.function.Function;
import java.util.logging.Filter;

public class Test {
    public static void main(String[] args) {
        Function<Double , Double> square = x -> x * x;
        System.out.println(square.apply(3.0));

    }
}
