import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.IOException;

// 윈도우 창
// 윈도우 창은 내부에 패널을 하나 가지고 있음
// 패널(JPanel)에는 그림을 그릴 수 있음
public class MarioFrame extends JFrame implements Runnable {
    private Canvas canvas;
    private JLabel backgroundMap;
    private Image buffImg;
    private Graphics buffg;
    public Mario mario;
    private static Camera camera;
    private Thread thread;

    private boolean running;
    private static Handler handler;
    private BufferedImage field;

    public MarioFrame() {

        initObject();
        initSetting();
        initListener();
        //this.addKeyListener(keyListener);
        setVisible(true); // 그림을 그릴 수 있게 해줌
    }

    private synchronized void start() {

        if (running)
            return;
        running = true;
        thread = new Thread(this, "thread");
        thread.start();
    }

    public void run() {
        initObject();
        long lastTime = System.nanoTime();
        long timer = System.currentTimeMillis();
        double delta = 0.0;
        double ns = 1000000000.0 / 60.0;
        int frames = 0;
        int ticks = 0;

        while (running) {
            long now = System.nanoTime();
            delta += (now - lastTime) / ns;
            lastTime = now;
            while (delta >= 1) {
                tick();
                ticks++;
                delta--;
            }
            render();
            frames++;
            if (System.currentTimeMillis() - timer > 1000) {
                timer += 1000;
                System.out.println(frames);
                frames = 0;
                ticks = 0;
            }

        }
        stop();
    }

    private synchronized void stop() {
        if (!running)
            return;
        running = false;
        try {
            thread.join();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void tick() {
        camera.tick(mario);
    }

    /*
    public void paint(Graphics g){
    if(buffg ==null){
        buffImg = createImage(1600,900);

        if(buffImg==null){
            System.out.println("실패");
        }
        else
            buffg = buffImg.getGraphics();
    }
        buffg.translate(camera.getX(),camera.getY());
        handler.render(buffg);

        update(g);
    }
    public void update(Graphics g){
        g.drawImage(buffImg,0,0,this);
    }
*/
    public void render() {
        BufferStrategy buf = getBufferStrategy();
        if (buf == null) {
            createBufferStrategy(3);
            return;
        }
        Graphics g = buf.getDrawGraphics();

        super.paintComponents(g);
        handler.render(g);
        mario.render(g);
        g.translate(camera.x, camera.y);
        g.dispose();

        buf.show();
    }

    private void initObject() {
        canvas = new Canvas();
        handler = new Handler();
        camera = new Camera();
        try {
            field = ImageIO.read(new FileInputStream("src/img/map.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        mario = new Mario(60, 305, 55, 55, handler);

        handler.createMap(field);


    }

    private void initSetting() {
        setTitle("Super Mario Game");
        setSize(1600, 900);
        setLayout(null); // absolute 레이아웃 (자유롭게 그림을 그릴 수 있게 해줌)
        setLocationRelativeTo(null); // JFrame을 화면 가운데 뜨게 함
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 창을 닫으면 JVM 같이 종료함 (프로그램 종료)
    }

/*
    KeyListener keyListener = new KeyListener() {
        @Override
        public void keyTyped(KeyEvent e) {

        }

        @Override
        public void keyPressed(KeyEvent e) {
            int key = e.getKeyCode();
            switch (key) {
                case (KeyEvent.VK_RIGHT):
                    mario.marioCurrentImage = mario.marioMoveRight;
                    mario.x += mario.SPEED;
                    mario.moveRight(); break;


                case (KeyEvent.VK_LEFT):
                    mario.marioCurrentImage = mario.marioMoveLeft;
                    mario.x -= mario.SPEED;
                    mario.moveLeft(); break;

                case (KeyEvent.VK_DOWN):
                    mario.marioCurrentImage = mario.marioMoveDown; break;


                case (KeyEvent.VK_UP):
                    mario.marioCurrentImage = mario.marioMoveJumpUp;
                    mario.moveJumpUp();
            }
        }


    @Override
    public void keyReleased(KeyEvent e) {

    }

};




    public void keyTyped(KeyEvent e){

    }
    */

    private void initListener() {
        // KeyListener() 대신 KeyAdapter()를 사용
        // KeyListener() : 인터페이스
        // KeyAdapter() : 추상 클래스 --> KeyListener의 추상 메서드(3개)를 이미 모두 구현 해놓음
        // 그러므로 KeyAdqpter()를 사용하면 사용하고자 하는 추상 메서드만 구현할 수 있음
        addKeyListener(new KeyAdapter() {
            // 키보드 클릭 이벤트 핸들러
            @Override
            public void keyPressed(KeyEvent e) {
//                System.out.println(e.getKeyCode());

                switch (e.getKeyCode()) {
                    // 키를 누르면 Mario 클래스의 moveRight() 함수를 부름 (X 좌표를 변경)
                    case KeyEvent.VK_RIGHT:
                        if (mario.isRight() == false) { // 오른쪽으로 가고 있는게 아니어야
                            mario.moveRight(); // 오른쪽으로 이동하게 함
                        }
                        break;
                    case KeyEvent.VK_LEFT:
                        if (mario.isLeft() == false) {
                            mario.moveLeft();
                        }
                        break;
                    case KeyEvent.VK_SPACE:
                        if (mario.isJumpUp() == false && mario.isJumpDown() == false) {
                            mario.moveJumpUp();
                        }
                        break;
                    case KeyEvent.VK_DOWN: // 영상에는 없음 웅크리기 때문에 넣은 거임
//                        mario.movejumpDown();
                        break;
                }
            }

            // 키보드 해제 이벤트 핸들러
            public void keyReleased(KeyEvent e) {
                switch (e.getKeyCode()) {
                    case KeyEvent.VK_RIGHT:
                        mario.setRight (false);
                        break;
                    case KeyEvent.VK_LEFT:
                        mario.setLeft(false);
                        break;
                }
            }
        });
    }

        public static void main (String[]args){
            new MarioFrame().start();
        }
    }
