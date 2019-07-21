package module_2;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        Collection ordered = Arrays.asList("a1", "a2", "a2", "a3", "a1", "a2", "a2");
        Collection nonOrdered = new HashSet<>(ordered);


        // Get a collection without duplicates from an unordered stream
        System.out.println("Task 1:");
        System.out.println(nonOrdered.stream().distinct().collect(Collectors.toList()));

        Object[] objects = nonOrdered.stream().distinct().toArray(String[]::new);
        System.out.println(Arrays.toString(objects));

        nonOrdered.stream().distinct().forEach((s) -> System.out.print(s + ", "));


        // Get a collection without duplicates from an ordered stream.
        System.out.println("\nTask 2:");
        System.out.println(ordered.stream().distinct().collect(Collectors.toList()));

        Object[] objects2 = ordered.stream().distinct().toArray(String[]::new);
        System.out.println(Arrays.toString(objects2));

        ordered.stream().distinct().forEach((s) -> System.out.print(s + ", "));

    }
}
