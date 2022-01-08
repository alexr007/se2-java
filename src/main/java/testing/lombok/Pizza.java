package testing.lombok;

import lombok.Data;

import java.util.List;

/**
 * https://projectlombok.org/features/Data
 */
@Data
public class Pizza {
  Integer size;
  String name;
  List<String> extras;
}
