package l08paradigms;

public class ObjectOrientedWayBetter {

  abstract static class Point1 {
    int x;
    int y;
    // 1. point creation
    public Point1(int x, int y) {
      this.x = x;
      this.y = y;
    }

    // 3. show operation
    abstract public void show();
    // 3. hide operation
    abstract public void hide();
  }

  static class Point2 {
    int x;
    int y;
    // 1. point creation
    public Point2(int x, int y) {
      this.x = x;
      this.y = y;
    }
  }

  interface Point2Operation {
    // 3. show operation
    void show(Point2 p);
    // 3. hide operation
    void hide(Point2 p);
  }

  class MacOperation implements Point2Operation {
    @Override
    public void show(Point2 p) {

    }

    @Override
    public void hide(Point2 p) {

    }
  }

  class WinOperation implements Point2Operation {
    @Override
    public void show(Point2 p) {

    }

    @Override
    public void hide(Point2 p) {

    }
  }

  class LinuxOperation implements Point2Operation {
    @Override
    public void show(Point2 p) {

    }

    @Override
    public void hide(Point2 p) {

    }
  }

}
