package shapes;

import interact.Point;
import view.interfaces.PaintCanvasBase;

public interface IDraw {
  void draw(PaintCanvasBase paintCanvas, Point origin, int width, int height);
}
