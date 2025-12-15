// File: ShapeDrawingPanel.java
import java.awt.Graphics;
import java.util.List;
import javax.swing.JPanel;

public class ShapeDrawingPanel extends JPanel {
    
    // This list holds all the Drawable objects to be painted
    private final List<Drawable> drawables; 

    public ShapeDrawingPanel(List<Drawable> drawables) {
        this.drawables = drawables;
    }

    // This is the core method for all custom drawing in Swing
    @Override
    protected void paintComponent(Graphics g) {
        // 1. Always call the superclass method first to clear the background
        super.paintComponent(g); 
        
        // 2. Loop through every Drawable object and tell it to draw itself
        for (Drawable d : drawables) {
            d.draw(g); // Polymorphism: calls Circle.draw() or Cube.draw()
        }
    }
}