package FunctionalProgramming.src;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

class EvenNumberPredicate implements Predicate<Integer> {

    @Override
    public boolean test(Integer number) {
        return number % 2 == 0;
    }
}

class SystemOutConsumer implements Consumer<Integer> {

    @Override
    public void accept(Integer number) {
        System.out.println(number);
    }
}

class NumberSquareMapper implements Function<Integer, Integer> {
    @Override
    public Integer apply(Integer number) {
        return number * number;
    }
}

public class LamdaBehindTheScreenRunner {

    public static void main(String[] args) {
        List.of(23, 43, 24, 45, 36, 48).stream()
                .filter(el -> el % 2 == 0)
                .map(n -> n * n)
                .forEach(el -> System.out.println(el));

        System.out.println("---- compare ----");

        List.of(23, 43, 24, 45, 36, 48).stream()
                .filter(new EvenNumberPredicate())
                .map(new NumberSquareMapper())
                .forEach(new SystemOutConsumer());
    }
}
