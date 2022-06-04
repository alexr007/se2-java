package l17generics;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Supplier;

public class App1 {

  static class Person implements Comparable<Person> {
    String name;
    Integer age;

    @Override
    public int compareTo(Person that) {
      return this.age - that.age;
    }
  }

  int add10(int x) {
    return x + 10;
  }

  /**
   * ArrayList<E>
   * ArrayList<E> + Integer => ArrayList<Integer>
   * ArrayList<E> + String =>  ArrayList<String>
   *
   */
  public static void main_1_4(String[] args) {

    // Java 1.0 - 1.4
    ArrayList al0 = new ArrayList();
    al0.add(33);
    al0.add("Jim");
    al0.add(new Person());
    al0.get(0); // Int
    al0.get(1); // String
    al0.get(2); // Person
    for (Object x : al0) {

    }
  }

  public static void main(String[] args) {

    ArrayList<Integer> al1 = new ArrayList<>();
    ArrayList<String> al2 = new ArrayList<>();
    ArrayList<Person> al3 = new ArrayList<>();

    al2.add("Hello");
    al2.get(10);
    al2.remove(10);

    // compare(int, int)
    // compare(str, str)
    // compare(person, person) ???
    Collections.sort(al1);
    Collections.sort(al2);
    Collections.sort(al3);
//    Collections.sort(al3, new Comparator<Person>() {
//      @Override
//      public int compare(Person o1, Person o2) {
//        return o1.age - o2.age;
//      }
//    });


  }

  <T extends Comparable<T>> void sort1(List<T> list) {}
  <T> void sort2(List<T> list) {}

}
