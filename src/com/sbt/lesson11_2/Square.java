package com.sbt.lesson11_2;

/**
 * Created by Student on 18.08.2016.
 */
public class Square implements Runnable{

    private int width;
    private int x;
    private int y;

    public Square(int width, int x, int y) {
        this.width = width;
        this.x = x;
        this.y = y;
    }

    private Object lockWidth = new Object();
    private Object lockLocation = new Object();

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        synchronized (lockWidth) {
            this.width = width;
        }
    }

    public int getX() {
        return x;
    }

    public void changeLocation(int x, int y) {
        System.out.println("Start changed...");
        synchronized (lockLocation) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            this.x = x;
            this.y = y;
            System.out.println("Location changed to: x:" + this.x + " y:" + this.y);
        }
    }

    public int getY() {
        return y;
    }

    @Override
    public void run() {
        changeLocation(2,3);
    }
}
