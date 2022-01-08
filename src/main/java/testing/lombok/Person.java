package testing.lombok;

import lombok.Value;

import java.util.List;

/**
 * https://projectlombok.org/features/Data
 */
@Value
public class Person {
  Integer age;
  String name;
  List<String> skills;
}
