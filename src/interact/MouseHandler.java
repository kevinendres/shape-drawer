package interact;

import static java.lang.Math.abs;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import model.MouseMode;
import model.ShapeColor;
import view.interfaces.PaintCanvasBase;
import model.persistence.ApplicationState;

public class MouseHandler implements MouseListener {
  private final PaintCanvasBase paintCanvas;
  private final ApplicationState appState;
  public Point pressPoint;

  public MouseHandler(PaintCanvasBase paintCanvas, ApplicationState appState) {
    this.paintCanvas = paintCanvas;
    this.appState = appState;
    this.pressPoint = new Point();
    paintCanvas.addMouseListener(this);
  }

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
    this.pressPoint.x = e.getX();
    this.pressPoint.y = e.getY();
    System.out.format("Press x: %d, y: %d\n", pressPoint.x, pressPoint.y);
  }

  @Override
  public void mouseReleased(MouseEvent e) {
    Point releasePoint = new Point(e.getX(), e.getY());
    draw(releasePoint);
  }

  private Point getOrigin(Point releasePoint) {
    int x, y;
    if (pressPoint.x < releasePoint.x) {
      x = pressPoint.x;
    }
    else {
      x = releasePoint.x;
    }
    if (pressPoint.y < releasePoint.y) {
      y = pressPoint.y;
    }
    else {
      y = releasePoint.y;
    }
    return new Point(x, y);
  }

  private void draw (Point releasePoint) {
    Point origin = getOrigin(releasePoint);
    int height = abs(releasePoint.y - pressPoint.y);
    int width = abs(releasePoint.x - pressPoint.x);

    ShapeColor color = appState.getActivePrimaryColor();

    Graphics2D g2D = paintCanvas.getGraphics2D();
    g2D.setColor(color.getColor());
    g2D.fillRect(origin.x, origin.y, width, height);
  }

}