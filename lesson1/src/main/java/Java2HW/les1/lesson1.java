package Java2HW.les1;

public class lesson1 {
    public static void main(String[] args) {
        // нужно передать массив прошедших препятствие участников в старый
        Playable[] players = new Playable[]{
                new Cat(75, 100),
                new Human(50, 79),
                new Human(40, 60),
                new Robot(80, 120)
        };

        Obstacle[] obstacles = {
                new Wall(45),
                new Treadmill(40),
                new Treadmill(80),
                new Wall(50)
        };

        for (Obstacle obstacle : obstacles) {
            for (Playable player : players) {
                obstacle.overcome(player);
            }
        }
    }
}