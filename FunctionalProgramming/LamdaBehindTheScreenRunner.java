package FunctionalProgramming;
import java.util.List;
import java.util.function.Predicate;

class EvenNumberPredicate implements Predicate<Integer> {

    @Override
    public boolean test(Integer number) {
        return number % 2 == 0;
    }
}

public class LamdaBehindTheScreenRunner {

    public static void main(String[] args) {
        List.of(23, 43, 24, 45, 36, 48).stream()
                .filter(el -> el % 2 == 0)
                .forEach(el -> System.out.println(el));

        System.out.println("---- compare ----");

        List.of(23, 43, 24, 45, 36, 48).stream()
                .filter(new EvenNumberPredicate())
                .forEach(el -> System.out.println(el));
    }
}
