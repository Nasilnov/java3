package lesson5;

import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Semaphore;

public class Tunnel extends Stage {
    private static final int row = 2;
    private static final boolean[] TUNNEL_ROW = new boolean[row];
    private static final Semaphore SEMAPHORE = new Semaphore(row, true);
    public Tunnel() {
        this.length = 80;
        this.description = "Тоннель " + length + " метров";
    }

    @Override
    public void go(Car c) {
        try {
            System.out.println(c.getName() + " готовится к этапу(ждет): " + description);
            try {
                SEMAPHORE.acquire();
                int tunnelrow = -1;
                synchronized (TUNNEL_ROW) {
                    for (int i = 0; i < row; i++)
                        if (!TUNNEL_ROW[i]) {
                            TUNNEL_ROW[i] = true;
                            tunnelrow = i;
                            System.out.println(c.getName() + " начал этап: " + description);
                            break;
                        }
                }

                Thread.sleep(length / c.getSpeed() * 1000);
                synchronized (TUNNEL_ROW) {
                    TUNNEL_ROW[tunnelrow] = false;
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                System.out.println(c.getName() + " закончил этап: " + description);
                SEMAPHORE.release();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
