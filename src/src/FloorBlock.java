import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;

public class FloorBlock extends Object {
    private ImageIcon imgIcon;
    FloorBlock(int x, int y, int width, int height, Handler handler) {
        super(x, y, width, height,handler);
        imgIcon = new ImageIcon("./src/img/block.png");
    }

    public void tick() {

    }

    public void render(Graphics g){
        g.drawImage(imgIcon.getImage(),x,y,width,height,null);
    };

    public Rectangle getBounds() {
        return super.getBounds();
    }


};