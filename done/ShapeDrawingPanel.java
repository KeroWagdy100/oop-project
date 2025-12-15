// File: ShapeDrawingPanel.java
import java.awt.Graphics;
import javax.swing.JPanel;

public class ShapeDrawingPanel extends JPanel {
    
    // This array holds all the Drawable objects to be painted
    private final Drawable[] drawables; 

    public ShapeDrawingPanel(Drawable[] drawables) {
        this.drawables = drawables;
    }

    // This is the core method for all custom drawing in Swing
    @Override
    protected void paintComponent(Graphics g) {
        // clear the background
        super.paintComponent(g); 
        
        // Loop through every Drawable object and tell it to draw itself
        for (Drawable d : drawables) {
            d.draw(g); // Polymorphism: calls Circle.draw() or Cube.draw()
        }
    }
}