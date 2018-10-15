package others;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

public class PlusPlus {

    private static int count = 0;
    private static volatile int volatileCount = 0;
    private static AtomicInteger atomicInteger = new AtomicInteger(0);
    private static Counter counter = new Counter();

    public static final int THREAD_SIZE = 10;

    public static void main(String[] args) throws InterruptedException {

        CountDownLatch countDownLatch = new CountDownLatch(THREAD_SIZE);

        for (int i = 0; i < THREAD_SIZE; i++) {
            new Thread(() -> {
                for (int j = 0; j < 10000; j++) {
                    count++;
                    volatileCount++;
                    atomicInteger.getAndIncrement();
                    counter.increment();
                }
                countDownLatch.countDown();
            }).start();
        }
        countDownLatch.await();
        System.out.println("count:" + count);
        System.out.println("volatileCount:" + volatileCount);
        System.out.println("atomicInteger:" + atomicInteger.intValue());
        System.out.println("counter:" + counter.getValue());
    }
}

class Counter {

    private volatile int value = 0;

    public synchronized void increment() {
        this.value++;
    }

    public int getValue() {
        return value;
    }
}