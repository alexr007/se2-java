package l02design;

public class NamingExample {

  static class Person {
    String name;
    Integer id;
    Integer age;
  }

  static class Book {
    String name;
    Integer id;
  }

  interface Behavior {
    void save(Person p);
    Person load(int id);
    boolean isEligibleToOpenAccount(Person p);
  }

  class Behavior1 implements Behavior {
    @Override
    public void save(Person p) {

    }

    @Override
    public Person load(int id) {
      return null;
    }

    @Override
    public boolean isEligibleToOpenAccount(Person p) {
      return false;
    }
  }
  class Behavior2 implements Behavior {
    @Override
    public void save(Person p) {

    }

    @Override
    public Person load(int id) {
      return null;
    }

    @Override
    public boolean isEligibleToOpenAccount(Person p) {
      return false;
    }
  }

  public static void implementation(String[] args, Behavior b) {

    Person p = null;
//    p.age = 35;
//    p.id;
//    p.name;

    b.save(p);

    Person p2 = b.load(33);
    boolean canOpen = b.isEligibleToOpenAccount(p2);

//    String personName = ...;
//    Integer personId = ...
//    Integer personAge = 35;


  }
}
