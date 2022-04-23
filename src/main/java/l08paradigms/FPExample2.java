package l08paradigms;

import java.io.PrintStream;
import java.util.function.Supplier;

public class FPExample2 {

  /** step 0 */
  public void print0(String message) {
    System.out.println(message);
  }

  /** step 1 */
  public void print1(String message, PrintStream device) {
    device.println(message);
  }

  /** step 3 */
  public Supplier<Void> print3(String message, PrintStream device) {
    return () -> {
      device.println(message);
      return null;
    };
  }

  public static void main(String[] args) {
    FPExample2 fp = new FPExample2();
    // create
    Supplier<Void> willPrintWhenCalled = fp.print3("Hello World", System.out);
    // print
    willPrintWhenCalled.get();
  }


}
