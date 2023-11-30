import javax.swing.*;
import java.awt.*;
import java.awt.image.ImageObserver;

public class FireFlower extends Object{
    ImageIcon flower;
    FireFlower(int x, int y, int width, int height,Handler handler){
        super(x,y,width,height,handler);
        flower = new ImageIcon(getClass().getResource("src/img/flower.png"));
    }
    public void render(Graphics g){
        g.drawImage(flower.getImage(),x,y,width,height,null);

    }
    public void move(){
        //
    }
    public void remove(){

    }
    public void tick(){

    }
    public Rectangle getBounds(){

        return null;
    }
    public void appear(){

    }
}
