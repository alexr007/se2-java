package l05cleancode.patterns.facade.given;

import l05cleancode.patterns.facade.domain.Iban;

public interface WireTransfer {
  void transfer(Iban from, Iban to, int amount);
}
