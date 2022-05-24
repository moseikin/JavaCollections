import java.util.*;

/**
 * ArrayList() - реализация интерфейса List. Это список произвольной длины: от 0 до Integer.MAX_VALUE.
 * В основе списка лежит массив с емкостью по-умолчанию = 10, начальную емкость можно также задать.
 * При увеличении длины списка, создается новый список с емкостью увеличенной на 50%, куда копируются все данные.
 * Произвольный доступ к элементам списка - O(1), вставка и удаление по индексу - O(n). Поиск по объекту.
 * <p>
 * LinkedList(). Устроен иначе: нет массива в основе, это связанный список:
 * каждый элемент содержит ссылку на предыдущий и следующий объекты.
 * За счет этого достигается постоянная скорость O(1) вставки и удаления в список,
 * но плохая скорость при поиске - O(n), так как до нужного элемента нужно добраться по цепочке адресов.
 */

public class ListImpls {

    public static void main(String[] args) {
        actWithListImplementation(new ArrayList<>());

        actWithListImplementation(new LinkedList<>());
    }


    private static void actWithListImplementation(List<String> strings) {
        System.out.println("\n" + strings.getClass());

        System.out.println("Список пуст? " + strings.isEmpty());

        strings.add("first");

        strings.add("second");
        strings.add("fifth");

        strings.set(strings.size() - 1, "third");

        passWithIterator(strings);

        passWithForFunction(strings);

        strings.add(0, "zero");

        passWithForEachFunction(strings);

        System.out.println("Список содержит 'first'? " + strings.contains("first"));

        System.out.println("Индекс 'second': " + strings.indexOf("second"));

        strings.clear();
        System.out.println("Список пуст? " + strings.isEmpty());
    }

    private static void passWithIterator(List<String> strings) {
        Iterator<String> iterator = strings.iterator();
        while (iterator.hasNext()) {
            printItem(iterator.next());
        }
        System.out.println();
    }

    private static void passWithForFunction(List<String> strings) {
        for (int i = 0; i < strings.size(); i++) {
            printItem(strings.get(i));
        }
        System.out.println();
    }

    private static void passWithForEachFunction(List<String> strings) {
        for (String s : strings) {
            printItem(s);
        }
        System.out.println();
    }

    private static void printItem(String item) {
        System.out.printf("%s ", item);
    }
}
