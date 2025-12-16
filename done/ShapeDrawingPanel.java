import java.awt.Graphics;
import javax.swing.JPanel;

public class ShapeDrawingPanel extends JPanel {
    
    private final Drawable[] drawables; 

    public ShapeDrawingPanel(Drawable[] drawables) {
        this.drawables = drawables;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g); 
        
        int x = 50, y = 50;
        for (Drawable d : drawables) {
            d.draw(g, x, y); // Polymorphism: calls Circle.draw() or Cube.draw()
            if (d instanceof Circle)
                x += ((Circle)d).getRadius() * 2;
            else if (d instanceof Cube)
                x += ((Cube)d).getSide() + ((Cube)d).getDepth();
        }
    }
}