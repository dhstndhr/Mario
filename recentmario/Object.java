import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;

public abstract class Object {

    int x;
    int y;
    int width;
    int height;
    Object(int x, int y, int width, int height,Handler handler) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;

    }
    public void setX(int x){
        this.x = x;
    }
    public int getX(){
        return x;
    }


    public abstract void render(Graphics g);
    public Rectangle getBounds(){
        return new Rectangle((int)x,(int)y,(int)width,(int)height);
    };
    public Rectangle getBoundsBottom(){
        return new Rectangle(x+x/2-x/4,(int)(y+y/2),x/2,y/2);
    }
    public Rectangle getBoundsTop(){
        return new Rectangle((int)(x+width/2 - width/4),
                y, width/2,height/2);
    }
    public Rectangle getBoundsLeft(){
        return new Rectangle(x,y+5,5,height-10);
    }
    public Rectangle getBoundsRight(){
        return new Rectangle((int) (x+width-5),
                y+5,5,height-10);

    }


    public abstract void tick();
}
