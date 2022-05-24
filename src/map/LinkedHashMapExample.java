package map;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * В основе лежит двусвязный список, поэтому он сохраняет порядок добавления элементов.
 * accessOrder = true отображает последний элемент, к которому осуществлялся доступ, в конце списка при итерации.
 * False либо неуказание значения выводит список в порядке добавления.
 * Отличие от HashMap в сохранении порядка добавления или доступа. Поэтому LinkedHashMap более затратен в плане памяти.
 * O(1): contains, put, remove
 */
public class LinkedHashMapExample {

    private static final String REGULAR_EXP = "%s: %s %n";

    public static void main(String[] args) {
        Map<Integer, String> integerStringsAccessOrder = new LinkedHashMap(10, 0.75f, true);
        integerStringsAccessOrder.put(3, "third");
        integerStringsAccessOrder.put(1, "first");
        integerStringsAccessOrder.put(4, "fourth");
        integerStringsAccessOrder.put(2, "second");

        System.out.printf(REGULAR_EXP, integerStringsAccessOrder.get(1), integerStringsAccessOrder);
        System.out.printf(REGULAR_EXP, integerStringsAccessOrder.get(2), integerStringsAccessOrder);
        System.out.printf(REGULAR_EXP, integerStringsAccessOrder.get(3), integerStringsAccessOrder);
        System.out.printf(REGULAR_EXP, integerStringsAccessOrder.get(4), integerStringsAccessOrder);
        System.out.println();

        Map<Integer, String> integerStringsInsertionOrder = new LinkedHashMap(10, 0.75f, false);
        integerStringsInsertionOrder.put(3, "third");
        integerStringsInsertionOrder.put(1, "first");
        integerStringsInsertionOrder.put(4, "fourth");
        integerStringsInsertionOrder.put(2, "second");


        System.out.printf(REGULAR_EXP, integerStringsInsertionOrder.get(1), integerStringsInsertionOrder);
        System.out.printf(REGULAR_EXP, integerStringsInsertionOrder.get(2), integerStringsInsertionOrder);
        System.out.printf(REGULAR_EXP, integerStringsInsertionOrder.get(3), integerStringsInsertionOrder);
        System.out.printf(REGULAR_EXP, integerStringsInsertionOrder.get(4), integerStringsInsertionOrder);

        /*
          Итерация по ключам в методе Util.iterateKeySet(integerStringsAccessOrder) бросает ConcurrentModificationException
          https://stackoverflow.com/questions/16180568/concurrentmodificationexception-with-linkedhashmap
         */

    }
}
