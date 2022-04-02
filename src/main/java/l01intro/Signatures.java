package l01intro;

import java.util.List;

import static common.Utils.NI;

public class Signatures {

  // wrong signature
  // List<Integer> => Integer

  // right signatures
  // List<Integer> => Integer | Exception
  // List<Integer> => Integer | null
  // List<Integer> => Integer | ...
  int min(List<Integer> xs) {
    throw NI;
  }

  void a() {
    int i = Integer.parseInt("123");
    try {
      int j = Integer.parseInt("123qx"); // exception
    } catch (NumberFormatException x) {
      // what to write here ???
    }

  }

  // f: String => Int
  int stringLength(String s) {
    return s.length();
  }

  // List<Integer> => Int
  int sum(List<Integer> xs) {
    return xs.stream().reduce(0, (a, b) -> a + b);
  }

  // function signature
  //     div: (double, double) => double
  //     div: (double, double) => double | Exception
  //
  double div (double a, double b) {
    return a / b;
  }


}
