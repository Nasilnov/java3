package lesson5;

import java.util.concurrent.CountDownLatch;

public class Finish extends Stage {

    private static boolean won = false;

    public Finish() {
    }

    @Override
    public void go(Car c) {
        try {
            if (!won) {
                won = true;
                System.out.println(c.getName() + " ПОБЕДИЛ!!!!!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
