package testing.c3_assertions;

import org.junit.jupiter.api.Test;
import testing.annotations.Ugly;
import testing.lombok.Person;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class DataManipulationServiceTest {

  DataManipulationService dataService = new DataManipulationService();
  PersonService personService = new PersonService();

  @Ugly
  @Test
  public void testFilteringNaive() {
    List<Integer> source = List.of(-10, 5, -3, -11, 33);
    List<Integer> negativeActual = dataService.filterNegative(source);
    List<Integer> negativeExpected = List.of(-10, -3, -11);
    assertEquals(negativeActual, negativeExpected);
  }

  @Test
  public void testFilteringBetter() {
    List<Integer> source = new ArrayList<>(List.of(-10, 5, -3, -11, 33));
    List<Integer> negativeActual = dataService.filterNegative(source);
    // for collection(iterables) only
    assertThat(negativeActual)
        .allMatch(x -> x < 0)
        .hasSizeLessThanOrEqualTo(source.size());
  }

  @Test
  public void testFilteringGeneralized() {
    List<Integer> source = List.of(-10, 5, -3, -11, 33);
    List<Integer> negativeActual = dataService.filterNegative(source);

    // this predicate can be moved to the library
    Predicate<List<? extends Integer>> lessThan0 = new Predicate<>() {
      @Override
      public boolean test(List<? extends Integer> ints) {
        return ints.stream().allMatch(x -> x < 0);
      }
    };

    // more general approach - can be used for any type
    assertThat(negativeActual)
        .matches(lessThan0);
  }

  /**
   * the general idea is ONE assertion per test ? - NO
   * the general idea is ONE ENTITY per test ? - I DON'T KNOW - I need to dive into the code
   */
  @Test
  public void testPerson1() {
    Person newPerson = personService.createNew();

    assertTrue(newPerson.getAge() > 18);
    assertTrue(newPerson.getSkills().contains("Java"));
  }

  /**
   * the general idea is ONE assertion per test ? - YES
   * the general idea is ONE ENTITY per test ? - YES
   */
  @Test
  public void testPerson2() {
    Person newPerson = personService.createNew();

    assertThat(newPerson)
        .matches(p -> p.getAge() > 18)
        .matches(p -> p.getSkills().contains("Java"));
  }
}
