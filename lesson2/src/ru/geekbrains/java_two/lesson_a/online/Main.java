package ru.geekbrains.java_two.lesson_a.online;

public class Main {
    private static class Animal {
        String name;
        void move() {
            System.out.println("walks on paws");
        }
    }

    private static class Bird extends Animal {
        void fly() {
            System.out.println("flies");
        }
    }
    public static void main(String[] args) {
        Cat c = new Cat();
        System.out.println(c.getPawsAmount());

        Animal[] zoo = {
                new Animal(),
                new Bird()
        };
        for (int i = 0; i < zoo.length; i++) {
            zoo[i].move();
            if (zoo[i] instanceof Bird)
                ((Bird) zoo[i]).fly();
        }
        int i = 10;
        Cat c0 = new Cat();
    }
}
// все локальные переменные и их значения находятся в стеке,
// а все объекты хранятся в куче
