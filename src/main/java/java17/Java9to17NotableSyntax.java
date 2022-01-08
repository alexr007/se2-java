package java17;

public class Java9to17NotableSyntax {

  /** type inferring */
  public void feature1(int x) {
    var z = x;
  }

  /** multiline sting literals*/
  public void feature2() {
    var s = """
        Hello
        World
        x ="5"
        """;
  }

  /** switch like lambda syntax */
  public void feature3(int x) {
    var s = switch (x) {
      case 1 -> "One";
      case 2 -> "Two";
      default -> "another";
    };
  }

  interface Account {}
  class PrivateAccount implements Account {
    int code;
  }
  class BusinessAccount implements Account {
    String name;
  }

  /** pattern matching with typecasting*/
  public void feature4(Object a) {
    if (a instanceof PrivateAccount pa) {
      int x = pa.code;
    } else if (a instanceof BusinessAccount ba) {
      String x = ba.name;
    }
  }

  /** records, final out of the box with all arg constructor */
  public void feature5() {
    record User(int id, String name) {}
    User u = new User(1, "Jim");
    int x = u.id;
  }

  /** sealed & non-sealed classes, extension only in the same file */
  public abstract sealed class Person permits Employee, Manager { }
  public final class Employee extends Person { }
  public non-sealed class Manager extends Person { }
//  public final class Employee1 extends Employee {}
  public final class Manager1 extends Manager {}
  public final class Manager2 extends Manager {}

  public static void main(String[] args) {

  }
}
