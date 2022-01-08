package testing.c3_assertions;

import java.util.List;

public class DataManipulationService {

  public List<Integer> filterNegative(List<Integer> src) {
    return src.stream().filter(x -> x < 0).toList();
  }

}
