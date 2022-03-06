package nonblocking;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class MyServiceBetter {

  // HashMap implementation Only
  private final Map<String, Integer> counter = new ConcurrentHashMap<>();

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
