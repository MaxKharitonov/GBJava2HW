package Java2HW.les1;

public class Robot implements Playable {
    private final Integer jumpLimit;
    private final Integer runLimit;
    boolean passed;

    public Robot(Integer jumpLimit, Integer runLimit) {
        this.jumpLimit = jumpLimit;
        this.runLimit = runLimit;
    }

    @Override
    public void run(Treadmill length) {
        System.out.println("Робот побежал.");
        if (runLimit < length.treadMillLength) {
            System.out.println("Робот не смог пробежать расстояние: " + length.treadMillLength + ".");
            passed = false;
        } else {
            System.out.println("Робот успешно пробежал расстояние: " + length.treadMillLength + ".");
            passed = true;
        } // Тут должен быть вызов метода передающий участников, прошедших препятствие в массив
    }

    @Override
    public void jump(Wall height) {
        System.out.println("Робот прыгнул.");
        if (jumpLimit < height.wallHeight) {
            System.out.println("Робот не смог перепрыгнуть через препятствие высотой: " + height.wallHeight + ".");
            passed = false;
        } else {
            System.out.println("Робот успешно перепрыгнул препятствие высотой: " + height.wallHeight + ".");
            passed = true;
        } // Тут должен быть вызов метода передающий участников, прошедших препятствие в массив
    }
}