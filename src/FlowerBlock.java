import javax.swing.*;
import java.awt.*;
import java.awt.image.ImageObserver;

public class FlowerBlock extends Object{

    FlowerBlock(int x, int y,int width, int height, Handler handler){
        super(x,y,width,height,handler);

    }

    public void tick(){

    }

    public void render(Graphics g){
    //g.drawImage();
    }

    public Rectangle getBounds(){
        return super.getBounds();
    }



}
