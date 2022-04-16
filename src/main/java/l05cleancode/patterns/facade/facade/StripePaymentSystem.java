package l05cleancode.patterns.facade.facade;

import l05cleancode.patterns.facade.domain.User;
import l05cleancode.patterns.facade.given.StripeTransaction;

public class StripePaymentSystem implements PaymentSystem {

  private final StripeTransaction tripeLegacy;

  public StripePaymentSystem(StripeTransaction tripeLegacy) {
    this.tripeLegacy = tripeLegacy;
  }

  @Override
  public void transfer(User from, User to, Integer amt) {
    tripeLegacy.make(from.getId(), to.getId(), amt);
  }
}
