package shapes;

import model.Point;
import shapes.interfaces.IDraw;
import shapes.interfaces.IShadingTypeStrategy;
import shapes.interfaces.IShape;

public class CopyShapeCommand {
  public static void copyShapes() {
    Clipboard.clear();
    for (IShape shape : SelectedShapesList.shapeList) {
      Shape oldShape = (Shape) shape;
      IDraw drawBehavior = CreateShapeCommand.createDrawBehavior(oldShape.shapeType);
      IShadingTypeStrategy shadingTypeStrategy = CreateShapeCommand.createShadingStrategy(oldShape.shapeShadingType);
      Point newUpperLeft = new Point(oldShape.upperLeft.x + 7, oldShape.upperLeft.y + 7);
      Shape temp = new Shape(newUpperLeft, oldShape.width, oldShape.height, oldShape.primaryColor,
          oldShape.secondaryColor, oldShape.shapeShadingType, shadingTypeStrategy, oldShape.shapeType,
          drawBehavior);
      Clipboard.add(temp);
    }
  }
}
