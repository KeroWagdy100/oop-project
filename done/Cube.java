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

    public int getDepth()
    {
        return (int)side / 3; 
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
    public void draw(Graphics g, int x, int y)
    {
        
        String colorString = this.getColor(); 

        g.setColor(Color.decode(colorString));

        int side = (int)getSide();
        int startX = x; 
        int startY = y; 
        
        
        // Front Face (F) coordinates: (x, y)
        int FX = startX;
        int FY = startY;
        
        // Back Face (B) coordinates: Shifted up and to the left/right by the depth
        int BX = startX + getDepth(); 
        int BY = startY - getDepth(); 
        
        
        // A. Draw the Back Face (first, so the front face covers it)
        g.drawRect(BX, BY, side, side); 

        // B. Draw the Front Face
        g.drawRect(FX, FY, side, side);

        // C. Connect the Corresponding Corners (Creating the 3D lines)
        
        // Top-Left corner:
        g.drawLine(BX, BY, FX, FY); 
        
        // Top-Right corner:
        g.drawLine(BX + side, BY, FX + side, FY); 
        
        // Bottom-Left corner:
        g.drawLine(BX, BY + side, FX, FY + side); 
        
        // Bottom-Right corner:
        g.drawLine(BX + side, BY + side, FX + side, FY + side);
    }
}