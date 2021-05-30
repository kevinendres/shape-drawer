package shapes;

import java.util.ArrayList;
import java.util.List;
import shapes.interfaces.IShape;

public class ShapeList {
  protected static final List<IShape> shapeList = new ArrayList<>();

  public static void add(IShape shape) {
    shapeList.add(shape);
    ShapeDrawer.drawAllShapes();
  }

  public static void remove(IShape shape) {
    shapeList.remove(shape);
    ShapeDrawer.drawAllShapes();
  }
}
