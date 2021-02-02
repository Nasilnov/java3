package lesson4;

public class SymbolTread implements Runnable {
    private String str;
    private Test test;

    public SymbolTread(String str, Test test ) {
        this.str = str;
        this.test = test;
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            try {
                test.printSymbol(str);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }
}
