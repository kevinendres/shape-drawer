package shapes;

import java.awt.BasicStroke;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.Stroke;
import model.Point;
import java.awt.Color;
import java.awt.Graphics2D;
import model.ShapeColor;
import shapes.interfaces.IDraw;
import shapes.interfaces.IShadingTypeStrategy;
import view.interfaces.PaintCanvasBase;

public class DrawRectangle implements IDraw {
  @Override
  public void draw(PaintCanvasBase paintCanvas, Point origin, int width, int height,
      ShapeColor primaryColor, ShapeColor secondaryColor, IShadingTypeStrategy shadingStrategy) {
    Graphics2D g2d = paintCanvas.getGraphics2D();
    Shape rect = new Rectangle(origin.x, origin.y, width, height);
    shadingStrategy.shade(g2d, rect, primaryColor.getColor(), secondaryColor.getColor());
  }

  public void select(PaintCanvasBase paintCanvas, Point upperLeft, int width, int height) {
    Graphics2D g2d = paintCanvas.getGraphics2D();
    Stroke stroke = new BasicStroke(3, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL, 1, new float[]{9}, 0);
    g2d.setStroke(stroke);
    g2d.setColor(Color.BLACK);
    g2d.drawRect(upperLeft.x - 5, upperLeft.y - 5, width + 10, height + 10);
  }
}
