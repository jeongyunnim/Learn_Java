public class ConcurrencyRunner {
  static public void main(String[] args) {
    Counter counter = new Counter();
    counter.increment();
    counter.increment();
    counter.increment();
    counter.printStatus();
  }
}
