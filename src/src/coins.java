import lombok.Getter;

import javax.swing.*;
import java.awt.*;

public abstract class coins {
    @Getter
    int x;
    @Getter
    int y;
    @Getter
    int width;
    @Getter
    int height;
    @Getter
    public boolean collected;
    @Getter
    int coinValue;
    Handler handler;

    public coins(int x, int y, int width, int height, Handler handler) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.handler = handler;
        collected = false;// 각 코인 이미지에 대한 배열 크기
        coinValue = 100;
    }
    public abstract void render(Graphics g);
    public abstract void tick();
}
