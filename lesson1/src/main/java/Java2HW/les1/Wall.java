package Java2HW.les1;

public class Wall implements Obstacle {
    Integer wallHeight;

    public Wall(Integer wallHeight) {
        this.wallHeight = wallHeight;
    }

    @Override
    public void overcome(Playable player) {
        player.jump(this);
    }
}
