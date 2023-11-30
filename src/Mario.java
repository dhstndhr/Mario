import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.ImageObserver;
import java.security.Key;

public class Mario extends JFrame implements KeyListener{
    int marioLife =1;

    int velX, velY;
    int marioX, marioY;
    int MARIO_HEIGHT;
    int MARIO_WIDTH;
    private final ImageIcon[] marioImages;
    int FRAME_WIDTH = 800;
    int FRAME_HEIGHT = 600;
    int currentImageIndex = 0;

    boolean isJumping = false;
    int jumpHeight = 50;
    int gravity = 5;
    boolean moveLeft = false;
    boolean moveRight= false;
    boolean canJump = true;
    int jumpCount =0;

    private final Handler handler;

    Mario(int x, int y, int width, int height, Handler handler) {
        this.marioX = x;
        this.marioY = y;
        this.MARIO_WIDTH = width;
        this.MARIO_HEIGHT = height;
        this.handler = handler;

        if(marioLife == 1){
            currentImageIndex=1;
            MARIO_WIDTH=44;
            MARIO_HEIGHT=44;
        }
        else if(marioLife==2){
            currentImageIndex=5;
            MARIO_HEIGHT=88;
            MARIO_WIDTH=88;
        }
        else if (marioLife==3){
            currentImageIndex=11;
            MARIO_HEIGHT=88;
            MARIO_WIDTH=88;
        }
        //사망_0 기본_1 버섯_2 꽃_3
    marioImages = new ImageIcon[16]; // 배열 크기는 방향에 따른 이미지 수에 따라 조정
    // Load Mario images for each direction (replace these with your image paths)
        marioImages[0] = new ImageIcon("C:\\Users\\user\\IdeaProjects\\test\\src\\img\\Mario_Left.png");
        marioImages[1] = new ImageIcon("C:\\Users\\user\\IdeaProjects\\test\\src\\img\\Mario_Right.png");
        marioImages[2] = new ImageIcon("C:\\Users\\user\\IdeaProjects\\test\\src\\img\\Mario_jumpL.png");
        marioImages[3] = new ImageIcon("C:\\Users\\user\\IdeaProjects\\test\\src\\img\\Mario_jumpR.png");
        //Mush
        marioImages[4] = new ImageIcon("C:\\Users\\user\\IdeaProjects\\test\\src\\img\\MushMario_left.png");
        marioImages[5] = new ImageIcon("C:\\Users\\user\\IdeaProjects\\test\\src\\img\\MushMario_Right.png");
        marioImages[6] = new ImageIcon("C:\\Users\\user\\IdeaProjects\\test\\src\\img\\MushMairo_jumpL.png");
        marioImages[7] = new ImageIcon("C:\\Users\\user\\IdeaProjects\\test\\src\\img\\MushMairo_jumpR.png");
        marioImages[8] = new ImageIcon("C:\\Users\\user\\IdeaProjects\\test\\src\\img\\MushMario_downL.png");
        marioImages[9] = new ImageIcon("C:\\Users\\user\\IdeaProjects\\test\\src\\img\\MushMario_downR.png");
        //Fire
        marioImages[10] = new ImageIcon("C:\\Users\\user\\IdeaProjects\\test\\src\\img\\FireMario_Left.png");
        marioImages[11] = new ImageIcon("C:\\Users\\user\\IdeaProjects\\test\\src\\img\\FireMario_Right.png");
        marioImages[12] = new ImageIcon("C:\\Users\\user\\IdeaProjects\\test\\src\\img\\FireMario_jumpL.png");
        marioImages[13] = new ImageIcon("C:\\Users\\user\\IdeaProjects\\test\\src\\img\\FireMario_jumpR.png");
        marioImages[14] = new ImageIcon("C:\\Users\\user\\IdeaProjects\\test\\src\\img\\FireMario_downL.png");
        marioImages[15] = new ImageIcon("C:\\Users\\user\\IdeaProjects\\test\\src\\img\\FireMario_downR.png");
        addKeyListener(this);
        setFocusable(true);
        //JPanel panel = new JPanel();
        //panel.add(this);
        // Start the game loop
        Timer timer = new Timer(10, e -> gameLoop());
        timer.start();
    }
    public int getX(){
        return marioX;
    }
    public int getWidth(){
        return MARIO_WIDTH;
    }
    public int getHeight(){
        return MARIO_HEIGHT;
    }

    public int getY(){
        return marioY;
    }
    public void setX(int x){
        this.marioX =x;
    }
    public void setY(int y){
        this.marioY =y;
    }
    public void setVelX(int x){
        this.velX = x;
    }
    public void setVelY(int y){
        this.velY = y;
    }
    public void HitBlock(){
    //충돌처리
        // 함수인데/...
    }
    class Mypanel extends JPanel{
        public void paint(Graphics g){
            super.paint(g);
            g.drawImage(marioImages[currentImageIndex].getImage(),marioX,marioY,MARIO_WIDTH,MARIO_HEIGHT,null);
        }
    }




    public void gameLoop() {

        // Update the game logic (e.g., handle jumping, gravity, collision detection, etc.)
        if (isJumping) {
            marioY -= gravity;
            jumpHeight -= gravity;
            if (jumpHeight <= 0) {
                isJumping = false;
            }
        } else if (marioY < 500) {
            marioY += gravity;
        }
        move();
        repaint();
    }



    public void tick(){
        marioX+=velX;
        marioY+=velY;
        if(marioX<=0) marioX=0;
        if(marioY<=0) marioY=0;

        /*for(Object obj : handler.Map){
            // 캐릭터와 블록의 충돌 감지 및 처리
            if(getBoundsLeft().intersects(obj.getBounds()))
            {
                //왼쪽 위치 셋팅;
            }
            else if (getBoundsRight().intersects((obj.getBounds()))) {
                //오른쪽 위치 셋팅;
            } else if (getBoundsTop().intersects((obj.getBounds()))) {
                //오른쪽 위치 셋팅;
            } else if (getBoundsBottom().intersects(obj.getBounds())) {
                //아래 위치 셋팅;
            }
            else {};*/
        }

    private void move() {
        if (moveLeft && marioX > 0) {
            marioX -= 3;

        }
        if (moveRight && marioX < FRAME_WIDTH-MARIO_WIDTH-50) {
            marioX += 3;

        }

    }

    //1 0-3 2 4-9 3 10-15
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        if (key == KeyEvent.VK_LEFT) {
            if(marioLife == 1) {
                if (isJumping) {
                    currentImageIndex = 2;
                }
                else {
                    currentImageIndex = 0;
                }
            }
            else if(marioLife==2){
                if (isJumping) {
                    currentImageIndex = 6;
                }
                else {
                    currentImageIndex = 4;
                }
            }
            else if(marioLife==3){
                if (isJumping) {
                    currentImageIndex = 12;
                }
                else {
                    currentImageIndex = 10;
                }
            }
            moveLeft = true;
        }
        //R
        else if (key == KeyEvent.VK_RIGHT) {
            if (marioLife==1) {
                if (isJumping) {
                    currentImageIndex = 3;
                }
                else {
                    currentImageIndex = 1;
                }
            }
            else if (marioLife==2) {
                if (isJumping) {
                    currentImageIndex = 7;
                }
                else {
                    currentImageIndex = 5;
                }
            }
            else if (marioLife==3) {
                if (isJumping) {
                    currentImageIndex = 13;
                }
                else {
                    currentImageIndex = 11;
                }
            }
            moveRight = true;
        }
        //J
        else if (key == KeyEvent.VK_SPACE && !isJumping) {
            if(marioLife==1){
                if(moveRight) {
                    currentImageIndex =3;
                }
                else if(moveLeft){
                    currentImageIndex = 2;
                }
            }
            else if(marioLife==2){
                if(moveRight) {
                    currentImageIndex =7;
                }
                else if(moveLeft){
                    currentImageIndex = 6;
                }
            }
            else if (marioLife == 3) {
                if(moveRight) {
                    currentImageIndex =13;
                }
                else if(moveLeft){
                    currentImageIndex = 12;
                }
            }
            isJumping = true;
            jumpCount = jumpHeight;
            canJump = false;
        }
        //D
        else if (key == KeyEvent.VK_DOWN){
            if(marioLife==2){
                currentImageIndex=8;
                MARIO_WIDTH=44;
                MARIO_HEIGHT=44;
            }
            if(marioLife==3){
                currentImageIndex=14;
                MARIO_WIDTH=44;
                MARIO_HEIGHT=44;
            }
        }

    }

    public void keyTyped(KeyEvent e) {}

    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();
        if (key == KeyEvent.VK_LEFT) {
            moveLeft = false;
        } else if (key == KeyEvent.VK_RIGHT) {
            moveRight = false;
        }
        else if(key == KeyEvent.VK_DOWN){
            if(marioLife==2){
                currentImageIndex=4;
                MARIO_HEIGHT=88;
                MARIO_WIDTH=88;
            }
            if(marioLife==3){
                currentImageIndex=10;
                MARIO_HEIGHT=88;
                MARIO_WIDTH=88;
            }
        }
    }

    /*private void showBounds(Graphics g){
    Graphics2D g2d = (Graphics2D)g;

    g.setColor(Color.red);
    g2d.draw(getBounds());
    g2d.draw(getBoundsRight());
    g2d.draw(getBoundsLeft());
    g2d.draw(getBoundsTop());
    */
    /*
    public Rectangle getBounds(){
        return new Rectangle((int)getX()+getX()/2-getX()/4,(int)(getY()+getY()/2),(int)getX()/2,(int)getY()/2);
    }
    public Rectangle getBoundsBottom(){
        return null; //new Rectangle((int)getX()+getX()/2-getX()/4,(int)(getY()+getY()/2),(int)getX()/2,(int)getY()/2);
    }
    public Rectangle getBoundsTop(){
        return new Rectangle((int)(getX()+getWidth()/2 - getWidth()/4),
                (int)getY(), (int)getWidth()/2,(int)getHeight()/2);
    }
    public Rectangle getBoundsLeft(){
        return new Rectangle((int)getX(),
                (int)getY()+5,5,(int)getHeight()-10);
    }
    public Rectangle getBoundsRight(){
        return new Rectangle((int) (getX()+getWidth()-5),
                (int)getY()+5,5,(int)getHeight()-10);

    }
    */


}
