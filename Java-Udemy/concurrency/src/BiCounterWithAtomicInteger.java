import java.util.concurrent.atomic.AtomicInteger;

public class BiCounterWithAtomicInteger {

  private AtomicInteger i = new AtomicInteger();
  private AtomicInteger j = new AtomicInteger();
  public void incrementI() {
    i.incrementAndGet();
  }

  public void incrementJ() {
    j.incrementAndGet();
  }

  public void printStatus() {
    System.out.println("i: " + i.get() + ", j: " + j.get());
  }
}
