package testing.c4_layers_interfaces;

import org.junit.jupiter.api.Test;
import testing.annotations.Good;
import testing.annotations.Ugly;
import testing.lombok.Person;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LoanServiceImplSpec {

  private final LoanService service = new LoanServiceTest();

  @Ugly
  @Test
  public void isEligibleToLoanTest() {
    Person p1 = new Person(20, "Jim", List.of());
    assertFalse(service.isEligibleToLoan(p1));

    Person p2 = new Person(21, "Jim", List.of());
    assertTrue(service.isEligibleToLoan(p2));
  }

  @Good
  @Test
  public void isEligibleToLoanLess21() {
    Person p1 = new Person(20, "Jim", List.of());
    assertFalse(service.isEligibleToLoan(p1));
  }

  @Good
  @Test
  public void isEligibleToLoanGE21() {
    Person p2 = new Person(21, "Jim", List.of());
    assertTrue(service.isEligibleToLoan(p2));
  }

  @Good
  @Test
  public void getById() {
    Person p = service.getById(1);
    assertThat(p).matches(p0 -> p0.getAge() > 0);
  }

}
