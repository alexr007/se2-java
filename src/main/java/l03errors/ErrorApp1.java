package l03errors;

import java.util.Optional;

class User{}

interface UserRepository {

  /**
   * Int => User (it's lying)
   *
   * 1. Int => User | Exception
   * 2. Int => User | null
   * 3. Int => User | EmptyUser (magic value)
   */
  Optional<User> getById(int id);
}

public class ErrorApp1 {


//  public static void main(UserRepository repo) {
//    try {
//      User user1 = repo.getById(1);
//    } catch ()
//
//    User user1 = repo.getById(1);
//    if (user1 == null) { ...}
//
//    User user2 = repo.getById(1);
//    if (user2 == EmptyUser) { ...}
//
//  }

}
