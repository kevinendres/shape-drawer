package shapes;

import static java.lang.Math.abs;
import static java.lang.Math.min;

import model.Point;
import model.ShapeColor;
import model.ShapeShadingType;
import model.ShapeType;
import view.interfaces.PaintCanvasBase;

public class Shape implements IShape {
  protected Point origin;
  protected int height;
  protected int width;
  protected ShapeColor primaryColor;
  protected ShapeColor secondaryColor;
  protected IShadingTypeStrategy shapeShadingType;
  protected ShapeType shapeType;
  protected IDraw drawBehavior;

  public Shape(Point pressPoint, Point releasePoint, ShapeColor primaryColor, ShapeColor secondaryColor,
      ShapeShadingType shapeShadingType, ShapeType shapeType) {
    origin = getOrigin(pressPoint, releasePoint);
    height = getHeight(pressPoint, releasePoint);
    width = getWidth(pressPoint, releasePoint);
    this.primaryColor = primaryColor;
    this.secondaryColor = secondaryColor;
    this.shapeShadingType = IDrawStaticFactory.createShadingStrategy(shapeShadingType);
    this.shapeType = shapeType;
    this.drawBehavior = IDrawStaticFactory.createDrawBehavior(shapeType);
  }

  @Override
  public void draw(PaintCanvasBase paintCanvas) {
    drawBehavior.draw(paintCanvas, origin, width, height, primaryColor, secondaryColor, shapeShadingType);
  }

  private Point getOrigin(Point pressPoint, Point releasePoint) {
    int x, y;
    x = min(pressPoint.x, releasePoint.x);
    y = min(pressPoint.y, releasePoint.y);
    return new Point(x, y);
  }

  private int getHeight(Point pressPoint, Point releasePoint) {
    return abs(releasePoint.y - pressPoint.y);
  }

  private int getWidth(Point pressPoint, Point releasePoint) {
    return abs(releasePoint.x - pressPoint.x);
  }
}
