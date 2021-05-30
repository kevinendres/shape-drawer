package shapes;

import model.Point;
import shapes.interfaces.ICopyable;
import shapes.interfaces.IDraw;
import shapes.interfaces.IShadingTypeStrategy;
import shapes.interfaces.IShape;

public class CopyShapeCommand {
  public static void copyShapes() {
    Clipboard.clear();
    for (IShape shape : SelectedShapesList.shapeList) {
      ICopyable temp = ((ICopyable) shape).deepCopy();
      Clipboard.add(temp);
    }
  }
}
