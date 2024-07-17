import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BiCounterWithLock {

  private int i;
  private int j;
  private Lock lockForI = new ReentrantLock();
  private Lock lockForJ = new ReentrantLock();
  public void incrementI() {
    lockForI.lock();
    i++;
    lockForI.unlock();
  }

  public void incrementJ() {
    lockForJ.lock();
    j++;
    lockForJ.unlock();
  }

  public void printStatus() {
    System.out.println("i: " + i + ", j: " + j);
  }
}
