package l02design;

import lombok.Value;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Value
class Person {
  int id;
  String name;

  // function how to map Person -> Int
  static int idMapper(Person p) {
    return p.id;
  }

  // function how to map Person -> String
  static String nameMapper(Person p) {
    return p.name;
  }

}

public class SortApp {

  public static void main(String[] args) {
    // our data
    List<Person> persons = new ArrayList<>(List.of(
        new Person(10, "Alex"),
        new Person(7, "Sergio"),
        new Person(4, "Zane")
    ));
    // it doesn't work without Comparable<Person>, or without passing custom comparator
//    Collections.sort(persons);
    Comparator<Person> byId = Comparator.comparing(Person::getId);
    Comparator<Person> byName = Comparator.comparing(Person::getName);

    // sort by id
    persons.sort(byId);
    System.out.println(persons);

    // sort by name
    persons.sort(byName);
    System.out.println(persons);

  }

}
