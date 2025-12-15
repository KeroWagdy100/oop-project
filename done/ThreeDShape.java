public abstract class ThreeDShape extends Shape
{
    abstract  double getVolume();
    public ThreeDShape()
    {
        super();
    }
    public ThreeDShape(String color)
    {
        super(color);
    }
}