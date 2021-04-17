package interact;

import static java.lang.Math.abs;
import static java.lang.Math.min;

import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import model.ShapeColor;
import model.interfaces.ICommand;
import shapes.CreateShapeCommand;
import view.interfaces.PaintCanvasBase;
import model.persistence.ApplicationState;

public class MouseHandler implements MouseListener {
  private final PaintCanvasBase paintCanvas;
  private final ApplicationState appState;
  public Point pressPoint;
  public Point releasePoint;

  public MouseHandler(PaintCanvasBase paintCanvas, ApplicationState appState) {
    this.paintCanvas = paintCanvas;
    this.appState = appState;
    this.pressPoint = new Point();
    this.releasePoint = new Point();
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
  }

  @Override
  public void mouseReleased(MouseEvent e) {
    this.releasePoint.x = e.getX();
    this.releasePoint.y = e.getY();
    ICommand command = new CreateShapeCommand(pressPoint, releasePoint);
    command.run();
  }
}