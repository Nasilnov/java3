package ru.geekbrains.java_two.lesson_c.online;

import java.util.*;

public class Main {

    enum Color {
        RED("#FF0000"),
        BLUE("#0000ff"),
        GREEN("#00ff00"),
        BLACK("#000000");
        private String code;
        Color(String code) {
            this.code = code;
        }
        public String getCode() {
            return code;
        }
    }

    private static class Box implements Comparable<Box> {
        int width;
        int height;
        int flag;

        public Box(int width, int height, int flag) {
            this.width = width;
            this.height = height;
            this.flag = flag;
        }

        @Override
        public String toString() {
            // ANSI C printf(); => c99 => C++ => Java
            // %s(tring), %d(ecimal), %c(haracter),
            // %i(nteger), %f(loat), (he)%x(adecimal)
            // %%
            //System.out.printf("Hello, %s", "World");
            return String.format("Box(%d,%d, %d)", width, height, flag);
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (!(obj instanceof Box)) return false;
            Box b = (Box) obj;
            return this.width == b.width && this.height == b.height;
        }

        @Override
        public int hashCode() {
            return Objects.hash(width, height);
        }

        private int square() {
            return width * height;
        }

        @Override
        public int compareTo(Box o) {
            return (o == this) ? 0 : square() - o.square();
        }
    }
/**
 * This
 * is
 * a
 * "polotno"
 * thing
 * for
 * Gavriil
 * */
    public static void main(String[] args) {
        // E(ntity) T(ype) N(umber) K(ey) V(alue)
        Map<String, Integer> map = new HashMap<>();
        map.put("January", 1);
        map.put("February", 2);
        map.put("March", 3);
        map.put("April", 4);
        map.put("January", 10);

        System.out.println(map);
        System.out.println(map.get("February"));
        System.out.println(map.containsKey("January"));
        System.out.println(map.containsValue(3));

        Iterator<Map.Entry<String, Integer>> iter = map.entrySet().iterator();
        while (iter.hasNext()) {
            Map.Entry<String, Integer> entry = iter.next();
            System.out.print(entry.getKey() + " " + entry.getValue());
        }

        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            System.out.print(entry.getKey() + " " + entry.getValue());
        }

        Set<String> keys = map.keySet();
        for (String k : keys) {
            System.out.println(k + " " + map.get(k));
        }
    }

    private static void setExample() {
        LinkedHashSet<String> set = new LinkedHashSet<>();
        set.add("Jan");
        set.add("Feb");
        set.add("Mar");
        set.add("Jan");

        System.out.println(set);

        Box b0 = new Box(1, 1, 0);
        Box b1 = new Box(1, 2, 1);
        Box b2 = new Box(1, 3, 2);
        Box b3 = new Box(1, 4, 3);
        Box b4 = new Box(1, 1, 4);

        TreeSet<Box> boxes = new TreeSet<>(Arrays.asList(b3, b2, b0, b1));
        System.out.println(boxes);

//        HashSet<Box> boxes = new HashSet<>(Arrays.asList(b0, b1, b2, b3, b4));
//        System.out.println(boxes);

//        Iterator<Box> iter = boxes.iterator();
//        while (iter.hasNext()) {
//            System.out.print(iter.next() + " ");
//        }
        for (Box box : boxes) {
            System.out.print(box + " ");
        }
    }

    private static void listsExample() {
        String[] arr = {"January", "February", "March"};
        System.out.println(arr.toString());

        LinkedList<String> list = new LinkedList<>();
        list.add("January");
        list.add("February");
        list.add("March");
        System.out.println(list.toString());

//        Box b0 = new Box(1, 1);
//        Box b1 = new Box(1, 2);
//        Box b2 = new Box(1, 3);
//        Box b3 = new Box(1, 4);
//        Box b4 = new Box(1, 1);
//
//        ArrayList<Box> boxes = new ArrayList<>();
//        boxes.addAll(Arrays.asList(b0, b1, b2, b3));
//        System.out.println(boxes);

        System.out.println(list.contains("January"));
//        System.out.println(boxes.contains(b4));
//        boxes.remove(b0);
//
//        System.out.println(Integer.toHexString(b0.hashCode()));
//        System.out.println(Integer.toHexString(b4.hashCode()));
    }

    private static void forExamples(ArrayList<Box> boxes) {
        for (int i = 0; i < boxes.size(); i++) {
            System.out.print(boxes.get(i) + " ");
        }

        for (Box box : boxes) { //potential memory leak
            System.out.print(box + " ");
        }

        Iterator<Box> iter = boxes.iterator();
        while (iter.hasNext()) {
            System.out.print(iter.next() + " ");
        }
    }

    private static void varArgsExample() {
        int[] a = {1, 2, 3, 4, 5};
        method1(a);
        method1(new int[] {1, 2, 3, 4, 5});
        method2("hello", a);
        method2("Hello", new int[] {1, 2, 3, 4, 5});
        method2("1", 2, 3, 4, 5, 6, 7, 8, 9);

        String.format("hello, %s, %s", "java", "world");

        method3("hello", 1);
    }

    private static void method3(String a, int b) {

    }

    private static void method2(String s, int... a) { //vararg
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }
    }

    private static void method1(int[] a) {
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }
    }

    private static void enumExample() {
        class Cat {
            int age;
            Color color;
        }
        Cat c = new Cat();
        c.age = 1;
        c.color = Color.RED;

        Color[] colors = Color.values();
        for (Color color : colors) { // foreach
            System.out.print(color + " ");
            System.out.println(color.getCode());
        }
    }

}
