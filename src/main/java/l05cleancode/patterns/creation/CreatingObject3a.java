package l05cleancode.patterns.creation;

import lombok.AllArgsConstructor;

public class CreatingObject3a {

  @AllArgsConstructor
  static class Person {
    String name;
    String typ;
  }

  public static void main(String[] args) {
    Person student = new Person("Jim", "student");
    Person teacher = new Person("Ben", "teacher");
  }

}
