package nonblocking;

import java.util.HashMap;
import java.util.Map;

public class MyServiceUnsafe {

  private final Map<String, Integer> counter = new HashMap<>();

  public void inc(String key) {
    if (counter.containsKey(key)) {
      counter.put(key, counter.get(key) + 1);
    } else {
      counter.put(key, 1);
    }
  }

  public Integer get(String key) {
    return counter.getOrDefault(key, 0);
  }

}
