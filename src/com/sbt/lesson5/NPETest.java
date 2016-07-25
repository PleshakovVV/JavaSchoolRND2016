package com.sbt.lesson5;

/**
 * Created by Student on 25.07.2016.
 */
public class NPETest {
    public static void main(String[] args) {
        Engine engine = new Engine();
        Vehicle vehicle = new Vehicle();
        vehicle.setEngine(engine);

        Vehicle bike = new Vehicle();
        bike.setEngine(engine);

        vehicle.startEngine();
        bike.startEngine();

        System.out.println("All engines starts.");
    }
}

class Vehicle {
    private Engine engine;

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    public void startEngine() {
        engine.startEngine();
    }
}

class Engine {
    void startEngine() {
        System.out.println("Engine start");
    }
}
