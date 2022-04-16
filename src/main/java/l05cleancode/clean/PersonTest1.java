package l05cleancode.clean;

import l05cleancode.annotations.Ugly;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Arrays;
import java.util.List;

@Ugly
@Getter
@Setter
@AllArgsConstructor
class Person {
  private String name;
  private int age;
  private List<String> knowledge;

  public boolean isAdult() {
    return age >= 18;
  }

  public boolean isEligibleToLoan() {
    return age >= 21;
  }

}

public class PersonTest1 {
  public static void main(String[] args) {
    Person jim = new Person("Jim", 15, Arrays.asList());
    boolean isAdult = jim.isAdult();
  }
}

