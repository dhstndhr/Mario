import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;

public class Pipe extends Object{
    BufferedImage pipe;
    Pipe(int x, int y,int width, int height, Handler handler){
        super(x,y,width,height,handler);
        try{
            pipe = ImageIO.read(getClass().getResource("/img/Pipe.png"));
        }catch(Exception e){
            e.printStackTrace();
        }

    }
    @Override
    public void tick(){}
    @Override
    public void render(Graphics g){
        g.drawImage(pipe,x+Camera.x,y,width,height,null);

    }

    @Override
    public Rectangle getBounds(){
        return super.getBounds();
    }



}

