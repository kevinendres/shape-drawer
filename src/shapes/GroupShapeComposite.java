package shapes;

import java.util.ArrayList;
import java.util.List;
import model.Point;
import model.ShapeColor;
import model.ShapeType;
import shapes.drawbehaviors.RectangleSelectionDecorator;
import shapes.interfaces.IDraw;
import shapes.interfaces.IShadingTypeStrategy;
import shapes.interfaces.IShape;
import view.interfaces.PaintCanvasBase;

public class GroupShapeComposite implements IShape {
  protected List<IShape> children = new ArrayList<>();
  protected Point upperLeft = new Point();
  protected ShapeType shapeType = ShapeType.RECTANGLE;
  protected IDraw drawBehavior = NullDrawObject.getInstance();
  protected IShadingTypeStrategy shadingStrategy = NullShadingStrategy.getInstance();
  protected int height;
  protected int width;

  public GroupShapeComposite() {

  }

  public void addChild(IShape shape) {
    children.add(shape);
  }

  @Override
  public void draw(PaintCanvasBase paintCanvas) {
    drawBehavior.draw(paintCanvas, upperLeft, width, height, ShapeColor.BLACK, ShapeColor.BLACK, shadingStrategy);
    for (IShape child : children) {
      child.draw(paintCanvas);
    }
  }

  @Override
  public void transform(int deltaX, int deltaY) {
    this.upperLeft.x += deltaX;
    this.upperLeft.y += deltaY;
    for (IShape shape : children) {
      shape.transform(deltaX, deltaY);
    }
  }

  protected void setUpperLeft() {
    this.upperLeft.x = 1920;
    this.upperLeft.y = 1080;
    for (IShape child : children) {
      if (child.getUpperLeft().x < this.upperLeft.x) {
        this.upperLeft.x = child.getUpperLeft().x;
      }
      if (child.getUpperLeft().y < this.upperLeft.y) {
        this.upperLeft.y = child.getUpperLeft().y;
      }
    }
  }

  protected void setHeightAndWidth() {
    Point bottomRight = new Point();
    bottomRight.x = this.upperLeft.x;
    bottomRight.y = this.upperLeft.y;
    for (IShape child : children) {
      if (child.getUpperLeft().x > bottomRight.x) {
        bottomRight.x = child.getUpperLeft().x;
        this.width = bottomRight.x + child.getWidth() - upperLeft.x;
      }
      if (child.getUpperLeft().y > bottomRight.y) {
        bottomRight.y = child.getUpperLeft().y;
        this.height = bottomRight.y + child.getHeight() - upperLeft.y;
      }
    }
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
}
