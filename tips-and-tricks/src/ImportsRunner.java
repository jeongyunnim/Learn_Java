import java.awt.image.AreaAveragingScaleFilter;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

import static java.util.Collections.sort;

public class ImportsRunner {
  public static void main(String[] args) {
    List<String> testList = List.of("CCC", "AAAA", "AA");
    ArrayList<String> testArrayList = new ArrayList<>(testList);
    sort(testArrayList);
    System.out.println(testArrayList);
  }
}
