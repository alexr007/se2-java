package testing.c7_dont_extract;

import org.junit.jupiter.api.Test;
import testing.annotations.Best;
import testing.annotations.Good;
import testing.annotations.Ugly;
import testing.lombok.Person;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ServiceTest {

  private final Service service = new Service();

  @Ugly
  @Test
  public void testPersonWrong() {
    Optional<Person> maybePerson = service.nextOpt();
    Person person = maybePerson.get();

    assertThat(person)
        .matches(p -> p.getName().contains("MOCK"));
  }

  /**
   * F[A]
   *
   * - G[F[A]]
   * - F[G[A]]
   */
  @Test
  public void testPersonRight1() {
    Optional<Person> maybePerson = service.nextOpt();
    // premature BOX opening
    Boolean result = maybePerson.map(p -> p.getName().contains("MOCK")).orElse(true);
    assertTrue(result);
  }

  @Good
  @Test
  public void testPersonRight2() {
    Optional<Person> maybePerson = service.nextOpt();

    maybePerson.ifPresent(p ->
        assertThat(p)
            .matches(p0 -> p0.getName().contains("MOCK"))
        );
  }

  @Best
  @Test
  public void testPersonRight3() {
    Optional<Person> maybePerson = service.nextOpt();

    assertThat(maybePerson)
        .matches(
            op -> op.map(p -> p.getName().contains("MOCK"))
                //                       ................. boolean
                .orElse(true) // if empty - test case should pass successfully
        );
  }


}
