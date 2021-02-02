package lesson5;

import java.util.concurrent.CountDownLatch;

public class Start extends Stage {
    private  CountDownLatch start;

    public Start(int CARS_COUNT) {
        this.start = new CountDownLatch(CARS_COUNT);
    }

    @Override
    public void go(Car c) {
        try {
            start.countDown();
            start.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
