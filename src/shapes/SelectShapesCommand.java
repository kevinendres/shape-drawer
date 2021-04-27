package shapes;

import java.util.ArrayList;
import java.util.List;
import model.Point;
import model.interact.ICommand;
import model.interact.IUndoable;

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
    int shapeXMin = shape.origin.x;
    int shapeXMax = shape.origin.x + shape.width;
    int shapeYMin = shape.origin.y;
    int shapeYMax = shape.origin.y + shape.height;
    int selectXMin = upperLeft.x;
    int selectXMax = upperLeft.x + width;
    int selectYMin = upperLeft.y;
    int selectYMax = upperLeft.y + height;

    if ((shapeXMin >= selectXMin && shapeXMin <= selectXMax) ||
        (shapeXMax >= selectXMin && shapeXMax <= selectXMax)) {
     if ((shapeYMin >= selectYMin && shapeYMin <= selectYMax) ||
         (shapeYMax >= selectYMin && shapeYMax <= selectYMax)) {
       return true;
     }
     if ((selectYMin >= shapeYMin && selectYMin <= shapeYMax) ||
          (selectYMax >= shapeYMin && selectYMax <= shapeYMax)) {
        return true;
     }
     return false;
    }
    else if ((selectXMin >= shapeXMin && selectXMin <= shapeXMax) ||
        (selectXMax >= shapeXMin && selectXMax <= shapeXMax)) {
      if ((selectYMin >= shapeYMin && selectYMin <= shapeYMax) ||
          (selectYMax >= shapeYMin && selectYMax <= shapeYMax)) {
        return true;
      }
      return false;
    }
   else {
     return false;
   }
  }

  private void emptySelectedShapesList() {
    SelectedShapesList.clear();
  }
}
