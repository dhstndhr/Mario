public class Camera {
    public int x;
    final int y = 450;
    public void tick(Mario mario){
        this.x = -mario.x + 800;
    }
}
