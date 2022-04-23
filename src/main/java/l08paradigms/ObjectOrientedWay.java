package l08paradigms;

public class ObjectOrientedWay {

  static class Point {
    int x;
    int y;

    // 1. point creation
    public Point(int x, int y) {
      this.x = x;
      this.y = y;
    }

    // 2. move operation
    public void move(int dx, int dy) {
      this.x = this.x + dx;
      this.y = this.y + dy;
    }

    // 3. show operation
    public void show() {}

    // 3. hide operation
    public void hide() {}

  }

  public static void objectOriented() {
    Point point1 = new Point(10, 10);
    point1.hide();
    point1.move(3,3); // 13, 13
    point1.show();

    Point point2 = new Point(20, 20);
    point2.move(2,2); // 22, 22
  }

}
