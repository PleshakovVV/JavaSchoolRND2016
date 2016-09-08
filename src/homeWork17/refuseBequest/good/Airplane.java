package homeWork17.refuseBequest.good;

/**
 * Created by Master on 08.09.2016.
 */
public class Airplane {
    private final Bird bird;

    public Airplane(Bird bird) {
        this.bird = bird;
    }

    public void turnInFuel(int gallons) {
        System.out.println("Get " + gallons + " gallons of fuel.");
    }

    public void fly() {
        this.bird.fly();
    }
}
