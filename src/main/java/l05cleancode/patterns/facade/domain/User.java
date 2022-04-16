package l05cleancode.patterns.facade.domain;

import lombok.Value;

@Value
public class User {
  String name;
  Email email;
  Iban iban;
  Integer id;
}
