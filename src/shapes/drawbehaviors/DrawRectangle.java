package shapes.drawbehaviors;

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
}
