import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Objects;

public class MushroomBlock extends Object {

    private BufferedImage img;
    MushroomBlock(int x, int y, int width, int height, Handler handler) {
        super(x, y, width, height, handler);
        try{
            img = ImageIO.read(getClass().getResource("/img/ItemBlock.png"));
    } catch (IOException e) {
            throw new RuntimeException(e);
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