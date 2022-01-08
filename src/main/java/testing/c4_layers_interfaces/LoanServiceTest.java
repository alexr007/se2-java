package testing.c4_layers_interfaces;

import testing.lombok.Person;

import java.util.List;

import static testing.utils.ExUtils.NOT_IMPLEMENTED;

public class LoanServiceTest implements LoanService {

  @Override
  public boolean isEligibleToLoan(Person p) {
    return p.getAge() >= 21;
  }

  @Override
  public Person getById(int id) {
    if (id == 1) return new Person(1, "MOCKED: Jim", List.of());

    throw NOT_IMPLEMENTED;
  }

}
