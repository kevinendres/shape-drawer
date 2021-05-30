package shapes;

import static java.lang.Math.abs;
import static java.lang.Math.min;

import model.Point;
import model.ShapeColor;
import model.ShapeShadingType;
import model.ShapeType;
import shapes.interfaces.ICopyable;
import shapes.interfaces.IDraw;
import shapes.interfaces.IShadingTypeStrategy;
import shapes.interfaces.IShape;
import view.interfaces.PaintCanvasBase;

public class Shape implements IShape, ICopyable {
  protected Point upperLeft;
  protected int height;
  protected int width;
  protected ShapeColor primaryColor;
  protected ShapeColor secondaryColor;
  protected ShapeShadingType shapeShadingType;
  protected IShadingTypeStrategy shapeShadingStrategy;
  protected ShapeType shapeType;
  protected IDraw drawBehavior;

  public Shape(Point upperLeft, int width, int height, ShapeColor primaryColor, ShapeColor secondaryColor,
      ShapeShadingType shapeShadingType, IShadingTypeStrategy shapeShadingStrategy, ShapeType shapeType, IDraw drawBehavior) {
    this.upperLeft = upperLeft;
    this.width = width;
    this.height = height;
    this.primaryColor = primaryColor;
    this.secondaryColor = secondaryColor;
    this.shapeType = shapeType;
    this.shapeShadingType = shapeShadingType;
    this.shapeShadingStrategy = shapeShadingStrategy;
    this.drawBehavior = drawBehavior;
  }

  @Override
  public void draw(PaintCanvasBase paintCanvas) {
    drawBehavior.draw(paintCanvas, upperLeft, width, height, primaryColor, secondaryColor, shapeShadingStrategy);
  }

  protected static Point findUpperLeft(Point pressPoint, Point releasePoint) {
    int x, y;
    x = min(pressPoint.x, releasePoint.x);
    y = min(pressPoint.y, releasePoint.y);
    return new Point(x, y);
  }

  protected static int findHeight(Point pressPoint, Point releasePoint) {
    return abs(releasePoint.y - pressPoint.y);
  }

  protected static int findWidth(Point pressPoint, Point releasePoint) {
    return abs(releasePoint.x - pressPoint.x);
  }

  @Override
  public void transform(int deltaX, int deltaY) {
    this.upperLeft.x += deltaX;
    this.upperLeft.y += deltaY;
  }

  @Override
  public IDraw getDrawBehavior() {
    return drawBehavior;
  }

  @Override
  public void setDrawBehavior(IDraw drawBehavior) {
    this.drawBehavior = drawBehavior;
  }

  @Override
  public int getHeight() {
    return height;
  }

  @Override
  public int getWidth() {
    return width;
  }

  @Override
  public Point getUpperLeft() {
    return upperLeft;
  }

  @Override
  public ShapeType getShapeType() {
    return shapeType;
  }

  @Override
  public ICopyable deepCopy() {
    Point newUpperLeft = new Point(this.upperLeft.x + 4, this.upperLeft.y + 4);
    IDraw newDrawBehavior = CreateShapeCommand.createDrawBehavior(this.shapeType);
    IShadingTypeStrategy newShadingTypeStrategy = CreateShapeCommand.createShadingStrategy(this.shapeShadingType);
    return new Shape(newUpperLeft, this.width, this.height, this.primaryColor, this.secondaryColor,
        this.shapeShadingType, newShadingTypeStrategy, this.shapeType, newDrawBehavior);
  }
}
