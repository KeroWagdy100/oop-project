import java.awt.Graphics;

public interface Drawable {
    String howToDraw();
    void draw(Graphics g, int x, int y);
}
