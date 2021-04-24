package shapes;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Shape;

public interface IShadingTypeStrategy {
  void shade(Graphics2D g2d, Shape shape, Color primary, Color secondary);
}
