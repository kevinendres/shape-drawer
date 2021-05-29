package shapes.interfaces;

import model.Point;
import view.interfaces.PaintCanvasBase;

public interface IDrawSelectionDecorator extends IDraw {
  void select(PaintCanvasBase paintCanvas, Point upperLeft, int width, int height);
  IDraw getOriginalDrawBehavior();
}
