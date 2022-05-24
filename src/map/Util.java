package map;

import java.util.Map;

public class Util {

    public static void iterateKeySet(Map<?, ?> example) {
        for (Object object : example.keySet()) {
            System.out.println(example.get(object));
        }
    }

    public static void iterateMapValues(Map<?, ?> example) {
        for (Object o : example.values()) {
            System.out.println(o);
        }
    }

    public static void iterateEntrySet(Map<?, ?> example) {
        for (Map.Entry<?, ?> entry : example.entrySet()) {
            System.out.println(entry);
        }
    }
}
