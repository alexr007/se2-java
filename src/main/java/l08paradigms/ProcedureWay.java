package l08paradigms;

public class ProcedureWay {

  static class Point {
    int x;
    int y;

    public Point(int x, int y) {
      this.x = x;
      this.y = y;
    }
  }

  /** move implementation can be reused */
  public static void move(Point p) {
    ///
  }

  public static void procedural(String[] args) {
    Point point = new Point(10, 10);
    move(point);
  }

}
