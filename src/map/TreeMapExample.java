package map;

import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

/**
 * В его основе - красно-черное дерево, хранит элементы в отсортированном виде (в естественном порядке или при помощи компаратора).
 * В TreeMap не используется хэширование
 * Более медленный доступ: O(log n)
 */

public class TreeMapExample {

    public static void main(String[] args) {
        Map<String, Integer> stringIntegers = new TreeMap<>();
        putEntries(stringIntegers);
        System.out.println(stringIntegers.entrySet());

        Map<String, Integer> stringIntegersReversed = new TreeMap<>(Comparator.reverseOrder());
        putEntries(stringIntegersReversed);
        System.out.println(stringIntegersReversed.entrySet());
    }

    private static void putEntries(Map<String, Integer> stringIntegers) {
        stringIntegers.put("first", 1);
        stringIntegers.put("ten", 10);
        stringIntegers.put("three", 3);
        stringIntegers.put("seven", 7);
    }
}
