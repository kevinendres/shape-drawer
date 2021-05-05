package shapes;

import model.ShapeShadingType;
import shapes.interfaces.IShadingTypeStrategy;

public class ShadingStrategyStaticFactory {

  public static IShadingTypeStrategy createOutlineStrategy() {
    return new OutlineShadingStrategy();
  }

  public static IShadingTypeStrategy createFilledStrategy() {
    return new FilledShadingStrategy();
  }

  public static IShadingTypeStrategy createOutlineAndFilledStrategy() {
        return new OutlineAndFilledShadingStrategy();
  }
}
