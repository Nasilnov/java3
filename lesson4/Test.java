package lesson4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Test {
    public Object mon = new Object();
    public volatile String currentLetter = "C";
    public List<String> arrStr = Arrays.asList("A","B","C") ;

    public static void main(String[] args) {
        Test test = new Test();
        Thread t1 = new Thread(new SymbolTread("A", test));
        Thread t2 = new Thread(new SymbolTread("B", test));
        Thread t3 = new Thread(new SymbolTread("C", test));
        t1.start();
        t2.start();
        t3.start();

    }

    public void printSymbol(String str) {

        synchronized (mon) {

            int indexStr = arrStr.indexOf(str);

            String prevStr;
            if (indexStr > 0) {
                prevStr = arrStr.get(indexStr - 1);
            } else {
                prevStr = arrStr.get(2);
            }

            try {
                while ( currentLetter != prevStr ) {
                    mon.wait();
                }
                    System.out.print(str);
                    currentLetter = str;
                    mon.notifyAll();

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

}

