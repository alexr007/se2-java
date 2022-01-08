package testing.c5_mocking;

import lombok.AllArgsConstructor;
import testing.annotations.WIP;
import testing.lombok.Person;

import static testing.utils.ExUtils.NOT_IMPLEMENTED;

@WIP(estimate = "10.02.2022", author = "Alex")
@AllArgsConstructor
public class LoanServiceImpl implements LoanService {

  public boolean isEligibleToLoan(Person p) {
    return p.getAge() >= 21;
  }

  public Person getById(int id) {
    /**
     * access to the real SQL server
     */
    throw NOT_IMPLEMENTED;
  }

}
