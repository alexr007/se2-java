package testing.c2_code_vs_tests.index;

import testing.annotations.Good;

@Good
/**
 * this code is always compiling
 */
public class TestIdeas {

  public static void main(String[] args) {
    String r = "Hello World".substring(3, 5);
    System.out.println(r);
  }

  public static void main2(String[] args) {
    String r = "Hello  World".replace("\s"," ");
    System.out.println(r);
  }

}
