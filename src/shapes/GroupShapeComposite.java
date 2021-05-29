package shapes;

import java.util.ArrayList;
import java.util.List;
import model.Point;
import model.ShapeColor;
import model.ShapeType;
import shapes.interfaces.IDraw;
import shapes.interfaces.IShadingTypeStrategy;
import shapes.interfaces.IShape;
import view.interfaces.PaintCanvasBase;

public class GroupShapeComposite implements IShape {
  private List<IShape> children = new ArrayList<>();
  protected Point upperLeft;
  protected ShapeType shapeType = ShapeType.RECTANGLE;
  protected IDraw drawBehavior = NullDrawObject.getInstance();
  protected IShadingTypeStrategy shadingStrategy = NullShadingStrategy.getInstance();
  protected int height;
  protected int width;

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

  public void transform(int deltaX, int deltaY) {
    this.upperLeft.x += deltaX;
    this.upperLeft.y += deltaY;
    for (IShape shape : children) {
      ((Shape)shape).transform(deltaX, deltaY);
    }
  }

  public void untransform(int deltaX, int deltaY) {
    this.upperLeft.x -= deltaX;
    this.upperLeft.y -= deltaY;
    for (IShape shape : children) {
      ((Shape)shape).untransform(deltaX, deltaY);
    }
  }

  protected void setUpperLeft() {
    this.upperLeft.x = ((Shape)children.get(0)).upperLeft.x;
    this.upperLeft.y = ((Shape)children.get(0)).upperLeft.y;
    for (IShape child : children) {
      if (((Shape)child).upperLeft.x < this.upperLeft.x) {
        this.upperLeft.x = ((Shape)child).upperLeft.x;
      }
      if (((Shape)child).upperLeft.y < this.upperLeft.y) {
        this.upperLeft.y = ((Shape)child).upperLeft.y;
      }
    }
  }

  protected void setHeightAndWidth() {
    Point bottomRight = this.upperLeft;
    for (IShape child : children) {
      if (((Shape)child).upperLeft.x > bottomRight.x) {
        bottomRight.x = ((Shape)child).upperLeft.x;
        this.width = bottomRight.x + ((Shape)child).width - upperLeft.x;
      }
      if (((Shape)child).upperLeft.y > bottomRight.y) {
        bottomRight.y = ((Shape)child).upperLeft.y;
        this.height = bottomRight.y + ((Shape)child).height - upperLeft.y;
      }
    }
  }

}
