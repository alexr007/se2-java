package testing.c3_assertions;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculatorServiceTest {

  CalculatorService service = new CalculatorService();

  @Test
  public void testAdd() {
    Integer actual = service.add(1, 3);
    Integer expected = 4;
    assertEquals(expected, actual);
  }

  @Test
  public void testAbsPositive() {
    int a = 5;
    int actual = service.abs(a);
    int expected = 5;
    assertEquals(expected, actual);
  }

  @Test
  public void testAbsNegative() {
    int a = -5;
    int actual = service.abs(a);
    int expected = 5;
    assertEquals(expected, actual);
  }

  @Test
  public void testAbsZero() {
    int a = 0;
    int actual = service.abs(a);
    int expected = 0;
    assertEquals(expected, actual);
  }

  /**
   * haskell: int
   *          Int
   *
   * Integer.MIN_VALUE -2147483648
   * Integer.MAX_VALUE  2147483647
   * abs(MIN_VALUE)    -2147483648
   */
  @Test
  public void testAbsWeird() {
    int actual = service.abs(Integer.MIN_VALUE);
    int expected = Integer.MAX_VALUE;
    assertEquals(expected, actual);
  }

}
