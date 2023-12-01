import lombok.Getter;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class Coin extends coins{
    BufferedImage coinImage;

    public Coin(int x, int y, int width, int height, Handler handler) {
        super(x,y,width,height,handler);
        collected = false;
        try{
            coinImage = ImageIO.read(getClass().getResource("/img/Coin.png")); // 각 코인 이미지에 대한 배열 크기
        }catch (Exception e){
            e.printStackTrace();
        }
        coinValue = 100;
    }
    @Override
    public void tick(){

    };
    public void setCollected(boolean collected) {
        this.collected = collected;
    }
    @Override
    public void render(Graphics g) {
        g.drawImage(coinImage,x+Camera.x,y,width,height,null);
    }
}