package com.sbt.lesson11_2;

/**
 * Created by Student on 18.08.2016.
 */
public class Account implements Runnable{

    private int saldo;

    public Account(int saldo) {
        this.saldo = saldo;
    }

    public int getSaldo() {
        return saldo;
    }

    public synchronized void decreaseSaldo(int sum) {
        if (saldo - sum >= 0) {
            saldo -=  sum;
        } else {
            System.out.println("Overdraft not available!");
        }
    }

    @Override
    public void run() {
        int x = 12;

        for (int i = 0; i < x; i++) {
            decreaseSaldo(10);
            System.out.println(Thread.currentThread().getName() + " " + getSaldo());
            if (getSaldo() < 0) {
                throw new RuntimeException("Current account overdrafted!");
            }
        }
    }
}
