package shapes;

import model.interact.CommandHistory;
import model.interact.ICommand;
import model.interact.IUndoable;
import shapes.interfaces.IShape;

public class GroupShapesCommand implements ICommand, IUndoable {

  public GroupShapesCommand() {
    run();
  }

  @Override
  public void run() {
    groupShapes();
    CommandHistory.add(this);
  }

  private void groupShapes() {
    GroupShapeComposite group = new GroupShapeComposite();
    for (IShape shape : SelectedShapesList.shapeList) {
      group.addChild(shape);
      SelectedShapesList.remove(shape);
      ShapeList.remove(shape);
    }
    createGroupDrawBehavior(group);
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
