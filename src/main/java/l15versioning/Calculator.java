package l15versioning;

import java.util.List;
import java.util.Optional;

public class Calculator {

  /** version 1.0 */
  public int add(int a, int b) {
    return a + b;
  }

  /** version 1.1 */
  public int sub(int a, int b) {
    return a - b;
  }

  /** version 1.2.1 or version 2.0 */
  public double sqrt(double a) throws IllegalArgumentException {
    if (a < 0) throw new IllegalArgumentException("not allowed");
    return Math.sqrt(a);
  }

  /** version 2.1 / version 3.0 */
  /** a*x^2 + b*x + c = 0 => [] / [x], [x1, x2]*/
  /**
   * Optional<List<Double>>
   * no roots => Optional.none
   * 1 root   => Optional<List<X>>
   * 2 roots  => Optional<List<X, Y>>
   */
  public double[] squareEq(double a, double b, double c) {
    throw new IllegalArgumentException("not implemented yet");
  }


}
