package dev.study.자바;

public class Variable {
    public static void main(String[] args) {
        final String name = "Java";
        int age = 20;

        System.out.println("Name : " + name + ", Age " + age);
        age = 26;
        // final이라서 불변 변수임
        //name = "kotlin";
    }
}
