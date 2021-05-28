package shapes;

import java.util.ArrayList;
import java.util.List;
import shapes.interfaces.IShape;
import view.interfaces.PaintCanvasBase;

public class GroupShapeComposite implements IShape {
  private List<IShape> children = new ArrayList<>();

  public void addChild(IShape shape) {
    children.add(shape);
  }

  @Override
  public void draw(PaintCanvasBase paintCanvas) {
    for (IShape child : children) {
      child.draw(paintCanvas);
    }
  }
}
