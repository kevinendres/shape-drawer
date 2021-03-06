package shapes.drawbehaviors;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Shape;
import shapes.interfaces.IShadingTypeStrategy;

public class OutlineShadingStrategy implements IShadingTypeStrategy {

  @Override
  public void shade(Graphics2D g2d, Shape shape, Color primary, Color secondary) {
    g2d.setColor(secondary);
    g2d.draw(shape);
  }

}
