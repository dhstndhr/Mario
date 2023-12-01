import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class NormalBlock extends Object {

    BufferedImage img;
    NormalBlock(int x, int y, int width, int height, Handler handler) {
        super(x, y, width, height, handler);
        try{
          img = ImageIO.read(getClass().getResource("/img/Normal.png"));
        } catch (IOException e) {
            e.printStackTrace();
        } ;

    }

    public void tick() {

    }
    public void render(Graphics g) {
        g.drawImage(img,x+Camera.x,y,width,height,null);
    }



    public Rectangle getBounds() {
        return super.getBounds();
    }


};