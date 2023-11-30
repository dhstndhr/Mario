import javax.print.attribute.HashDocAttributeSet;
import javax.swing.*;
import java.awt.*;

public class Mushroom extends Object{
    ImageIcon mushroom;

    Mushroom(int x,int y,int width,int height, Handler handler){
        super(x,y,width,height,handler);
        mushroom = new ImageIcon(getClass().getResource("src/img/mushroom.png"));
    }
    public void move(){

    }
    public void remove(){
        handler.removeObject(this);
    }
    @Override
    public void tick(){

    }

    public Rectangle getBounds(){
        return null;
    }
    public void render(Graphics g){
        g.drawImage(mushroom.getImage(),(int)x,(int)y,(int)width,(int)height,null);
    }



}
