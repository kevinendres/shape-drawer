package shapes;

import java.util.ArrayList;
import java.util.List;
import model.Point;
import model.interact.CommandHistory;
import model.interact.IUndoable;
import shapes.interfaces.ICopyable;
import shapes.interfaces.IDraw;
import shapes.interfaces.IShadingTypeStrategy;
import shapes.interfaces.IShape;

public class PasteShapeCommand implements IUndoable {
  private final List<IShape> pastedShapeList = new ArrayList<>();

  public static void run() {
    PasteShapeCommand command = new PasteShapeCommand();
    command.pasteShapes();
    CommandHistory.add(command);
  }

  public void pasteShapes() {
    for (ICopyable shape : Clipboard.clipboard) {
      IShape temp = (IShape) shape.deepCopy();
      pastedShapeList.add(temp);
      ShapeList.add(temp);
      ((IShape)shape).transform(8,8);
    }
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
