package shapes.drawbehaviors;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Shape;
import shapes.interfaces.IShadingTypeStrategy;

public class FilledShadingStrategy implements IShadingTypeStrategy {

  @Override
  public void shade(Graphics2D g2d, Shape shape, Color primary, Color secondary) {
    g2d.setColor(primary);
    g2d.fill(shape);
  }
}
