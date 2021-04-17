package shapes;

import interact.IUndoable;
import interact.CommandHistory;
import interact.Point;
import interact.ICommand;

public class CreateShapeCommand implements ICommand, IUndoable {
  private Point pressPoint;
  private Point releasePoint;
  private IShape shape;

  public CreateShapeCommand(Point pressPoint, Point releasePoint) {
    this.pressPoint = pressPoint;
    this.releasePoint = releasePoint;
  }

  @Override
  public void run() {
    shape = new Shape(pressPoint, releasePoint);
    ShapeList.add(shape);
    CommandHistory.add(this);
  }

  @Override
  public void undo() {
    ShapeList.remove(shape);
  }

  @Override
  public void redo() {
    ShapeList.add(shape);
  }
}
