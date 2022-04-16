package l05cleancode.patterns.facade.facade;

import l05cleancode.patterns.facade.domain.User;
import l05cleancode.patterns.facade.given.WireTransfer;

public class WirePaymentSystem implements PaymentSystem {

  private final WireTransfer wireTransferLegacy;

  public WirePaymentSystem(WireTransfer wireTransferLegacy) {
    this.wireTransferLegacy = wireTransferLegacy;
  }

  @Override
  public void transfer(User from, User to, Integer amt) {
    wireTransferLegacy.transfer(from.getIban(), to.getIban(), amt);
  }
}
