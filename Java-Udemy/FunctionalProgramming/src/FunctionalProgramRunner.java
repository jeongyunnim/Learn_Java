package FunctionalProgramming.src;

import java.util.List;

public class FunctionalProgramRunner {
    static public void main(String[] args) {
        List<String> list = List.of("Apple", "Banana", "Cat", "Dog");
        printWithFP(list);
    }

    private static void printWithFP(List<String> list) {
        list.stream().forEach(
                element -> System.out.println(element)
        );
    }
}
