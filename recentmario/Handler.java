import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.LinkedList;

public class Handler {
    LinkedList<coins> coin = new LinkedList<coins>();
    LinkedList<Object> Map = new LinkedList<Object>();

    Mario mario;
    public void render(Graphics g) {
        for (Object obj : Map) {
            obj.render(g);
        }
        for (coins c: coin){
            c.render(g);
        }

    }


    public void tick() {
        for(Object o : Map)
            o.tick();
        for (coins c : coin)
            c.tick();
    }
    public void addPipe(Object pipe){
        Map.add(pipe);
    }
    public void addMario(Object mario){
        Map.add(mario);
    }
    public void addNormalBlock(Object normal){
        Map.add(normal);
    }
    public void addMushBlock(Object mushroom) {
        Map.add(mushroom);
    }
    public void addFireBlock(Object flower) {
        Map.add(flower);
    }

    public void addFloorBlock(Object floor) {
        Map.add(floor);

    }
    public void addCoin(coins c) {
        coin.add(c);
    }

    public void addStarcoin(coins s){
        coin.add(s);
    }

    public void createMap(BufferedImage img) {
        int width = img.getWidth();
        int height = img.getHeight();
        int count =0;
        int n=2;
        for (int row = 0; row < width; row++) {
            for (int col = 0; col < height; col++) {

                int color = img.getRGB(row, col);
                int red = (color >> 16) & 0xff;
                int green = (color >> 8) & 0xff;
                int blue = (color & 0xff);

                if (red == 0 && blue == 0 && green == 0) { //
                    addFloorBlock(new FloorBlock(55 * row, 55 * col, 55, 55, this));
                }
                else if(red==100 && blue ==100 && green ==100) { //기본 블록
                    addNormalBlock(new NormalBlock(55 * row, 55* col, 55, 55, this));
                }
                else if (red == 255 && blue == 0 && green == 242) { // 버섯 블록
                   addMushBlock(new MushroomBlock(55 * row, 55* col, 55, 55, this));
                }
                else if (red == 34 && blue == 76 && green ==177) { //파이어플라워 블록
                    addFireBlock(new FlowerBlock(55 * row, 55 * col, 55, 55, this));
                }
                else if(red == 163 && blue ==164 && green ==73) { // 토관
                    addPipe(new Pipe(55 * row, 55 * col, 110, n*55, this));
                    count+=1;
                    if(count==1)
                        n+=1;
                }
                else if(red ==185 && blue == 87 && green ==122){ //스타코인 -> enum돌리기
                  addStarcoin(new StarCoin(55 * row, 55 * col, 55, 55,this, StarCoin.CoinType.PEACH));
                }
                else if(red ==137 && blue == 240 && green == 220){ //coin
                  addCoin(new Coin(55*row,55*col,55,55,this));
                }
                else {
                }

            }
        }
    }
}