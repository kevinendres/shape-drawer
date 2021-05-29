package shapes;

import java.util.ArrayList;
import java.util.List;
import model.Point;
import shapes.interfaces.IShape;
import view.interfaces.PaintCanvasBase;

public class GroupShapeComposite implements IShape {
  private List<IShape> children = new ArrayList<>();
  protected Point upperLeft;
  protected int height;
  protected int width;

  public void addChild(IShape shape) {
    children.add(shape);
  }

  @Override
  public void draw(PaintCanvasBase paintCanvas) {
    for (IShape child : children) {
      child.draw(paintCanvas);
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
