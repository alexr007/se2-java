package l05cleancode.clean;

import l05cleancode.annotations.Good;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.*;

@Good
@Getter
@Setter
@AllArgsConstructor
class Person5 {
  private String name;
  private int age;
  private List<String> knowledge;
}

interface IsAdult5 {
  boolean check(Person5 p);
}

@AllArgsConstructor
class GlobalIsAdult5 {
  private String country;

  private final Map<String, IsAdult5> implementations =
      new HashMap<String, IsAdult5>(){{
        put("Europe", p -> p.getAge() >= 18);
        put("US", p -> p.getAge() >= 21);
        put("Africa", p -> p.getAge() >= 15);
      }};

  public Optional<Boolean> check(Person5 p) {
    if (!implementations.containsKey(country)) return Optional.empty();
    IsAdult5 isAdult = implementations.get(country);
    return Optional.of(isAdult.check(p));
  }
}

public class PersonTest5 {
  public static void main(String[] args) {
    Person5 jim = new Person5("Jim", 15, Arrays.asList());

    GlobalIsAdult5 isAdult = new GlobalIsAdult5("US");
    Optional<Boolean> checked = isAdult.check(jim);
  }
}

