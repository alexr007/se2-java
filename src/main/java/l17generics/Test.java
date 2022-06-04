package l17generics;

import lombok.AllArgsConstructor;

@AllArgsConstructor
class BoxInt {
  Integer x;
  // original implementation
}

@AllArgsConstructor
class BoxString {
  String x;
  // COPY-PASTED implementation

  public void make() {
    x.toLowerCase();
  }
}

@AllArgsConstructor
class Box<A> {
  A x;
  // no copy-paste. your code is only in one place

  public void make() {
    // at that moment we don't know the real type of A.
    // it leads to write the code with less mistakes
  }
}


public class Test {
  public static void main(String[] args) {
    BoxInt boxInt = new BoxInt(33);
    BoxString jim = new BoxString("Jim");
    Box<Double> box = new Box<>(3.5);
    Double x = box.x;
  }

}



