package l05cleancode.patterns.facade;

import l05cleancode.patterns.facade.domain.User;
import l05cleancode.patterns.facade.facade.PaymentSystem;
import l05cleancode.patterns.facade.facade.PaypalPaymentSystem;
import l05cleancode.patterns.facade.facade.StripePaymentSystem;
import l05cleancode.patterns.facade.facade.WirePaymentSystem;
import l05cleancode.patterns.facade.given.PaypalPayment;
import l05cleancode.patterns.facade.given.StripeTransaction;
import l05cleancode.patterns.facade.given.WireTransfer;

public class XTransferApp {

  private PaypalPayment paypayLegacy = null; // TODO: that's not mine responsibility to get them
  private StripeTransaction stripeTransaction = null;
  private WireTransfer wireTransfer = null;

  PaymentSystem paypal = new PaypalPaymentSystem(paypayLegacy);
  PaymentSystem stripe = new StripePaymentSystem(stripeTransaction);
  PaymentSystem wire = new WirePaymentSystem(wireTransfer);

  void makePayment(User from, User to, Integer amt, PaymentSystem ps) {
    ps.transfer(from, to, amt);
  }

  public static void main(String[] args) {
    User u1 = null; // TODO: that's not mine responsibility to get them
    User u2 = null; // TODO: that's not mine responsibility to get them
    XTransferApp x = new XTransferApp();
    x.makePayment(u1, u2, 100, x.paypal);
    x.makePayment(u1, u2, 100, x.stripe);
    x.makePayment(u1, u2, 100, x.wire);
  }

}
