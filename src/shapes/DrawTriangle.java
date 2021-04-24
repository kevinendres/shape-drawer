package shapes;

import java.awt.Graphics2D;
import java.awt.Polygon;
import java.awt.Rectangle;
import java.awt.Shape;
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
}
