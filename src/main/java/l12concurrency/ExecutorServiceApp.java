package l12concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorServiceApp {

  static class Box {
    int i = 0;
  }

  public static void main(String[] args) {
    Box box = new Box();

    Runnable r1 = () -> {
      for (int i = 1; i <= 100_000; i++) box.i++;
    };

    Runnable r2 = () -> {
      for (int i=1; i <= 100_000; i++) box.i--;
    };

    // engine to manage
    ExecutorService es = Executors.newFixedThreadPool(10);

    es.submit(r1);
    es.submit(r2);

    // engine needs to be stopped
    es.shutdown();

  }

}
