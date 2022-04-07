package l03errors;

import java.util.Optional;

public class OptionApp1 {

  /** it's unsafe, it can throw exception */
  // (double, double) => double
  // (double, double) => double | exception
  // (double, double) => Optional<Double>
  static int div(int a, int b) {
    return (a / b);
  }

  static int sqrt(double a) {
    return (int)Math.sqrt(a);
  }

  static Optional<Integer> safeDiv(int a, int b) {
    try {
      int r = div(a, b);
      return Optional.of(r);
    } catch (ArithmeticException x) {
      return Optional.empty();
    }
  }

  public static void main(String[] args) {
//    int r1 = div(4, 2);
//    int r2 = div(-4, 0);
    Optional<Integer> r3 = safeDiv(4, 2); // Optional[2]
    Optional<Integer> r4 = safeDiv(4, 0); // Optional.empty
    System.out.println(r3);
    System.out.println(r4);
  }


}
