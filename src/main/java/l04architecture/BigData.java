package l04architecture;

import java.util.stream.Stream;

public class BigData {

  public static void main(String[] args) {
    String result = Stream
        .generate(() -> (long) (Math.random() * Long.MAX_VALUE))
        .limit(1000)
        .map(Object::toString)
        .reduce("", (a, x) -> x.length() > a.length() ? x : a);
    System.out.println(result);

  }

}
