public class Counter {

  private int i;
  synchronized public void increment() {
    i++;
  }

  public void printStatus() {
    System.out.println(i);
  }
}
