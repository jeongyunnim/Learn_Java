package nestedclass;

class DefaultClass {

}
public class NestedClassRunner {
  private int i;
  class InnerClass {
    public void method() {
      i = 0;
    }
  }

  static class StaticNestedClass {
    public void method() {
//      i = 0;
    }
  }
  public static void main(String[] args) {
//    InnerClass innerClass = new InnerClass();
    StaticNestedClass staticNestedClass = new StaticNestedClass();

    NestedClassRunner nestedClassRunner = new NestedClassRunner();
  }
}
