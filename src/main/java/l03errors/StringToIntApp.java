package l03errors;

import java.util.Optional;
import java.util.Scanner;

public class StringToIntApp {

  static Scanner scanner = new Scanner(System.in);

  /** here I don't have enough/any information to handle the error */
  static Optional<Integer> expectInt() {
    System.out.print("Enter the number");
    String line = scanner.nextLine();
    try {
      return Optional.of(Integer.parseInt(line));
    } catch (NumberFormatException x) {
      x.getMessage();
      return Optional.empty();
    }
  }

  /** here we have a knowledge, and can retry to get really int number */
  static int guaranteeInt() {
    Optional<Integer> maybeNumber = expectInt();

    while (!maybeNumber.isPresent()) {
      System.out.println("Wrong value given, repeat please");
      maybeNumber = expectInt();
    }

    return maybeNumber.get();
  }

  public static void main(String[] args) {
    int number = guaranteeInt();
    System.out.printf("You entered: %d\n", number);
  }

}
