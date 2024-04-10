import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

// Class for the drawing canvas
public class DrawingCanvas extends JPanel {

    // Variables for drawing
    private int lastX, lastY;
    private Color currentColor;
    private int brushSize;

    // Constructor to initialize the canvas
    public DrawingCanvas() {
        // Set initial values
        lastX = 0;
        lastY = 0;
        currentColor = Color.BLACK;
        brushSize = 5;

        // sets up mouse listeners for drawing
        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                lastX = e.getX();
                lastY = e.getY();
            }
        });

        addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                draw(e.getX(), e.getY());
            }
        });
    }

    // Method to draw on the canvas
    private void draw(int x, int y) {
        Graphics2D g2d = (Graphics2D) getGraphics();
        g2d.setColor(currentColor);
        g2d.setStroke(new BasicStroke(brushSize, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND));
        g2d.drawLine(lastX, lastY, x, y);
        lastX = x;
        lastY = y;
        g2d.dispose();
    }
    // Method to set the drawing color
    public void setColor(Color color) {
        currentColor = color;
    }

    // Method to set the brush size
    public void setBrushSize(int size) {
        brushSize = size;
    }
}
