package map;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * HashMap - словарь, ассоциативный массив. Данные хранятся в формате ключ-значение, где ключ уникален для всего массива.
 * Ключ - ссылка на ячейку памяти с ключом, преобразованная в целочисленную форму методом hashCode() класса Object.
 * Значения по-умолчанию для нового объекта: емкость = 16, фактор загрузки = 0,75.
 * Фактор загрузки необходим для более равномерного распределения пар в массиве и избежания коллизий.
 * При коллизии хэшей, то есть в случае, когда разным ключам присваивается одинаковый хэш, значения хранятся в виде связанного списка.
 * HashMap не хранит порядок добавления элементов.
 * Если в качестве ключа выступает объект и одно из его полей изменится, то значение по ключу найдено не будет,
 * так как изменится хэш объекта.
 * Возврат упорядоченных элементов при использовании числа в качестве ключа не может считаться отсортированным словарем
 * O(1): contains, put, remove
 * HashTable в целом аналогичен HashMap за исключением:
 * - невозможно добавить null-ключ и null-значения
 * - HastTable синхронизирован
 */
public class HashMapExample {

    public static void main(String[] args) {
        Map<KeyObject, String> example = new HashMap<>(2, 1);

        KeyObject keyObject = new KeyObject(200, "item with 200 intValue");
        KeyObject keyObject1 = new KeyObject(200, "item with 200 intValue");

        System.out.println("При переопределении hashCode хэши двух объектов с одинаковыми полями равны:");
        System.out.println("keyObject.hashCode() == keyObject1.hashCode() " + (keyObject.hashCode() == keyObject1.hashCode()));
        System.out.println("При переопределении toString эти два объекта так же будут равны:");
        System.out.println("keyObject.equals(keyObject1) " + keyObject.equals(keyObject1));

        example.put(keyObject, "just string value");

        System.out.println("Получение значения по ключу 'keyObject': " + example.get(keyObject));

        keyObject.setIntValue(100);
        System.out.println("Изменили значение поля в ключе, поиск по ключу неудачен: " + example.get(keyObject));

        example.clear();
        example.put(keyObject, "first item");
        example.put(keyObject1, "second item");
        String value = example.putIfAbsent(keyObject1, "third item");
        System.out.println("Попытка добавить объект с существующим ключом методом putIfAbsent(K, V).");
        System.out.println("Метод возвращает уже внесенное значение: " + value);
        Util.iterateKeySet(example);

        Util.iterateMapValues(example);

        computeNewValueIfPresent(example, keyObject);
        computeNewValueIfAbsent(example);

        Util.iterateEntrySet(example);

        getDefaultValueIfNoKeyFound(example);

        hashMapWithIntegerKey();

    }

    private static void computeNewValueIfPresent(Map<KeyObject, String> example, KeyObject keyObject) {
        String newValue = example.computeIfPresent(keyObject, (keyObject2, s) -> s.concat("-modified"));
        System.out.println("Новое значение записи по ключу keyObject: " + newValue);
    }

    private static void computeNewValueIfAbsent(Map<KeyObject, String> example) {
        example.computeIfAbsent(new KeyObject(0, "absent before"), value -> "new value");
    }

    private static void getDefaultValueIfNoKeyFound(Map<KeyObject, String> example) {
        System.out.println(example.getOrDefault(new KeyObject(0, null), "default value"));
    }

    private static void hashMapWithIntegerKey() {
        Map<Integer, String> integerStrings = new HashMap<>();
        integerStrings.put(3, "three");
        integerStrings.put(1, "One");
        integerStrings.put(2, "two");
        System.out.println("\n HashMap with key of integers");
        Util.iterateEntrySet(integerStrings);
    }

    public static class KeyObject {

        private final String stringValue;
        private int intValue;

        public KeyObject(int intValue, String stringValue) {
            this.intValue = intValue;
            this.stringValue = stringValue;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof KeyObject)) return false;
            KeyObject object = (KeyObject) o;
            return intValue == object.intValue && Objects.equals(stringValue, object.stringValue);
        }

        public void setIntValue(int intValue) {
            this.intValue = intValue;
        }

        @Override
        public int hashCode() {
            return Objects.hash(intValue, stringValue);
        }

        @Override
        public String toString() {
            return "KeyObject{" +
                    "intValue=" + intValue +
                    ", stringValue='" + stringValue + '\'' +
                    '}';
        }
    }


}
