import java.awt.*;

public class Cube extends ThreeDShape
{
    private double side;

    public Cube(double s)
    {
        side = s;
    }
    public Cube(String color, double s)
    {
        super(color);
        this.side = s;
    }

    public double getSide()
    {
        return side;
    }

    public void setSide(double s)
    {
        side = s;
    }

    @Override
    public double getVolume()
    {
        return side * side * side;
    }

    @Override
    public double getArea()
    {
        return side * side;
    }

    @Override
    public double getPerimeter()
    {
        return 12.0 * side;
    }

    @Override
    public String howToDraw()
    {
        return "just draw a cube";
    }

    @Override
    public void draw(Graphics g)
    {
        // --- 1. Setup ---
        
        String colorString = this.getColor(); 

        g.setColor(Color.decode(colorString));

        int side = (int)getSide();
        int startX = 200; 
        int startY = 200; 
        
        int offset = (int)side / 3; 
        
        // Front Face (F) coordinates: (x, y)
        int FX = startX;
        int FY = startY;
        
        // Back Face (B) coordinates: Shifted up and to the left/right by the offset
        int BX = startX + offset; 
        int BY = startY - offset; 
        
        // --- 3. Drawing the Cube (Wireframe Effect) ---
        
        // A. Draw the Back Face (first, so the front face covers it)
        g.drawRect(BX, BY, side, side); 

        // B. Draw the Front Face
        g.drawRect(FX, FY, side, side);

        // C. Connect the Corresponding Corners (Creating the 3D lines)
        
        // Top-Left corner: (BX, BY) to (FX, FY)
        g.drawLine(BX, BY, FX, FY); 
        
        // Top-Right corner: (BX + side, BY) to (FX + side, FY)
        g.drawLine(BX + side, BY, FX + side, FY); 
        
        // Bottom-Left corner: (BX, BY + side) to (FX, FY + side)
        g.drawLine(BX, BY + side, FX, FY + side); 
        
        // Bottom-Right corner: (BX + side, BY + side) to (FX + side, FY + side)
        g.drawLine(BX + side, BY + side, FX + side, FY + side);
    }
}