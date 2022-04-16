package l05cleancode.patterns.creation;

class Person {
  String name;
  String typ;

  private Person(String name, String typ) {
    this.name = name;
    this.typ = typ;
  }

  static Person student(String name) {
    return new Person(name, "student");
  }

  static Person teacher(String name) {
    return new Person(name, "teacher");
  }
}

public class CreatingObject3b {

  public static void main(String[] args) {
//    Person wrong = new Person("Jim", "friend");
    Person student = Person.student("Jim");
    Person teacher = Person.teacher("Ben");
  }

}
