package shapes;

import static java.lang.Math.abs;
import static java.lang.Math.min;

import model.Point;
import model.ShapeType;
import model.interact.ICommand;
import shapes.drawbehaviors.EllipseSelectionDecorator;
import shapes.drawbehaviors.RectangleSelectionDecorator;
import shapes.drawbehaviors.TriangleSelectionDecorator;
import shapes.interfaces.IDraw;
import shapes.interfaces.IShape;

public class SelectShapesCommand implements ICommand {
  private final Point upperLeft;
  private final int height;
  private final int width;

  public SelectShapesCommand(Point pressPoint, Point releasePoint) {
    this.upperLeft = getUpperLeft(pressPoint, releasePoint);
    this.height = getHeight(pressPoint, releasePoint);
    this.width = getWidth(pressPoint, releasePoint);
  }

  @Override
  public void run() {
    emptySelectedShapesList();
    selectShapes();
    applyDecorators();
    ShapeDrawer.drawAllShapes();
  }

  private void selectShapes() {
    for (IShape shape : ShapeList.shapeList) {
      if (selectionContainsShape((Shape)shape)) {
        SelectedShapesList.add(shape);
      }
    }
  }

  private void applyDecorators() {
    for (IShape shape : SelectedShapesList.shapeList) {
      ((Shape)shape).drawBehavior = createDecorator(((Shape)shape).shapeType, ((Shape)shape).drawBehavior);
    }
  }

  private void removeDecorators() {
    for (IShape shape : SelectedShapesList.shapeList) {
      ((Shape)shape).drawBehavior = CreateShapeCommand.createDrawBehavior(((Shape)shape).shapeType);
    }
  }

  private IDraw createDecorator(ShapeType shapeType, IDraw drawBehavior) {
    switch (shapeType) {
      case ELLIPSE: return new EllipseSelectionDecorator(drawBehavior);
      case TRIANGLE: return new TriangleSelectionDecorator(drawBehavior);
      case RECTANGLE: return new RectangleSelectionDecorator(drawBehavior);
      default: return null;
    }
  }

  private boolean selectionContainsShape(Shape shape) {
    int shapeXMin = shape.upperLeft.x;
    int shapeXMax = shape.upperLeft.x + shape.width;
    int shapeYMin = shape.upperLeft.y;
    int shapeYMax = shape.upperLeft.y + shape.height;
    int selectXMin = upperLeft.x;
    int selectXMax = upperLeft.x + width;
    int selectYMin = upperLeft.y;
    int selectYMax = upperLeft.y + height;

    boolean shapeXinSelectX = (shapeXMin >= selectXMin && shapeXMin <= selectXMax) ||
        (shapeXMax >= selectXMin && shapeXMax <= selectXMax);
    boolean shapeYinSelectY = (shapeYMin >= selectYMin && shapeYMin <= selectYMax) ||
        (shapeYMax >= selectYMin && shapeYMax <= selectYMax);
    boolean selectYinShapeY = (selectYMin >= shapeYMin && selectYMin <= shapeYMax) ||
        (selectYMax >= shapeYMin && selectYMax <= shapeYMax);
    boolean selectXinShapeX = (selectXMin >= shapeXMin && selectXMin <= shapeXMax) ||
        (selectXMax >= shapeXMin && selectXMax <= shapeXMax);

    if (shapeXinSelectX || selectXinShapeX) {
      return selectYinShapeY || shapeYinSelectY;
    }
   else {
     return false;
   }
  }

  private void emptySelectedShapesList() {
    removeDecorators();
    SelectedShapesList.clear();
  }

  protected static Point getUpperLeft(Point pressPoint, Point releasePoint) {
    int x, y;
    x = min(pressPoint.x, releasePoint.x);
    y = min(pressPoint.y, releasePoint.y);
    return new Point(x, y);
  }

  protected static int getHeight(Point pressPoint, Point releasePoint) {
    return abs(releasePoint.y - pressPoint.y);
  }

  protected static int getWidth(Point pressPoint, Point releasePoint) {
    return abs(releasePoint.x - pressPoint.x);
  }
}
