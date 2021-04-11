package interact;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MouseHandler implements MouseListener {

  @Override
  public void mouseClicked(MouseEvent e) {
    //do nothing
  }

  @Override
  public void mouseEntered(MouseEvent e) {
    //do nothing
  }

  @Override
  public void mouseExited(MouseEvent e) {
    //do nothing
  }

  @Override
  public void mousePressed(MouseEvent e) {
    Point coords = new Point();
    coords.x = e.getX();
    coords.y = e.getY();
    System.out.format("Press x: %d, y: %d\n", coords.x, coords.y);
  }

  @Override
  public void mouseReleased(MouseEvent e) {
    Point coords = new Point();
    coords.x = e.getX();
    coords.y = e.getY();
    System.out.format("Release x: %d, y: %d\n", coords.x, coords.y);
  }
}