package shapes;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Shape;

public class FilledShadingStrategy implements IShadingTypeStrategy {

  @Override
  public void shade(Graphics2D g2d, Shape shape, Color primary, Color secondary) {
    g2d.setColor(primary);
    g2d.fill(shape);
  }
}
