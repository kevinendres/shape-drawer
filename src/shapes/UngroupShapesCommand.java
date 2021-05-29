package shapes;

import java.util.ArrayList;
import java.util.List;
import model.interact.CommandHistory;
import model.interact.IUndoable;
import shapes.interfaces.IShape;

public class UngroupShapesCommand implements IUndoable {
  private List<IShape> ungroupedShapes = new ArrayList<>();

  public UngroupShapesCommand() {
  }

  public static void run() {
    UngroupShapesCommand ungroupShapesCommand = new UngroupShapesCommand();
    ungroupShapesCommand.ungroupShapes();
    CommandHistory.add(ungroupShapesCommand);
  }

  private void ungroupShapes() {
    for (IShape shape : SelectedShapesList.shapeList) {
      if (shape instanceof GroupShapeComposite) {
        for (IShape child : ((GroupShapeComposite) shape).children) {
          ungroupedShapes.add(child);
        }
        ShapeList.remove(shape);
        SelectedShapesList.remove(shape);
      }
    }
    for (IShape shape : ungroupedShapes) {
      ShapeList.add(shape);
      SelectedShapesList.add(shape);
    }
  }

  @Override
  public void undo() {

  }

  @Override
  public void redo() {

  }

}
