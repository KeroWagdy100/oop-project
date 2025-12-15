import java.util.Date;

public abstract class Shape implements Drawable {
    private final Date dateCreated;
    private String color;

    public Shape()
    {
        dateCreated = new Date();
        this.color = "#0000FF"; // default color: blue
    }
    public Shape(String color)
    {
        dateCreated = new Date();
        this.color = color;
    }
    

    public Date getDateCreated()
    {
        return dateCreated;
    }
    public String getColor()
    {
        return color;
    }
    abstract public double getArea();
    abstract public double getPerimeter();

}