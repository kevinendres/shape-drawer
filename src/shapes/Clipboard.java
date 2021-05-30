package shapes;

import java.util.ArrayList;
import java.util.List;
import shapes.interfaces.ICopyable;
import shapes.interfaces.IShape;

public class Clipboard {
  public static final List<ICopyable> clipboard = new ArrayList<>();

  public static void add(ICopyable shape) {
    clipboard.add(shape);
  }

  public static void clear() { clipboard.clear();
  }

}
