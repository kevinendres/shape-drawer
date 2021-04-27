package shapes;

import model.Point;
import model.ShapeColor;
import model.ShapeShadingType;
import model.ShapeType;
import view.interfaces.PaintCanvasBase;

public interface IDraw {
  void draw(PaintCanvasBase paintCanvas, Point origin, int width, int height, ShapeColor primaryColor,
      ShapeColor secondaryColor, IShadingTypeStrategy shadingStrategy);

  void select(PaintCanvasBase paintCanvas, Point upperLeft, int width, int height);
}
