package l05cleancode.clean;

import l05cleancode.annotations.Bad;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Arrays;
import java.util.List;

@Bad
@Getter
@Setter
@AllArgsConstructor
class Person2 {
  private String name;
  private int age;
  private List<String> knowledge;

  public boolean isAdult(int ref) {
    return age >= ref;
  }

  public boolean isEligibleToLoan() {
    return age >= 21;
  }

}

public class PersonTest2 {
  public static void main(String[] args) {
    Person2 jim = new Person2("Jim", 15, Arrays.asList());
    boolean isAdult = jim.isAdult(jim.getAge());
  }
}

