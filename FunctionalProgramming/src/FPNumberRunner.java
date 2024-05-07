import java.util.List;
import java.util.stream.IntStream;

public class FPNumberRunner {

    public static void main(String[] args) {
        List<Integer> numbers = List.of(4, 6, 8, 13, 3, 15);

        IntStream.range(1,10).map(e -> e * e).forEach(e -> System.out.println(e));
        System.out.println("=========");
        List.of("Apple", "Ant", "Bat").stream().map(e -> e.toLowerCase()).forEach(e -> System.out.println(e));
        System.out.println("=========");
        List.of("Apple", "Ant", "Bat").stream().map(e -> e.length()).forEach(e -> System.out.println(e));
        System.out.println("=========");
    }

}
