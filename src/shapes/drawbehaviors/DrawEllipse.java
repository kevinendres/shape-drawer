package shapes.drawbehaviors;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.Stroke;
import java.awt.geom.Ellipse2D.Float;
import model.Point;
import model.ShapeColor;
import shapes.interfaces.IDraw;
import shapes.interfaces.IShadingTypeStrategy;
import view.interfaces.PaintCanvasBase;

public class DrawEllipse implements IDraw {

  @Override
  public void draw(PaintCanvasBase paintCanvas, Point origin, int width, int height,
      ShapeColor primaryColor, ShapeColor secondaryColor, IShadingTypeStrategy shadingStrategy) {
    Graphics2D g2d = paintCanvas.getGraphics2D();
    Shape ellipse = new Float(origin.x, origin.y, width, height);
    shadingStrategy.shade(g2d, ellipse, primaryColor.getColor(), secondaryColor.getColor());
  }

  public void select(PaintCanvasBase paintCanvas, Point upperLeft, int width, int height) {
    Graphics2D g2d = paintCanvas.getGraphics2D();
    Stroke stroke = new BasicStroke(3, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL, 1, new float[]{9}, 0);
    g2d.setStroke(stroke);
    g2d.setColor(Color.BLACK);
    Shape ellipse = new Float(upperLeft.x - 5, upperLeft.y - 5, width + 10, height + 10);
    g2d.draw(ellipse);
  }
}
