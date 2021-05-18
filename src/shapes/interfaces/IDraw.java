package shapes.interfaces;

import model.Point;
import model.ShapeColor;
import view.interfaces.PaintCanvasBase;

public interface IDraw {
  void draw(PaintCanvasBase paintCanvas, Point origin, int width, int height, ShapeColor primaryColor,
      ShapeColor secondaryColor, IShadingTypeStrategy shadingStrategy);

}
