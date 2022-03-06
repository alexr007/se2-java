package nonblocking;

import java.util.HashMap;
import java.util.Map;

public class MyServiceLocking {

  private final Map<String, Integer> counter = new HashMap<>();

  // extremely hard primitive
  synchronized public void inc(String key) {
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
