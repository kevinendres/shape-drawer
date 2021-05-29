package shapes.interfaces;

import model.Point;
import model.ShapeType;
import view.interfaces.PaintCanvasBase;

public interface IShape {
  void draw(PaintCanvasBase paintCanvas);
  void transform(int deltaX, int deltaY);
  ShapeType getShapeType();
  IDraw getDrawBehavior();
  void setDrawBehavior(IDraw drawBehavior);
  Point getUpperLeft();
  int getHeight();
  int getWidth();
}

