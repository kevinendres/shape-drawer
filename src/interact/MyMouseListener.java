package interact;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MyMouseListener extends MouseAdapter {
  @Override
  public void mousePressed(MouseEvent e) {
    System.out.println("Mouse pressed");
  }

  @Override
  public void mouseReleased(MouseEvent e) {
    System.out.println("Mouse released");
  }
}
