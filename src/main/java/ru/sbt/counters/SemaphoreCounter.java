package ru.sbt.counters;

import java.util.concurrent.Semaphore;

public class SemaphoreCounter {
    Semaphore semaphore = new Semaphore(1);
    private int counter = 0;

    public int getCounterValue(){
        try {
            semaphore.acquire();
            ++counter;
        } catch (InterruptedException e){
            e.printStackTrace();
        }finally {
            semaphore.release();
        }
        return counter;
    }
}