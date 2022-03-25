package Java2HW.les1;

public class Treadmill implements Obstacle {
    Integer treadMillLength;

    public Treadmill(Integer treadMillLength) {
        this.treadMillLength = treadMillLength;
    }

    @Override
    public void overcome(Playable player) {
        player.run(this);
    }
}
