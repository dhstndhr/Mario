import javax.imageio.ImageIO;
import javax.print.attribute.HashDocAttributeSet;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class Mushroom extends Object{
    BufferedImage mushroom;

    Mushroom(int x,int y,int width,int height, Handler handler){
        super(x,y,width,height,handler);
        try{
            mushroom = ImageIO.read(getClass().getResource("src/img/mushroom.png"));
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    public void move(){

    }


    public void tick(){

    }

    public Rectangle getBounds(){
        return null;
    }
    public void render(Graphics g){
        g.drawImage(mushroom,x,y,width,height,null);
    }



}
