package l17generics;

import java.util.function.Function;

public class ErrorHandling {

  // unsafe, can throw exception "/ by zero" (n = 0)
  public static double unsafeDivide10by(double n) {
    throw new IllegalArgumentException("boom");
//    return 10 / n;
  }

  // unsafe, can throw exception "index out of bounds" (index = 5)
  public static int unsafeGetElement(int index) {
    int[] a = {1,2,3};
    return a[index];
  }

  // functional try-catch
  public static <A, B> Function<A, B> makeSafe(Function<A, B> unsafeFn, Function<Exception, B> recover) {
    return (A a) -> {
      try {
        return unsafeFn.apply(a);
      } catch (Exception x) {
        return recover.apply(x);
      }
    };
  }

  public static double safeDiv10by(double a) {
    return makeSafe(ErrorHandling::unsafeDivide10by, x -> 999999.99).apply(a);
  }

  public static int safeGetElement(int index) {
    return makeSafe(ErrorHandling::unsafeGetElement, x -> -1).apply(index);
  }

  public static void main(String[] args) {
//    int v1 = unsafeGetElement(5);
    int v1 = safeGetElement(5);
    System.out.println(v1);
  }

  public static void main2(String[] args) {
//    double v1 = unsafeDivide10by(0);
    double v2 = safeDiv10by(0.0);
    System.out.println(v2);
  }



  public static void main1(String[] args) {
    try {
      // ...
    } catch (Exception x) {
      // ...
    }
  }



}
