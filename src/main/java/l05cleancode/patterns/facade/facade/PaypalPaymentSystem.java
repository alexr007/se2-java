package l05cleancode.patterns.facade.facade;

import l05cleancode.patterns.facade.domain.User;
import l05cleancode.patterns.facade.given.PaypalPayment;

public class PaypalPaymentSystem implements PaymentSystem {

  private final PaypalPayment paypalLegacy;

  public PaypalPaymentSystem(PaypalPayment paypalLegacy) {
    this.paypalLegacy = paypalLegacy;
  }

  @Override
  public void transfer(User from, User to, Integer amt) {
    paypalLegacy.doPay(from.getEmail(), to.getEmail(), amt);
  }
}
