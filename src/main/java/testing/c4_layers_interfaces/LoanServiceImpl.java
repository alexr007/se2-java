package testing.c4_layers_interfaces;

import lombok.AllArgsConstructor;
import testing.annotations.WIP;
import testing.lombok.Person;

@WIP(estimate = "10.02.2022", author = "Alex")
@AllArgsConstructor
public class LoanServiceImpl implements LoanService {

  private final PersonRepository repository;

  @Override
  public boolean isEligibleToLoan(Person p) {
    return p.getAge() >= 21;
  }

  @Override
  public Person getById(int id) {
    return repository.getById(id);
  }

}
