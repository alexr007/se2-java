package l12concurrency;

public class AppIntro {

  static class Box {
    int i = 0;
  }

  public static void main(String[] args) throws InterruptedException {
    Box box = new Box();

    Runnable r1 = new Runnable() {
      @Override
      public void run() {
        for (int i=1; i <= 100_000; i++) box.i++;
      }
    };

    Runnable r2 = () -> {
      for (int i=1; i <= 100_000; i++) box.i--;
    };
//    r1.run();
//    r2.run();
    Thread t1 = new Thread(r1);
    Thread t2 = new Thread(r2);

    t1.start();
    t2.start();

    Thread.sleep(1000);

    System.out.println(box.i);

  }


}
