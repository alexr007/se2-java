package nonblocking;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicIntegerArray;
import java.util.concurrent.atomic.AtomicReference;
import java.util.function.UnaryOperator;

public class MyServiceEvenBetter {

  private final AtomicReference<Map<String, Integer>> counter =
      new AtomicReference<>(new HashMap<>());

  public void inc(String key) {
//    AtomicInteger
    //AtomicReference<Integer>
    // m1 value if a value AFTER function application
    Map<String, Integer> m1 = counter.updateAndGet(m -> m);
    // m2 value if a value BEFORE function application
    Map<String, Integer> m2 = counter.getAndUpdate(m -> m);

    // there is a guarantee, `updateAndGet` will be run atomically,
    // w.o. any locking, on the CPU level
    counter.updateAndGet(map -> {
          if (map.containsKey(key)) {
            map.put(key, map.get(key) + 1);
          } else {
            map.put(key, 1);
          }
          return map;
        }

    );
  }

  public Integer get(String key) {
    // .get intended for reading only
    return counter.get()
        .getOrDefault(key, 0);
  }

}
