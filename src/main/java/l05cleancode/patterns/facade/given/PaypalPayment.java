package l05cleancode.patterns.facade.given;

import l05cleancode.patterns.facade.domain.Email;

public interface PaypalPayment {
  void doPay(Email from, Email to, int amount);
}
