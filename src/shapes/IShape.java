package shapes;

import view.interfaces.PaintCanvasBase;

public interface IShape {
  void draw(PaintCanvasBase paintCanvas);
  void select(PaintCanvasBase paintCanvas);
}

