import javax.swing.*;
import java.awt.*;


//Main class
public class DrawingApp extends JFrame {
    //Variables for UI components
    private DrawingCanvas canvas;
    private JButton colorButton;
    private JSlider brushSizeSlider;

    //Constructor to initialize the application
    public DrawingApp() {

        //Sets the title of the window
        super("Simple Paint App");
        //Sets the size of the window
        setSize(800,600);
        //sets the default close operation
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //The panel to hold the canvas and other UI components
        //Initialize UI components
        canvas = new DrawingCanvas();
        colorButton = new JButton("Select Color");
        brushSizeSlider = new JSlider(1, 20, 5);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());

        //The drawing canvas
        DrawingCanvas canvas = new DrawingCanvas();
        mainPanel.add(canvas, BorderLayout.CENTER);

        //adds color button and brush size slider to the south of the main panel
        JPanel controlsPanel = new JPanel();
        controlsPanel.add(colorButton);
        controlsPanel.add(new JLabel("Brush Size"));
        controlsPanel.add(brushSizeSlider);
        mainPanel.add(controlsPanel, BorderLayout.SOUTH);

        //adds the main panel to the JFrame
        add(mainPanel);
        //Sets up the color button action listener
        colorButton.addActionListener(e -> {
            Color selectedColor = JColorChooser.showDialog(this, "Choose Color", Color.BLACK);
            if (selectedColor != null) {
                canvas.setColor(selectedColor);
            }
        });
        // Sets up brush size slider change listener
        brushSizeSlider.addChangeListener(e -> {
            int brushSize = brushSizeSlider.getValue();
            canvas.setBrushSize(brushSize);
        });

        //Makes the window visible
        setVisible(true);

    }

    //Main method to start the application
    public static void main(String[] args) {
        //creates the instance of the drawing app
        SwingUtilities.invokeLater(() -> new DrawingApp());

    }

}
