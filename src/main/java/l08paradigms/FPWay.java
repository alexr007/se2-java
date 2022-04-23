package l08paradigms;

public class FPWay {

  static class PointOOP {
    int x;
    int y;
    public PointOOP(int x, int y) {
      this.x = x;
      this.y = y;
    }
    public void move(int dx, int dy) {
      x += dx;
      y += dy;
    }
  }

  static class PointFP {
    int x;
    int y;
    public PointFP(int x, int y) {
      this.x = x;
      this.y = y;
    }
    public PointFP move(int dx, int dy) {
      return new PointFP(x + dx, y + dy);
    }
  }

}
