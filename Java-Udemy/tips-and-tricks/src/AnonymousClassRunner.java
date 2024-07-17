import java.sql.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
public class AnonymousClassRunner {
  static public void main(String[] args) {
    List<String> animals = new ArrayList<String>(List.of("Ant", "Cat", "Ball", "Elephant"));
    Collections.sort(animals, new Comparator<String>() {
      @Override
      public int compare(String o1, String o2) {
        return Integer.compare(o2.length(), o1.length());
      }
    });
    System.out.println(animals);

  }

}
