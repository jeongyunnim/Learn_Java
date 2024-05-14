import java.util.Arrays;

enum Season {
  WINTER(4), SPRING(1), SUMMER(2), FALL(3);

  private int value;

  private Season(int value) {
    this.value = value;
  }

  public int getValue() {
    return value;
  }
}
public class EnumRunner {
  public static void main(String[] args) {
    Season season = Season.SPRING;
    System.out.println(season);

    Season season1 = Season.valueOf("SPRING");
    System.out.println(season1.ordinal());

    System.out.println(Arrays.toString(Season.values()));
  }
}
