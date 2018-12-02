package ru.sbt.counters;

public class SynchronizedCounter {
    private int counter = 0;

    public synchronized int getCounterValue() {
        counter += 1;
        return counter;
    }
}
