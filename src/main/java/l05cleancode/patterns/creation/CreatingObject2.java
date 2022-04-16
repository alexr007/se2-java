package l05cleancode.patterns.creation;

import lombok.Builder;

import java.time.LocalDateTime;

public class CreatingObject2 {

  @Builder
  static class TaxiOrder {
    String from;
    String to;
    LocalDateTime when;
    Double price;
    Boolean smokingAllowed;
    Boolean petsAllowed;
  }

  public static void main(String[] args) {
    TaxiOrder order = TaxiOrder.builder()
        .from("Kyiv")
        .to("NewYork")
        .price(500d)
        .petsAllowed(false)
        .smokingAllowed(true)
        .smokingAllowed(false)
        .build();
  }

}
