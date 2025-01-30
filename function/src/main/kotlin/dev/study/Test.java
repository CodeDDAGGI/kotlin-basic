package dev.study;

import java.util.function.Function;

class Test {
    public static void main(String[] args) {
        Function<Double, Double> square = x -> x * x;
        System.out.println(square.apply(3.0));
    }
}