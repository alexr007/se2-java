package testing.c3_assertions;

import org.junit.jupiter.api.Test;
import testing.annotations.Best;

import static org.junit.jupiter.api.Assertions.assertEquals;

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
 * - we automated it
 * - we DON'T need to watch on the console
 *
 */
public class StringManipulationIdeasAsTest {

  @Test
  public void stringSubString() {
    String actual = "Hello World".substring(3, 5);
    String expected = "lo";
    assertEquals(expected, actual);
  }

  @Test
  public void removingExtraSpaces() {
    String actual = "Hello  World".replace("\s"," ");
    String expected = "Hello World";
    assertEquals(expected, actual);
  }

}
