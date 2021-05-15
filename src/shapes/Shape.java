package shapes;

import static java.lang.Math.abs;
import static java.lang.Math.min;

import model.Point;
import model.ShapeColor;
import model.ShapeShadingType;
import model.ShapeType;
import shapes.interfaces.IDraw;
import shapes.interfaces.IShadingTypeStrategy;
import shapes.interfaces.IShape;
import view.interfaces.PaintCanvasBase;

public class Shape implements IShape {
  protected Point upperLeft;
  protected int height;
  protected int width;
  protected ShapeColor primaryColor;
  protected ShapeColor secondaryColor;
  protected IShadingTypeStrategy shapeShadingStrategy;
  protected ShapeType shapeType;
  protected IDraw drawBehavior;

  public Shape(Point pressPoint, Point releasePoint, ShapeColor primaryColor, ShapeColor secondaryColor,
      IShadingTypeStrategy shapeShadingStrategy, ShapeType shapeType, IDraw drawBehavior) {
    this.upperLeft = getOrigin(pressPoint, releasePoint);
    this.height = getHeight(pressPoint, releasePoint);
    this.width = getWidth(pressPoint, releasePoint);
    this.primaryColor = primaryColor;
    this.secondaryColor = secondaryColor;
    this.shapeType = shapeType;
    this.shapeShadingStrategy = shapeShadingStrategy;
    this.drawBehavior = drawBehavior;
  }

  public Shape(Shape otherShape) {
    this.upperLeft = otherShape.upperLeft;
    this.height = otherShape.height;
    this.width = otherShape.width;
    this.primaryColor = otherShape.primaryColor;
    this.secondaryColor = otherShape.secondaryColor;
    this.shapeType = otherShape.shapeType;
    this.shapeShadingStrategy = otherShape.shapeShadingStrategy;
    this.drawBehavior = otherShape.drawBehavior;
  }

  @Override
  public void draw(PaintCanvasBase paintCanvas) {
    drawBehavior.draw(paintCanvas, upperLeft, width, height, primaryColor, secondaryColor, shapeShadingStrategy);
  }

  public void select(PaintCanvasBase paintCanvas) {
    drawBehavior.select(paintCanvas, upperLeft, width, height);
  }

  protected static Point getOrigin(Point pressPoint, Point releasePoint) {
    int x, y;
    x = min(pressPoint.x, releasePoint.x);
    y = min(pressPoint.y, releasePoint.y);
    return new Point(x, y);
  }

  protected static int getHeight(Point pressPoint, Point releasePoint) {
    return abs(releasePoint.y - pressPoint.y);
  }

  protected static int getWidth(Point pressPoint, Point releasePoint) {
    return abs(releasePoint.x - pressPoint.x);
  }
}
