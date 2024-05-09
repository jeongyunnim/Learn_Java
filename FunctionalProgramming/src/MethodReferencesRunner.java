package FunctionalProgramming.src;

import java.util.List;

public class MethodReferencesRunner {

    public static boolean isEven(Integer n) {
        return n % 2 == 0;
    }

    public static void main(String[] args) {
        List.of("Ant", "Bat", "Cat", "Dog", "Elephant").stream()
                .map(s -> s.length())
                .forEach(s -> System.out.println(s));

        List.of("Ant", "Bat", "Cat", "Dog", "Elephant").stream()
                .map(s -> s.length())
                .forEach(System.out::println);

        Integer max = List.of(23, 45, 67, 34).stream()
                .filter(MethodReferencesRunner::isEven)
                .max(Integer::compare)
                .orElse(0);
        System.out.println(max);
    }
}
