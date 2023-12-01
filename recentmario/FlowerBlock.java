import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;

public class FlowerBlock extends Object{
    BufferedImage flowerBlock;
    FlowerBlock(int x, int y,int width, int height, Handler handler){
        super(x,y,width,height,handler);
        try{
            flowerBlock = ImageIO.read(getClass().getResource("/img/ItemBlock.png"));
        }catch(Exception e){
            e.printStackTrace();
        }

    }

    public void tick(){
    super.setX(Camera.x);
    }
    @Override
    public void render(Graphics g){
        g.drawImage(flowerBlock,x+Camera.x,y,width,height,null);

    }

    @Override
    public Rectangle getBounds(){
        return super.getBounds();
    }



}
