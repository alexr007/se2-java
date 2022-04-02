package l01intro;

public class DataDesign {

  class Data { }
  class Person {}
  class Account {}
  class Currency {}
  class Customer {
    Integer age;
  }
  class Report {
    Long turnover;
  }

  interface Behavior {
    Customer createCustomer();
  }

  interface DAO {
    void saveMyData(Data data);
  }

  class DAOFile implements DAO {
    @Override
    public void saveMyData(Data data) {

    }
  }
  class DAOSQL implements DAO {
    @Override
    public void saveMyData(Data data) {

    }
  }
  class DAOnoSQL implements DAO {
    @Override
    public void saveMyData(Data data) {

    }
  }
  class DAOBinFile implements DAO {
    @Override
    public void saveMyData(Data data) {

    }
  }

  public void b() {
    DAO dao = new DAOBinFile();
    dao.saveMyData(null);
  }


  boolean isEligibleToLoan(Customer customer, Report report) {
    if (report.turnover > 100000) return true;
    if (customer.age > 30) return true;
    return false;
  }

  interface Formatter {
    Data format(Data origin);
  }

  public void doSomethingWithMyData(Data data, Formatter fmt) {
    Data formattedData = fmt.format(data);
  }

}
