import java.awt.*;

public abstract class Object {
    int x;
    int y;
    int width;
    int height;
    Handler handler;
    Object(int x, int y, int width, int height, Handler handler) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.handler = handler;
    }


    public abstract void tick();

    public abstract void render(Graphics g);
    public Rectangle getBounds(){
        return new Rectangle((int)x,(int)y,(int)width,(int)height);
    };
}
