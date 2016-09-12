package com.sbt.lesson19;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Student on 12.09.2016.
 */
public class Client {
    public static void main(String[] args) {
        MeteoStation meteo = new MeteoStation();
        Observer cons = new ConsoleObserver();
        meteo.addObserver(cons);
        meteo.setData(15,766);
    }
}

interface Observable {
    void notifyObserver(int temperature, int pressure);
    void addObserver(Observer observer);
    void removeObserver(Observer observer);
}

interface Observer {
    void onChange(int temperature, int pressure);
}

class MeteoStation implements Observable{
    int temperature;
    int pressure;
    List<Observer> observerList = new ArrayList<>();

    public void setData(int temperature, int pressure) {
        this.temperature = temperature;
        this.pressure = pressure;
        this.notifyObserver(temperature, pressure);
    }

    @Override
    public void notifyObserver(int temperature, int pressure) {
        for (Observer observer1 : observerList) {
            observer1.onChange(temperature, pressure);
        }
    }

    @Override
    public void addObserver(Observer observer) {
        observerList.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observerList.remove(observer);
    }
}

class ConsoleObserver implements Observer{
    @Override
    public void onChange(int temperature, int pressure) {
        System.out.println("Temp: " + temperature + " Pressure: " + pressure);
    }
}
