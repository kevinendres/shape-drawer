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
      group.addChild(shape);
      SelectedShapesList.remove(shape);
      ShapeList.remove(shape);
    }
    group.setUpperLeft();
    group.setHeightAndWidth();
    ShapeList.add(group);
    SelectedShapesList.add(group);
  }

  private void createGroupDrawBehavior(GroupShapeComposite group) {

  }

  @Override
  public void undo() {

  }

  @Override
  public void redo() {

  }
}
