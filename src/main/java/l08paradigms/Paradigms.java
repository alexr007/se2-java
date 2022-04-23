package l08paradigms;

public class Paradigms {

  public void doSomething() {

    // open console
    // read the number
    // read the file
    // do the logic
    // write some result to file
    // write some result to console
    // end

  }

  public void example1() {

    int[] data = {1,2,3};
    int i = 0;

    while (i < data.length) {
      System.out.println(data[i]);
      i++;
    }

    data = new int[]{1,2,3,4};
    while (i < data.length) {
      System.out.println(data[i]);
      i++;
    }

    System.out.println(i);

  }

  public void example2() {

    int[] data = {1,2,3};
    for (int i = 0; i< data.length; i++) {
      System.out.println(data[i]);
    }

    data = new int[]{1,2,3,4};
    for (int i = 0; i< data.length; i++) {
      System.out.println(data[i]);
    }

//    System.out.println(i);

  }

  public int min(int[] xs) {
    // real min calculation
    int result = -13; // I don't care for this impl
    System.out.println("min:" + result);
    return result;
  }

  public void example3() {
    // ...
    // ...
    int x = min(new int[]{3, 5});
    // ...
    // ...
  }

}
