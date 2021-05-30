package shapes;

import java.util.ArrayList;
import java.util.List;
import model.interact.CommandHistory;
import model.interact.IUndoable;
import shapes.interfaces.IShape;

public class UngroupShapesCommand implements IUndoable {
  private List<IShape> ungroupedShapes = new ArrayList<>();
  private GroupShapeComposite group;

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
        this.group = (GroupShapeComposite) shape;
      }
    }
    if (group != null && group.children.size() != 0) {
      for (IShape child : group.children) {
        ShapeList.add(child);
        SelectedShapesList.add(child);
        ungroupedShapes.add(child);
      }
      ShapeList.remove(group);
      SelectedShapesList.remove(group);
    }
  }

  @Override
  public void undo() {
    for (IShape shape : ungroupedShapes) {
      SelectedShapesList.remove(shape);
      ShapeList.remove(shape);
    }
    if (group != null) {
      SelectedShapesList.add(group);
      ShapeList.add(group);
    }
  }

  @Override
  public void redo() {
    for (IShape child : ungroupedShapes) {
      SelectedShapesList.add(child);
      ShapeList.add(child);
    }
    if (group != null) {
      SelectedShapesList.remove(group);
      ShapeList.remove(group);
    }
  }

}
