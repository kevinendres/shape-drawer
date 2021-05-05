package shapes;

import java.util.ArrayList;
import java.util.List;
import model.Point;
import model.interact.CommandHistory;
import model.interact.ICommand;
import model.interact.IUndoable;
import shapes.interfaces.IShape;

public class MoveShapesCommand implements ICommand, IUndoable {
  private Point pressPoint;
  private Point releasePoint;
  private int deltaX;
  private int deltaY;
  private List<IShape> movedShapesList = new ArrayList<>();

  public MoveShapesCommand(Point pressPoint, Point releasePoint) {
    this.pressPoint = pressPoint;
    this.releasePoint = releasePoint;
    this.deltaX = computeDeltaX();
    this.deltaY = computeDeltaY();
  }
  @Override
  public void run() {
    for (IShape shape : SelectedShapesList.shapeList) {
      transform((Shape)shape);
      this.movedShapesList.add(shape);
    }
    ShapeDrawer.drawAllShapes();
    CommandHistory.add(this);
  }

  private void transform(Shape shape) {
    shape.origin.x += deltaX;
    shape.origin.y += deltaY;
  }

  private void untransform(Shape shape) {
    shape.origin.x -= deltaX;
    shape.origin.y -= deltaY;
  }

  private int computeDeltaX() {
    return releasePoint.x - pressPoint.x;
  }

  private int computeDeltaY() {
    return releasePoint.y - pressPoint.y;
  }

  @Override
  public void undo() {
    for (IShape shape : this.movedShapesList) {
      untransform((Shape)shape);
    }
    ShapeDrawer.drawAllShapes();
  }

  @Override
  public void redo() {
    for (IShape shape : this.movedShapesList) {
      transform((Shape)shape);
    }
    ShapeDrawer.drawAllShapes();
  }

}
