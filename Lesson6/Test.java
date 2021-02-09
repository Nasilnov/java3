package Lesson6;

public class Test {
    public static int[] arr = new int[]{1, 2,  2, 3, 4, 1, 7, 9};

    public static void main(String[] args) {
        int[] array = newArr(arr);
        for (int i = 0; i < array.length ; i++) {
            System.out.print(array[i] + " ");
        }
    }

    public  static int[] newArr(int[] arr) {
        int index = -1;
        for (int i = arr.length - 1; i > -1  ; i--) {
            if (arr[i] == 4 ) {
                index  = i;
                break;
            }
            if (i ==  0 && index == -1 ) {
                throw new RuntimeException();
            }
        }
        int[] newArray = new int[arr.length - index - 1];
        System.arraycopy(arr, index + 1  ,newArray,0, arr.length - index - 1);
        return newArray;
    }

}
