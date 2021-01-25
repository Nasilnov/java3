package ru.geekbrains.java_two.lesson_b.online;

import java.io.Closeable;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;

public class Main {

    //folded
    private interface Animal {
        void breathe();
        void look();
    }

    private interface Bull extends Animal {
        default void walk() {
            System.out.println("walks on hooves");
        }
        void voice();
    }

    private interface Human extends Animal {
        void talk();
        default void walk() {
            System.out.println("walks on legs");
        }
    }

    private static class Minotaur implements Human, Bull {
        @Override
        public void breathe() {

        }
        @Override
        public void look() {

        }
        @Override
        public void voice() {

        }
        @Override
        public void talk() {

        }
        @Override
        public void walk() {
            Human.super.walk();
        }
    }

    private class Aventador implements Bull {
        @Override
        public void breathe() {

        }

        @Override
        public void look() {

        }

        @Override
        public void walk() {

        }

        @Override
        public void voice() {

        }
    }

    private interface MouseListener {
        void onMouseClicked();
    }

    private static void method1(MouseListener listener) {
        listener.onMouseClicked();
    }

    private static int divideIntegers(int a, int b) throws Exception {
        if (b == 0)
            throw new Exception("You can not divide by zero");
        return a / b;
    }

    private static void divideThings(int a, int b) {
        try {
            System.out.println(divideIntegers(a, b));
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        System.out.println("continue");
    }

    private static class IOStream implements Closeable {
        IOStream() throws FileNotFoundException {
            System.out.println("created");
            //throw new FileNotFoundException("file not found");
        }
        void write() throws SQLException {
            System.out.println("write");
            throw new SQLException("fail");
        }
        void read() throws StackOverflowError {
            System.out.println("write");
            throw new StackOverflowError("very bad thing happened");
        }
        @Override
        public void close() throws IOException {
            System.out.println("closed");
            throw new IOException("nothing");
        }
    }

    public static void main(String[] args) {
        try (IOStream io = new IOStream()) {
            io.write();
            io.read();
        } catch (SQLException | StackOverflowError | IOException e) {
            throw new RuntimeException(e);
        }


//        divideThings(10, 0);

    }

    private static void basicExceptionExamples() throws Exception {
        System.out.println(divideIntegers(10, 5));
        System.out.println(divideIntegers(100, 3));
        System.out.println(divideIntegers(10, 6));
        System.out.println(divideIntegers(100, 10));
//        System.out.println(divideIntegers(100, 0));

//        int[] arr = {1,2,3};
//        System.out.println(arr[3]);

//        MouseListener l = null;
//        l.onMouseClicked();
    }

    private static void anonymousExample() {
        class MyClass implements MouseListener {
            @Override public void onMouseClicked() { }
        }
        MyClass c = new MyClass();

        method1(c);
        method1(new MyClass());
        method1(new MouseListener() {
            @Override public void onMouseClicked() { }
        });
        method1( () -> {

        });
    }

    private static void interfaceExamples() {
        Minotaur m = new Minotaur();
        m.walk();

        Bull[] bulls = {m};
        Human[] humans = {m};
        Animal[] zoo = {m};

        bulls[0].walk();
    }
}
