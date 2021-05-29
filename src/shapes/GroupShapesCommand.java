package shapes;

import java.util.ArrayList;
import java.util.List;
import model.interact.CommandHistory;
import model.interact.ICommand;
import model.interact.IUndoable;
import shapes.interfaces.IShape;

public class GroupShapesCommand implements IUndoable {
  private List<IShape> groupedShapes = new ArrayList<>();

  public GroupShapesCommand() {
  }

  public static void run() {
    GroupShapesCommand groupShapesCommand = new GroupShapesCommand();
    groupShapesCommand.groupShapes();
    CommandHistory.add(groupShapesCommand);
  }

  private void groupShapes() {
    GroupShapeComposite group = new GroupShapeComposite();
    for (IShape shape : SelectedShapesList.shapeList) {
      groupedShapes.add(shape);
      group.addChild(shape);
      ShapeList.remove(shape);
    }
    group.setUpperLeft();
    group.setHeightAndWidth();
    SelectShapesCommand.emptySelectedShapesList();
    SelectedShapesList.add(group);
    SelectShapesCommand.applyDecorators();
    ShapeList.add(group);
  }

  @Override
  public void undo() {

  }

  @Override
  public void redo() {

  }
}
