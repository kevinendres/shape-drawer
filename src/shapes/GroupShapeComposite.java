package shapes;

import java.util.ArrayList;
import java.util.List;
import model.Point;
import model.ShapeColor;
import model.ShapeType;
import shapes.interfaces.ICopyable;
import shapes.interfaces.IDraw;
import shapes.interfaces.IShadingTypeStrategy;
import shapes.interfaces.IShape;
import view.interfaces.PaintCanvasBase;

public class GroupShapeComposite implements IShape, ICopyable {
  protected List<IShape> children = new ArrayList<>();
  protected Point upperLeft = new Point();
  protected ShapeType shapeType = ShapeType.RECTANGLE;
  protected IDraw drawBehavior = NullDrawObject.getInstance();
  protected IShadingTypeStrategy shadingStrategy = NullShadingStrategy.getInstance();
  protected int height = 0;
  protected int width = 0;

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
    this.upperLeft.x = 2560;
    this.upperLeft.y = 1600;
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
    for (IShape child : children) {
      int childWidth = child.getUpperLeft().x + child.getWidth() - upperLeft.x;
      int childHeight = child.getUpperLeft().y + child.getHeight() - upperLeft.y;
      if (childWidth > this.width) {
        this.width = childWidth;
      }
      if (childHeight > this.height) {
        this.height = childHeight;
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

  @Override
  public ICopyable deepCopy() {
    GroupShapeComposite newGroup = new GroupShapeComposite();
    for (IShape child : children) {
      ICopyable temp = ((ICopyable) child).deepCopy();
      newGroup.addChild((IShape) temp);
    }
    newGroup.setUpperLeft();
    newGroup.setHeightAndWidth();
    return newGroup;
  }
}
