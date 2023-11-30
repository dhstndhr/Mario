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
    private FileInputStream input;
    private BufferedImage img;
    MushroomBlock(int x, int y, int width, int height, Handler handler) {
        super(x, y, width, height, handler);
        try{
            input = new FileInputStream("src/img/ItemBlock.png");
            img = ImageIO.read(input);
            input.close();

    } catch (IOException e) {
            throw new RuntimeException(e);
        } ;

    }

    public void tick() {

    }
    public void render(Graphics g) {
        g.drawImage(img,x,y,width,height,null);
        //g.drawImage(ItemBlock.getImage(),x,y,width,height,(ImageObserver) this);
    }



    public Rectangle getBounds() {
        return super.getBounds();
    }


};