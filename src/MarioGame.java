import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;

import java.io.FileInputStream;
import java.io.IOException;

public class MarioGame extends Canvas implements Runnable {


    public static final int WIDTH = 300;
    public static final int HEIGHT = WIDTH / 16 * 9;
    public static final int SCALE = 4;
    public static final String TITLE = "MarioGame";
    public BufferedImage field;
    private Thread thread;
    private boolean running = false;
    private Handler handler;

    private synchronized void start(){

        if(running)
            return;
        running =true;
        thread = new Thread(this, "thread");
        thread.start();

    }

    private synchronized void stop(){
        if(!running)
            return;
        running = false;
        try{
            thread.join();
        } catch(Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        init();
        long lastTime = System.nanoTime();
        long timer = System.currentTimeMillis();
        double delta = 0.0;
        double ns = 1000000000.0/60.0;
        int frames =0;
        int ticks = 0;

        while(running){
            long now = System.nanoTime();
            delta+=(now-lastTime)/ns;
            lastTime = now;
            while(delta>=1){
                tick();
                ticks++;
                delta--;
            }
            render();
            frames++;
            if(System.currentTimeMillis()-timer>1000){
                timer+=1000;
                System.out.println(frames);
                frames = 0;
                ticks = 0;
            }

        }
        stop();
    }
    public void render(){
        BufferStrategy buf = getBufferStrategy();
        if(buf == null){
            createBufferStrategy(3);
            return;
        }
        Graphics g = buf.getDrawGraphics();
        handler.render(g);
        g.dispose();
        buf.show();
    }
    public void tick(){

    }
    public void init(){
    handler = new Handler();

    try {
        field = ImageIO.read(new FileInputStream("src/img/map.png"));

    }catch (IOException e){
        e.printStackTrace();
    }
    handler.createMap(field);



    }
    public MarioGame(){
        Dimension size = new Dimension(WIDTH * SCALE, HEIGHT * SCALE);
        setPreferredSize(size);
        setMaximumSize(size);
        setMinimumSize(size);
        ;
    }

    public static void main(String[] args) {

        MarioGame game = new MarioGame();
        JFrame frame = new JFrame(TITLE);
        frame.add(game);
        frame.pack();
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        game.start();
    }
    public int get_FrameWidth(){
        return WIDTH;
    }
    public int get_FrameHEIGHT(){
        return HEIGHT;
    }


}