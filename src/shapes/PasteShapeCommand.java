package shapes;

import java.util.ArrayList;
import java.util.List;
import model.interact.CommandHistory;
import model.interact.IUndoable;
import shapes.interfaces.IShape;

public class PasteShapeCommand implements IUndoable {
  private final List<IShape> pastedShapeList = new ArrayList<>();

  public static void run() {
    PasteShapeCommand command = new PasteShapeCommand();
    command.pasteShapes();
  }

  public void pasteShapes() {
    for (IShape shape : Clipboard.clipboard) {
      pastedShapeList.add(shape);
      ShapeList.add(shape);
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
