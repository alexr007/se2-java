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
class Person3 {
  private String name;
  private int age;
  private List<String> knowledge;
}

interface IsAdult {
  boolean check(int age);
}

public class PersonTest3 {
  public static void main(String[] args) {
    Person3 jim = new Person3("Jim", 15, Arrays.asList());

    IsAdult isAdultEurope = age -> age >= 18;
    IsAdult isAdultUSA = age -> age >= 21;
    IsAdult isAdultAfrica = age -> age >= 15;

    boolean isAdultEU = isAdultEurope.check(jim.getAge());
    boolean isAdultUS = isAdultUSA.check(jim.getAge());
    boolean isAdultAF = isAdultAfrica.check(jim.getAge());
  }
}

