package shapes;

import static java.lang.Math.abs;
import static java.lang.Math.min;

import interact.Point;
import view.interfaces.PaintCanvasBase;

public class Shape implements IShape {
  protected Point origin;
  protected int height;
  protected int width;
  protected IDraw drawBehavior;

  public Shape(Point pressPoint, Point releasePoint) {
    origin = getOrigin(pressPoint, releasePoint);
    height = abs(releasePoint.y - pressPoint.y);
    width = abs(releasePoint.x - pressPoint.x);
    drawBehavior = new Draw();
  }

  @Override
  public void draw(PaintCanvasBase paintCanvas) {
    drawBehavior.draw(paintCanvas, this.origin, this.width, this.height);
  }

  private Point getOrigin(Point pressPoint, Point releasePoint) {
    int x, y;
    x = min(pressPoint.x, releasePoint.x);
    y = min(pressPoint.y, releasePoint.y);
    return new Point(x, y);
  }
}
