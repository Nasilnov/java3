package lesson1;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.ArrayList;
import java.util.Iterator;

public class FruitCalc {



    public static void main(String[] args) {

        class Fruit {
            private float width;

            private Fruit(float width) {
                this.width = width;
            }

            public float getWidth() {
                return width;
            }

            public void setWidth(float width) {
                this.width = width;
            }

            public String getName(){
                return "Фрукт";
            };

        }

        class Apple extends Fruit {

            private Apple() {
                super(1.0f);
            }
            public String getName(){
                return "Яблоко";
            };
        }

        class Orange extends Fruit {

            private Orange() {
                super(1.5f);
            }
            public String getName(){
                return "Апельсин";
            };
        }

        class Box<T extends Fruit> {
            private ArrayList<T> cart;

            private Box() {
                this.cart = new ArrayList<>();
            }

            public void addToCart (T item) {
                cart.add(item);
            }

            public float getWeight () {
                float allWeight = 0;
                for (T t : cart) {
                   allWeight += t.getWidth();
                }
                return allWeight;
            }

            public  boolean compare(Box o) {
                if (Math.abs(getWeight() - o.getWeight()) < 0.001) return true;
                else return false;
            }

            public void shiftCart( Box<T> anyCart) {

                try {
                    Iterator iterator = this.cart.iterator();
                    while (iterator.hasNext()) {
                        while (true) {
                            Fruit item = this.cart.get(0);
                            this.cart.remove(item);
                            anyCart.addToCart((T) item);
                            break;
                        }
                    }
                } catch (Exception e ) {
                    e.printStackTrace();
                    System.out.println("Не та корзина");
                }
//                System.out.println( self.cart.get(0).getClass().getName() );
            }

            @Override
            public String toString() {
                String items = null;
                    items = "Корзина - " + this.hashCode() + " - ";
                for ( Fruit item: cart ) {
                     items += item.getName() + " ";
                }
                return items;
            }
        }

        Box<Apple> cart1 = new Box<>();
        for (int i = 0; i < 6; i++) {
            cart1.addToCart(new Apple());
        }
        Box<Orange> cart2 = new Box<>();
        for (int i = 0; i < 4; i++) {
            cart2.addToCart(new Orange());
        }

        System.out.println(cart1.compare(cart2));

        cart2.addToCart(new Orange());
        System.out.println(cart1.compare(cart2));
//
        System.out.println(cart1);
        System.out.println(cart2);
        Box<Orange> cart3 = new Box<>();
        cart2.shiftCart(cart3);

        System.out.println(cart2);
        System.out.println(cart3);

//        cart3.shiftCart(cart1); // - Не позволяет компилятор

    }


}
