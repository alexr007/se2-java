package l05cleancode.patterns.facade.facade;

import l05cleancode.patterns.facade.domain.User;

public interface PaymentSystem {
  void transfer(User from, User to, Integer amt);
}
