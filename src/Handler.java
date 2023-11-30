import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;

public class Handler {
    int width;
    int height;
    int x,y;
    LinkedList<Object> Map;
    //LinkedList<Mario>mario;
    BufferedImage field;
    Handler() {
        Map = new LinkedList<Object>();

        try {
            field = ImageIO.read(new FileInputStream("src/img/map.png"));

        }catch (IOException e){
            e.printStackTrace();
        }
        width = 200;
        height = field.getHeight();
        x = 0;
        y = 0;
    }

    public void addObject(Object obj) {
        Map.add(obj);
    }


    public void removeObject(Object obj) {
        Map.remove(obj);
    }


    public void render(Graphics g) {
        for (Object obj : Map) {
            obj.render(g);
        }
    }

    public void tick(){
        for(Object obj : Map)
            obj.tick();
    }
    /*
    public void addMushBlock(MushroomBlock mushroom){
        Map.add(mushroom);
    }
    public void addFireBlock(FlowerBlock flower){
        Map.add(flower);
    }
    public void addfloorBlock(floorBlock Block){
        Map.add(Block);
    }
    /*
    public void addCoin(Coin coin){
        addObject(coin);
    }
    public void addStarcoin(Starcoin scoin){
        addObject(scoin);
    }

    public void addMonster(Monster monster){
        addObject(Monster);
     */
    public void createMap(BufferedImage img) {
        for (int row = 0; row < width; row++) {
            for (int col = 0; col < height; col++) {
                int color = img.getRGB(row, col);

                int red = (color >> 16) & 0xff;
                int green = (color >> 8) & 0xff;
                int blue = (color & 0xff);

                if (red == 0 && blue == 0 & green == 0)
                    addObject(new floorBlock(44*row,44*col,44,44,this));

            }
        }
    }
}