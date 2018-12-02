package ru.sbt.counters;

import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.results.format.ResultFormatType;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import java.util.concurrent.TimeUnit;

@BenchmarkMode(Mode.Throughput)
@State(Scope.Benchmark)
public class CounterBenchmark {
    private AtomicCounter atomicCounter = new AtomicCounter();
    private SynchronizedCounter synchronizedCounter = new SynchronizedCounter();
    private SemaphoreCounter semaphoreCounter = new SemaphoreCounter();

    @Benchmark
    @Threads(1)
    public int synchronizedCounterThread_1() {
        return this.synchronizedCounter.getCounterValue();
    }

    @Benchmark
    @Threads(2)
    public int synchronizedCounterThread_2() {
        return this.synchronizedCounter.getCounterValue();
    }

    @Benchmark
    @Threads(4)
    public int synchronizedCounterThread_4() {
        return this.synchronizedCounter.getCounterValue();
    }

    @Benchmark
    @Threads(8)
    public int synchronizedCounterThread_8() {
        return this.synchronizedCounter.getCounterValue();
    }

    @Benchmark
    @Threads(16)
    public int synchronizedCounterThread_16() {
        return this.synchronizedCounter.getCounterValue();
    }

    @Benchmark
    @Threads(1)
    public int semaphoreCounterThread_1(){
        return this.semaphoreCounter.getCounterValue();
    }

    @Benchmark
    @Threads(2)
    public int semaphoreCounterThread_2(){
        return this.semaphoreCounter.getCounterValue();
    }

    @Benchmark
    @Threads(4)
    public int semaphoreCounterThread_4(){
        return this.semaphoreCounter.getCounterValue();
    }

    @Benchmark
    @Threads(8)
    public int semaphoreCounterThread_8(){
        return this.semaphoreCounter.getCounterValue();
    }

    @Benchmark
    @Threads(16)
    public int semaphoreCounterThread_16(){
        return this.semaphoreCounter.getCounterValue();
    }

    @Benchmark
    @Threads(1)
    public int atomicCounterThread_1() {
        return this.atomicCounter.getCounterValue();
    }

    @Benchmark
    @Threads(2)
    public int atomicCounterThread_2() {
        return this.atomicCounter.getCounterValue();
    }

    @Benchmark
    @Threads(4)
    public int atomicCounterThread_4() {
        return this.atomicCounter.getCounterValue();
    }

    @Benchmark
    @Threads(8)
    public int atomicCounterThread_8() {
        return this.atomicCounter.getCounterValue();
    }

    @Benchmark
    @Threads(16)
    public int atomicCounterThread_16() {
        return this.atomicCounter.getCounterValue();
    }

    public static void main(String[] args) throws RunnerException {
        Options options = new OptionsBuilder()
                .include(CounterBenchmark.class.getSimpleName())
                .timeUnit(TimeUnit.MICROSECONDS)
                .warmupIterations(15)
                .measurementIterations(30)
                .forks(1)
                .resultFormat(ResultFormatType.TEXT)
                .result("benchmark.txt")
                .build();
        new Runner(options).run();
    }
}