import javax.swing.*;
import java.awt.*;

public class StarCoin extends coins {
    public enum CoinType {
        PEACH, YOSHI, Kpio, Kpiko
    }
    private CoinType type;
    public ImageIcon[] StarCoinImages;
    private int currentImageIndex;
    Handler handler;
    public StarCoin(int x, int y, int width, int height, Handler handler, CoinType type) {
        super(x,y,width,height,handler);
        coinValue = 500;
        collected = false;
        StarCoinImages = new ImageIcon[4];
        this.type = type;
        if (type == CoinType.PEACH) {
            ImageIcon peachImage = new ImageIcon("src/img/peach.png");
            this.StarCoinImages[0] = peachImage;
        } else if (type == CoinType.YOSHI) {
            ImageIcon yoshiImage = new ImageIcon("src/img/Yoshi.png");
            this.StarCoinImages[0] = yoshiImage;
            }
    }

    public void tick(){

    }
    @Override
    public void render(Graphics g) {
        if (!collected) {
            g.drawImage(StarCoinImages[currentImageIndex].getImage(), x, y, width, height, null);
        }
    }
}

