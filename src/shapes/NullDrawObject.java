package shapes;

import model.Point;
import model.ShapeColor;
import shapes.interfaces.IDraw;
import shapes.interfaces.IShadingTypeStrategy;
import view.interfaces.PaintCanvasBase;

public class NullDrawObject implements IDraw {
  private static NullDrawObject instance;
  private NullDrawObject() {}

  public static IDraw getInstance() {
    if (instance == null) {
      instance = new NullDrawObject();
    }
    else {
      //do nothing
    }
    return instance;
  }

  @Override
  public void draw(PaintCanvasBase paintCanvas, Point origin, int width, int height,
      ShapeColor primaryColor, ShapeColor secondaryColor, IShadingTypeStrategy shadingStrategy) {
    //do nothing
  }
}
