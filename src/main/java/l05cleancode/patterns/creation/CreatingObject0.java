package l05cleancode.patterns.creation;

import lombok.Setter;

import java.time.LocalDateTime;

public class CreatingObject0 {

  @Setter
  static class TaxiOrder {
    String from;
    String to;
    LocalDateTime when;
    Double price;
    Boolean smokingAllowed;
    Boolean petsAllowed;
  }

  public static void main(String[] args) {
    /** imcomplete object can be created */
    TaxiOrder o = new TaxiOrder();
    o.setFrom("NewYork");
    o.setTo("Kyiv");
  }

}
