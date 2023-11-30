import jdk.nashorn.internal.objects.annotations.Getter;
import jdk.nashorn.internal.objects.annotations.Setter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Mario extends Object{

        // 마리오의 위치 상태
        public int x; //50
        public int y; //700
        public int width =44;//44
        public int height =44; //44
        public Handler handler;
        public ImageIcon marioCurrentImage;


        // 마리오의 움직임 상태
        public boolean right;
        public boolean left;
        public boolean jumpUp;
        public boolean jumpDown;

        @Getter
        public boolean isRight() {
            return right;
        }

        @Setter
        public void setRight(boolean right) {
            this.right = right;
        }

        @Getter
        public boolean isLeft() {
            return left;
        }

        @Setter
        public void setLeft(boolean left) {
            this.left = left;
        }

        @Getter
        public boolean isJumpUp() {
            return jumpUp;
        }
        @Getter
        public boolean isJumpDown() {
            return jumpDown;
        }

        // 속도 상태
        public final int SPEED = 5;
        public final int JUMPSPEED = 5;

        // 마리오의 크기
        public static final int MARIO_WIDTH = 70;
        public static final int MARIO_HEIGHT = 70;

        // 마리오 이미지
        public ImageIcon marioMoveRight, marioMoveLeft, marioMoveJumpUp,marioMoveDown;

        public Mario(int x, int y, int width, int height, Handler handler) {
            super(x, y, width, height, handler);
            this.x = x;
            this.y = y;
            this.width = width;
            this.height = height;
            this.handler = handler;
            initObject();
            initSetting();
        }

    @Override
    public void render(Graphics g) {
        g.drawImage(marioCurrentImage.getImage(),x,y,width,height,null);
    }

    private void initObject() {
            marioMoveRight = new ImageIcon("./src/img/Mario_Right.png");
            marioMoveLeft = new ImageIcon("./src/img/Mario_Left.png");
            marioMoveJumpUp = new ImageIcon("./src/img/Mario_jumpR.png");
            marioMoveDown = new ImageIcon("./src/img/MoveDown.png");

        }

        private void initSetting() {
            this.x = 50;
            this.y = 660;

            // 초기 상태에서는 움직이지 않으므로 false
            // 움직인다는건 : 마리오의 좌표가 이동된다는 것 --> 이동 함수에서 좌표 이동
            /*right = false;
            left = false;
            jumpUp = false;
            jumpDown = false;*/

            // 이미지 크기 조정
            marioMoveRight = new ImageIcon(marioMoveRight.getImage().getScaledInstance(MARIO_WIDTH, MARIO_HEIGHT, java.awt.Image.SCALE_SMOOTH));
            marioMoveLeft = new ImageIcon(marioMoveLeft.getImage().getScaledInstance(MARIO_WIDTH, MARIO_HEIGHT, java.awt.Image.SCALE_SMOOTH));
            marioMoveJumpUp = new ImageIcon(marioMoveJumpUp.getImage().getScaledInstance(MARIO_WIDTH, MARIO_HEIGHT, java.awt.Image.SCALE_SMOOTH));

            marioCurrentImage = new ImageIcon("./src/img/Mario_Right.png");


        }

        // 언제 이동하는가 : 키보드를 눌렀을 때 이동 --> 마리오의 좌표 이동(변경)
        // 키보드 이벤트는 MarioFrame에서 작업
        // 아래 함수들이 모두 == 이벤트 핸들러
        public void moveRight() {
            System.out.println("right");
            marioCurrentImage = marioMoveRight;
            x += SPEED;
            //right = true;
            //marioCurrentImage = marioMoveRight;
            // right를 누르고 있을 때만 실행되도록 & 1번만 실행되도록
//                setIcon(marioMoveRight);
                    //x += SPEED;
        }

        public void moveLeft() {
            System.out.println("left");
            marioCurrentImage = marioMoveLeft;
            x -= SPEED;
            //left = true;
            //this.x -= SPEED;
        }

        // 오른쪽 + 점프, 왼쪽 + 점프
        // 이동하면서 점프를 동시에 하려면 무조건 쓰레드 만들어야 함

        public void moveJumpUp() {
            System.out.println("jump");
            jumpUp = true;
                for(int i = 0; i < 150/JUMPSPEED; i++) {     // 지구 끝까지 계속 점프할 수 없기 때문에 while이 아니라 for문을 써야함
                    marioCurrentImage = marioMoveJumpUp;
                    this.y -= JUMPSPEED;
                }

                jumpUp = false;
                moveJumpDown();
        }

        public void moveJumpDown() {
            System.out.println("down");
            this.jumpDown = true;
            for(int i = 0; i < 150/JUMPSPEED; i++) {
                this.marioCurrentImage = marioMoveJumpUp;
                this.y += JUMPSPEED;
            }
            this.jumpDown = false;
        }

    public void tick() {
        /*int key = .getKeyCode();
        switch(key){
            case(KeyEvent.VK_RIGHT):
                this.marioCurrentImage = marioMoveRight;
                this.x += SPEED;
                this.moveRight();


            case(KeyEvent.VK_LEFT):
                this.marioCurrentImage = marioMoveLeft;
                this.x -= SPEED;
                this.moveLeft();

            case(KeyEvent.VK_DOWN):
                this.marioCurrentImage = marioMoveDown;


            case(KeyEvent.VK_UP):
                this.marioCurrentImage = marioMoveJumpUp;
                this.moveJumpUp();
        }

         */
    }

}
    /*int marioLife =1;

    int marioX, marioY;
    int MARIO_HEIGHT;
    int MARIO_WIDTH;

    private Handler handler;

    Mario(int x, int y, int width, int height, Handler handler) {
        super(x,y,width,height,handler);
        this.marioX = x;
        this.marioY = y;
        this.MARIO_WIDTH = width;
        this.MARIO_HEIGHT = height;
        this.handler = handler;

    }
    public int getX(){
        return marioX;
    }
    public int width(){
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





    public void tick(){ //아마 여기에서는 gameloop함수에서 tick을 사용해야함
        if(marioX<=0) marioX=0;
        if(marioY<=0) marioY=0;
        for(Object obj : handler.Map){
            // 캐릭터와 블록의 충돌 감지 및 처리
            if(obj.getBoundsLeft().intersects(obj.getBounds()))
            {
                //setY
                //왼쪽 위치 셋팅;
            }
            else if (obj.getBoundsRight().intersects((obj.getBounds()))) {
                //오른쪽 위치 셋팅;
            } else if (obj.getBoundsTop().intersects((obj.getBounds()))) {
                //오른쪽 위치 셋팅;
            } else if (obj.getBoundsBottom().intersects(obj.getBounds())) {
                //아래 위치 셋팅;
            }
            else {};
        }*/


