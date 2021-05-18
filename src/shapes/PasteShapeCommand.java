package shapes;

import java.util.ArrayList;
import java.util.List;
import model.Point;
import model.interact.CommandHistory;
import model.interact.IUndoable;
import shapes.interfaces.IDraw;
import shapes.interfaces.IShadingTypeStrategy;
import shapes.interfaces.IShape;

public class PasteShapeCommand implements IUndoable {
  private final List<IShape> pastedShapeList = new ArrayList<>();

  public static void run() {
    PasteShapeCommand command = new PasteShapeCommand();
    command.pasteShapes();
  }

  public void pasteShapes() {
    for (IShape shape : Clipboard.clipboard) {
      Shape oldShape = (Shape) shape;
      IDraw drawBehavior = CreateShapeCommand.createDrawBehavior(oldShape.shapeType);
      IShadingTypeStrategy shadingTypeStrategy = CreateShapeCommand.createShadingStrategy(oldShape.shapeShadingType);
      Point newUpperLeft = new Point(oldShape.upperLeft.x + 7, oldShape.upperLeft.y + 7);
      Shape temp = new Shape(newUpperLeft, oldShape.width, oldShape.height, oldShape.primaryColor,
          oldShape.secondaryColor, oldShape.shapeShadingType, shadingTypeStrategy, oldShape.shapeType,
          drawBehavior);
      pastedShapeList.add(temp);
      ShapeList.add(temp);
    }
    CommandHistory.add(this);
  }

  @Override
  public void undo() {
    for (IShape shape : pastedShapeList) {
      ShapeList.remove(shape);
    }
  }

  @Override
  public void redo() {
    for (IShape shape : pastedShapeList) {
      ShapeList.add(shape);
    }
  }
}
