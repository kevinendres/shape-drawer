package shapes;

import model.Point;
import model.interact.ICommand;
import shapes.interfaces.IShape;

public class SelectShapesCommand implements ICommand {
  private Point upperLeft;
  private int height;
  private int width;

  public SelectShapesCommand(Point pressPoint, Point releasePoint) {
    this.upperLeft = Shape.getOrigin(pressPoint, releasePoint);
    this.height = Shape.getHeight(pressPoint, releasePoint);
    this.width = Shape.getWidth(pressPoint, releasePoint);
  }


  @Override
  public void run() {
    emptySelectedShapesList();
    selectShapes();
    ShapeDrawer.drawAllShapes();
  }

  private void selectShapes() {
    for (IShape shape : ShapeList.shapeList) {
      if (selectionContainsShape((Shape)shape)) {
        SelectedShapesList.add(shape);
      }
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
     if  (selectYinShapeY || shapeYinSelectY) {
       return true;
     }
     else {
       return false;
     }
    }
   else {
     return false;
   }
  }

  private void emptySelectedShapesList() {
    SelectedShapesList.clear();
  }
}
