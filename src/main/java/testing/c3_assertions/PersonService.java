package testing.c3_assertions;

import testing.lombok.Person;

import java.util.List;

public class PersonService {

  public Person createNew() {
    return new Person(20, "Jim", List.of());
  }

}
