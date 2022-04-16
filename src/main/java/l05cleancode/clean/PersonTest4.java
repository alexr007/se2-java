package l05cleancode.clean;

import l05cleancode.annotations.Good;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Arrays;
import java.util.List;

@Good
@Getter
@Setter
@AllArgsConstructor
class Person4 {
  private String name;
  private int age;
  private List<String> knowledge;
}

interface IsAdult4 {
  boolean check(int age);
}

@AllArgsConstructor
class GlobalIsAdult implements IsAdult4 {
  private String country;

  private final IsAdult isAdultEurope = age -> age >= 18;
  private final IsAdult isAdultUSA = age -> age >= 21;
  private final IsAdult isAdultAfrica = age -> age >= 15;

  @Override
  public boolean check(int age) {
    switch (country) {
      case "Europe": return isAdultEurope.check(age);
      case "US"    : return isAdultUSA.check(age);
      case "Africa": return isAdultAfrica.check(age);
      default: return false;
    }
  }
}

public class PersonTest4 {
  public static void main(String[] args) {
    Person3 jim = new Person3("Jim", 15, Arrays.asList());

    GlobalIsAdult isAdult = new GlobalIsAdult("US");

    isAdult.check(jim.getAge());
  }
}

