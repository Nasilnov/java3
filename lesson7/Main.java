package lesson7;


import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.TreeSet;

/*
Создать класс, который может выполнять «тесты», в качестве тестов выступают классы с наборами
методов с аннотациями @Test. Для этого у него должен быть статический метод start(), которому в
качестве параметра передается или объект типа Class, или имя класса. Из «класса-теста» вначале
должен быть запущен метод с аннотацией @BeforeSuite если такой имеется, далее запущены методы
с аннотациями @Test, а по завершению всех тестов – метод с аннотацией @AfterSuite. К каждому
тесту необходимо также добавить приоритеты (int числа от 1 до 10), в соответствии с которыми будет
выбираться порядок их выполнения, если приоритет одинаковый то порядок не имеет значения.
Методы с аннотациями @BeforeSuite и @AfterSuite должны присутствовать в единственном
экземпляре, иначе необходимо бросить RuntimeException при запуске «тестирования»
 */

public class Main {

    public static void start(Class c) throws IllegalAccessException, InstantiationException, InvocationTargetException {

        Object testObj = c.newInstance();
        Method[] methods = c.getDeclaredMethods();
        List<Method> alSort = new ArrayList<>();
        Method beforeMethod = null;
        Method afterMethod = null;

        for (Method o : methods) {

            if (o.isAnnotationPresent(BeforeSuite.class)) {
                if (beforeMethod == null) beforeMethod = o;
                else throw new RuntimeException("Больше одного метода с аннотацией BeforeSuite");
            }
            if (o.isAnnotationPresent(AfterSuite.class)) {
                if (afterMethod == null) afterMethod = o;
                else throw new RuntimeException("Больше одного метода с аннотацией AfterSuite");
            }
        }
        for (int i = 1; i <= 4; i++) {
            for (int j = 0; j < methods.length; j++) {
                if (methods[j].getAnnotation(Test.class) != null) {
                    if (methods[j].getAnnotation(Test.class).priority() == i) {
                        alSort.add(methods[j]);
                    }
                }
            }
        }


        if (beforeMethod != null) beforeMethod.invoke(testObj, null);
        for (Method o : alSort) o.invoke(testObj, null);
        if (afterMethod != null) afterMethod.invoke(testObj, null);
    }


    public static void main(String[] args) throws Exception {
        start(MyClass.class);
    }
}