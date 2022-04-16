package l05cleancode.patterns.facade.given;

public interface StripeTransaction {
  void make(Integer from, Integer to, int amount);
}
