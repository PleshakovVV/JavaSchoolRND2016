package homeWorks.homeWork17.refuseBequest.good;

/**
 * Created by Master on 08.09.2016.
 */
public class Main {
    public static void main(String[] args) {
        Airplane airplane = new Airplane(new Bird());

        airplane.turnInFuel(400);
        airplane.fly();
        //airplane.sound();
    }
}
