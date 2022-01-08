package testing.c4_layers_interfaces;

import testing.lombok.Person;

interface LoanService {

  boolean isEligibleToLoan(Person p);
  Person getById(int id);

}
