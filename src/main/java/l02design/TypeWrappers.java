package l02design;

import lombok.Data;

@Data
class UserId {
  String id;
}

@Data
class UserEmail {
  String email;
}

interface UserDelete {
  void deleteById(UserId id);
  void deleteByEmail(UserEmail email);
}

public class TypeWrappers {
}
