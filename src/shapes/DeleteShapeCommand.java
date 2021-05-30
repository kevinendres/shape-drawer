package shapes;

import java.util.ArrayList;
import java.util.List;
import model.interact.CommandHistory;
import model.interact.IUndoable;
import shapes.interfaces.IShape;

public class DeleteShapeCommand implements IUndoable {
  private final List<IShape> deletedShapeList = new ArrayList<>();

  public static void run() {
    DeleteShapeCommand command = new DeleteShapeCommand();
    command.deleteShapes();
    CommandHistory.add(command);
  }

  public void deleteShapes() {
    for (IShape shape : SelectedShapesList.shapeList) {
      ShapeList.remove(shape);
      deletedShapeList.add(shape);
    }
    SelectedShapesList.clear();
  }

  @Override
  public void undo() {
    for (IShape shape : deletedShapeList) {
      ShapeList.add(shape);
    }
  }

  @Override
  public void redo() {
    for (IShape shape : deletedShapeList) {
      ShapeList.remove(shape);
    }
  }
}
