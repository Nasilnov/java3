package Lesson6;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TestTest {
    private  final Lesson6.Test test = new Lesson6.Test();
//
//    @BeforeEach
//    void setUp() {
//    }
//
//    @AfterEach
//    void tearDown() {
//    }

    @Test
    void newArrCorrect() {
        int[] arr = test.newArr(new int[]{1, 2,  2, 3, 4, 1, 7, 9});
        int[] finalArr = new int[]{1, 7, 9};
        Assertions.assertArrayEquals(arr, finalArr);
    }
    @Test
    void newArrException() {
        Assertions.assertThrows( RuntimeException.class, () -> {
            test.newArr(new int[]{6, 3, 9, 1, 7, 9});
                });
    }
}