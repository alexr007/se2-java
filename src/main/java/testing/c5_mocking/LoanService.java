package testing.c5_mocking;

import testing.lombok.Person;

interface LoanService {

  boolean isEligibleToLoan(Person p);
  Person getById(int id);

}
