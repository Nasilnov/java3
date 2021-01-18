package lesson1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Main {

    public static void main(String[] args) {

        class Box<T extends Number> {
            private T item;


            private Box(T item) {
                this.item = item;
            }

            public double getItem() {
                return item.doubleValue();
            }

            public void setItem(T item) {
                this.item = item;
            }
        }

        class BoxArray<T extends Box> {
            private T[] arr;

            public BoxArray(T... arr) {
                this.arr = arr;
            }

            public void getArray() {
                for (int i = 0; i < arr.length; i++) {
                    System.out.println(arr[i].getItem());
                }
            }
            public void changeArray() {
              T[] arrDouble = arr.clone();
              arr[0] = arrDouble[1];
              arr[1] = arrDouble[0];
            }

            public ArrayList<T> ArrayToList() {
                ArrayList<T> arrList = new ArrayList<>();
                Collections.addAll(arrList, arr) ;
                return arrList;
            }

        }


        BoxArray<Box> arr = new BoxArray<>(new Box<Integer>(1), new Box<Double>(5.00));

        arr.getArray();
        System.out.println();
        arr.changeArray();
        arr.getArray();
        System.out.println(

        );
        ArrayList<Box> arrLst = arr.ArrayToList();
        for (Box box : arrLst) {
            System.out.println(box.getItem());
        }


//


    }
}

