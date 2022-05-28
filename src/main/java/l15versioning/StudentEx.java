package l15versioning;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Student1 {
  String name;
  Integer age;
  List<String> skills;

  // major
  public Student1(String name, Integer age, List<String> skills) {
    this.name = name;
    this.age = age;
    this.skills = skills;
  }


}
class Student2 {
  String name;
  Integer age;
  List<String> skills;

  // minor
  public Student2(String name, Integer age, String... skills) {
    this.name = name;
    this.age = age;
    this.skills = new ArrayList<>(Arrays.asList(skills));
  }

}

public class StudentEx {

  public static void main(String[] args) {
//    new Student1("Jim", 33); // major
    new Student2("Jim", 33); // minor
    new Student2("Jim", 33, "Java");
    new Student2("Jim", 33, "Java", "Python");
  }
}
