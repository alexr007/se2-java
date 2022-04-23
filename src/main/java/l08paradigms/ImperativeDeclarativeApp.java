package l08paradigms;

import java.util.Optional;
import java.util.stream.Stream;

public class ImperativeDeclarativeApp {

  /** imperative */
  public int min(int[] as) {

    int min = as[0];

    for (int i = 1; i < as.length ; i++) {
      if (as[i] < min) min = as[i];
    }

    return min;
  }

  public int min2(int[] as) {

    int min = as[0];

    for (int a : as) {
      if (a < min) min = a;
    }

    return min;
  }

  public int justMin(int a, int b) {
    return a <= b ? a : b;
  }

  public int min3(Stream<Integer> as) {

    int result = as.reduce(
        0,
        (a, b) -> justMin(a, b)
    );
    return result;
  }

  public int min4(Stream<Integer> as) {

    int result = as.reduce(
        Integer.MAX_VALUE,
        (a, b) -> justMin(a, b)
    );
    return result;
  }

  public Optional<Integer> min5(Stream<Integer> as) {
    return as.reduce(Math::min);
  }

  public Optional<Integer> min6(Stream<Integer> as) {
    return as.reduce((a, b) -> Math.min(a, b));
  }

}
