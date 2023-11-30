import javax.swing.*;
import java.awt.*;
import java.io.FileInputStream;

public class floorBlock extends Object {
    private FileInputStream input;
    private ImageIcon img;
    floorBlock(int x, int y, int width, int height, Handler handler) {
        super(x, y, width, height, handler);

            img = new ImageIcon("C:\\Users\\user\\IdeaProjects\\test\\src\\img\\block.png");

    }

    public void tick() {

    }
    public void render(Graphics g) {
        g.drawImage(img.getImage(),x,y,width,height,null);
        //g.drawImage(ItemBlock.getImage(),x,y,width,height,(ImageObserver) this);
    }



    public Rectangle getBounds() {
        return super.getBounds();
    }


};