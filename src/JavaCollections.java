import java.util.Collections;
import java.util.List;

public class JavaCollections {

    public static void main(String[] args) {
        List<String> strings = Collections.emptyList();
        try {
            strings.add("first");
        } catch (UnsupportedOperationException e) {
            System.out.println("UnsupportedOperationException occurs");
        }

        Collections.addAll(strings);
    }

}
