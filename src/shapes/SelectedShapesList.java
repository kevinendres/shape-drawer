package shapes;

import java.util.ArrayList;
import java.util.List;
import shapes.interfaces.IShape;

public class SelectedShapesList {
  protected static final List<IShape> shapeList = new ArrayList<>();

  public static void add(IShape shape) {
    shapeList.add(shape);
  }

  public static void remove(IShape shape) { shapeList.remove(shape); }

  public static void clear() {
    shapeList.clear();
  }

}
