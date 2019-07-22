package module_3;

import java.util.Arrays;
import java.util.Collection;

public class Main {
    public static void main(String[] args) {

        Collection<String> collection = Arrays.asList("a1", "a2", "a3", "a1");


        // Find whether there is at least one “a1” item in the collection.
        System.out.println("Task 1:");
        System.out.println(collection.stream().anyMatch((s) -> s.equals("a1")));
        System.out.println(collection.stream().anyMatch("a1"::equals));


        // Find whether there is a symbol "1" for all elements of the collection.
        System.out.println("\nTask 2:");
        System.out.println(collection.stream().allMatch((s) -> s.contains("1")));
        System.out.println(collection.stream().allMatch("1"::contains));


        // Check that there are no “a7” elements in the collection
        System.out.println("\nTask 3:");
        System.out.println(collection.stream().noneMatch((s) -> s.equals("a7")));
        System.out.println(collection.stream().noneMatch("a7"::equals));


    }
}
