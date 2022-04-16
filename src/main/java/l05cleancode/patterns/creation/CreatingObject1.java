package l05cleancode.patterns.creation;

import lombok.AllArgsConstructor;

import java.time.LocalDateTime;

public class CreatingObject1 {

  @AllArgsConstructor
  static class TaxiOrder {
    String from;
    String to;
    LocalDateTime when;
    Double price;
    Boolean smokingAllowed;
    Boolean petsAllowed;
  }

  /** we can easily mix from/to and/or smokingAllowed/petsAllowed */
  public static void main(String[] args) {
    new TaxiOrder(
        "NewYork",
        "Kyiv",
        LocalDateTime.parse("2020-10-10 13:15"),
        500d,
        false,
        true
    );
  }

}
