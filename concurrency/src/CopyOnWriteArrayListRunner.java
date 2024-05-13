import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class CopyOnWriteArrayListRunner {
  static public void main(String[] args) {
    List<String> list = new CopyOnWriteArrayList<>();

    // 3개의 스레드의 add
    list.add("Ant");
    list.add("Bat");
    list.add("Cat");

    // 10000개의 스레드의 get
    for (String element: list) {
      System.out.println(element);
    }

  }
}
