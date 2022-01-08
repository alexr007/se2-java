package testing.c2_code_vs_tests.index;

import org.junit.jupiter.api.Test;
import testing.annotations.Best;

@Best
/**
 * actually not a test,
 * but rather ability to quickly
 * and independently run your code
 *
 * PROS:
 * - code is always compiling
 * - you can run it independently
 * - you can run it fast
 * - you can see the result
 *
 * CONS:
 * - we need to watch on the console
 * - no assertions => can't be automated
 */
public class IdeasAsTest {

  /** actually, no tests here */
  @Test
  public void test1() {
    String r = "Hello World".substring(3, 5);
    System.out.println(r);
  }

  @Test
  public void test2() {
    String r = "Hello  World".replace("\s"," ");
    System.out.println(r);
  }

}
