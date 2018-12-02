package ru.sbt.counters;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicCounter {
    private final AtomicInteger counter = new AtomicInteger(0);

    public int getCounterValue() {
        return this.counter.getAndIncrement();
    }
}
