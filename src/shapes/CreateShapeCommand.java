package shapes;

import model.ShapeColor;
import model.ShapeShadingType;
import model.ShapeType;
import model.interact.IUndoable;
import model.interact.CommandHistory;
import model.Point;
import model.interact.ICommand;
import shapes.interfaces.IDraw;
import shapes.interfaces.IShadingTypeStrategy;
import shapes.interfaces.IShape;

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
    IDraw drawBehavior = createDrawBehavior();
    IShadingTypeStrategy shadingTypeStrategy = createShadingStrategy();
    shape = new Shape(pressPoint, releasePoint, primaryColor, secondaryColor, shadingTypeStrategy, shapeType,
        drawBehavior);
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

  private IDraw createDrawBehavior() {
    switch(shapeType) {
      case RECTANGLE:
        return DrawStaticFactory.createRectangle();
      case TRIANGLE:
        return DrawStaticFactory.createTriangle();
      case ELLIPSE:
        return DrawStaticFactory.createEllipse();
      default:
        return null;
    }
  }

  private IShadingTypeStrategy createShadingStrategy() {
    switch (shapeShadingType) {
      case OUTLINE:
        return ShadingStrategyStaticFactory.createOutlineStrategy();
      case FILLED_IN:
        return ShadingStrategyStaticFactory.createFilledStrategy();
      case OUTLINE_AND_FILLED_IN:
        return ShadingStrategyStaticFactory.createOutlineAndFilledStrategy();
      default:
        return null;
    }
  }
}
