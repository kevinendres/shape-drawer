package shapes;

import model.ShapeColor;
import model.ShapeShadingType;
import model.ShapeType;
import model.interact.IUndoable;
import model.interact.CommandHistory;
import model.Point;
import model.interact.ICommand;

public class CreateShapeCommand implements ICommand, IUndoable {
  private Point pressPoint;
  private Point releasePoint;
  private IShape shape;
  protected ShapeColor primaryColor;
  protected ShapeColor secondaryColor;
  protected ShapeShadingType shapeShadingType;
  protected ShapeType shapeType;

  public CreateShapeCommand(Point pressPoint, Point releasePoint, ShapeColor primaryColor, ShapeColor secondaryColor,
    ShapeShadingType shapeShadingType, ShapeType shapeType) {
    this.pressPoint = pressPoint;
    this.releasePoint = releasePoint;
    this.primaryColor = primaryColor;
    this.secondaryColor = secondaryColor;
    this.shapeShadingType = shapeShadingType;
    this.shapeType = shapeType;
  }

  @Override
  public void run() {
    shape = new Shape(pressPoint, releasePoint, primaryColor, secondaryColor, shapeShadingType, shapeType);
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
