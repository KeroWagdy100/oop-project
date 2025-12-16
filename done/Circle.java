import java.awt.*;

public class Circle extends Shape
{
    private double radius;

    public Circle(double r)
    {
        radius = r;
    }
    public Circle(String c, double r)
    {
        super(c);
        radius = r;
    }


    public double getRadius()
    {
        return radius;
    }

    public void setRadius(double r)
    {
        radius = r;
    }

    @Override
    public String toString()
    {
        return "Circle";
    }

    @Override
    public double getArea()
    {
        return Math.PI * radius * radius;
    }

    @Override
    public double getPerimeter()
    {
        return 2 * Math.PI * radius;
    }

    @Override
    public String howToDraw()
    {
        return "";
    }

    @Override
    public void draw(Graphics g, int x, int y)
    {
        Color c = Color.decode(getColor());
        g.setColor(c);
        
        int diameter = 2 * (int)getRadius();

        // g.fillOval(x, y, diameter, diameter); // fill shape
        g.drawOval(x, y, diameter, diameter); // outline
    }
}