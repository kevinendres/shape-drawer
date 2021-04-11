package shapes;

import interact.Point;

public class Triangle implements Shape {
  public Point origin;

  public Triangle(Point origin) {
    this.origin = origin;
  }

  @Override
  public void draw(Point press, Point release) {

  }
}
