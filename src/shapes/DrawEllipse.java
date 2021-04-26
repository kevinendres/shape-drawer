package shapes;

import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.geom.Ellipse2D.Float;
import model.Point;
import model.ShapeColor;
import view.interfaces.PaintCanvasBase;

public class DrawEllipse implements IDraw {

  @Override
  public void draw(PaintCanvasBase paintCanvas, Point origin, int width, int height,
      ShapeColor primaryColor, ShapeColor secondaryColor, IShadingTypeStrategy shadingStrategy) {
    Graphics2D g2d = paintCanvas.getGraphics2D();
    Shape ellipse = new Float(origin.x, origin.y, width, height);
    shadingStrategy.shade(g2d, ellipse, primaryColor.getColor(), secondaryColor.getColor());
  }
}
