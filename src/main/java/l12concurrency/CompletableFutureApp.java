package l12concurrency;

import lombok.Data;
import lombok.Value;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CountDownLatch;

public class CompletableFutureApp {

  @Value
  static class Person {
    int age;
    String name;
  }

  static void wait(int millis) {
    try {
      Thread.sleep(millis);
    } catch (InterruptedException e) {
      throw new RuntimeException("interrupted :(");
    }
  }

  // `age` is going to be taken from the one db
  static CompletableFuture<Integer> obtainAge() {
    return CompletableFuture.supplyAsync(() -> {
      // to emulate long process
      wait(200);
      System.out.println("age is resolved");
      return 33;
    });
  }

  // `name` is going to be taken from the another service
  static CompletableFuture<String> obtainName() {
    return CompletableFuture.supplyAsync(() -> {
      // to emulate long process
      wait(400);
      System.out.println("name is resolved");
      return "Jim";
    });
  }

  public static void main(String[] args) throws InterruptedException {
    CountDownLatch latch = new CountDownLatch(1);

    CompletableFuture<Integer> ageF = obtainAge();
    CompletableFuture<String> nameF = obtainName();
    CompletableFuture<Person> personF =
        ageF.thenCombineAsync(
            nameF,
            (age, name) -> new Person(age, name)
        );
    CompletableFuture<Void> voidF = personF.thenAcceptAsync(p -> {
      System.out.println(p);
      latch.countDown();
    });

    latch.await();
    // wait(500); // bad approach
  }

}
