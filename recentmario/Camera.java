import lombok.Getter;

public class Camera {
    @Getter
    public static int x;
    final int y = 450;
    public void tick(Mario mario){
        this.x = -mario.x;
    }


}
