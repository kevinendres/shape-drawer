package shapes;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Polygon;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.Stroke;
import model.Point;
import model.ShapeColor;
import model.ShapeShadingType;
import model.ShapeType;
import view.interfaces.PaintCanvasBase;

public class DrawTriangle implements IDraw {

  @Override
  public void draw(PaintCanvasBase paintCanvas, Point origin, int width, int height,
      ShapeColor primaryColor, ShapeColor secondaryColor, IShadingTypeStrategy shadingStrategy) {
    Graphics2D g2d = paintCanvas.getGraphics2D();
    Shape triangle = new Polygon(new int[] {origin.x, origin.x, origin.x + width}, new int[] {origin.y,
        origin.y + height, origin.y + height}, 3);
    shadingStrategy.shade(g2d, triangle, primaryColor.getColor(), secondaryColor.getColor());
  }

  public void select(PaintCanvasBase paintCanvas, Point upperLeft, int width, int height) {
    Graphics2D g2d = paintCanvas.getGraphics2D();
    Stroke stroke = new BasicStroke(3, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL, 1, new float[]{9}, 0);
    g2d.setStroke(stroke);
    g2d.setColor(Color.BLACK);
    g2d.drawPolygon(new int[] {upperLeft.x - 3, upperLeft.x - 3, upperLeft.x + width + 9}, new int[] {upperLeft.y - 6,
        upperLeft.y + height + 3, upperLeft.y + height + 3}, 3);
  }
}
