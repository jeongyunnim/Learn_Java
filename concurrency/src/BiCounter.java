public class BiCounter {

  private int i;
  private int j;
  synchronized public void incrementI() {
    i++;
  }

  synchronized public void incrementJ() {
    j++;
  }

  public void printStatus() {
    System.out.println("i: " + i + ", j: " + j);
  }
}
