package module_1;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        Collection<String> collection = Arrays.asList("firstElement", "a1", "a2", "3", "a3", "a1", "3", "lastElement");


        // Return the number of occurrences of the object "a1"
        System.out.println("Task 1:");
        System.out.println(collection.stream().filter((s) -> s.equals("a1")).count());
        System.out.println(collection.stream().filter("a1"::equals).count());


        // Return the first element of the collection or 0 if the collection is empty
        System.out.println("\nTask 2:");
        System.out.println(collection.stream().findFirst().orElse("0"));


        // Return the last element of the collection or “empty” if the collection is empty
        System.out.println("\nTask 3:");
        System.out.println(collection.stream().skip(collection.size() - 1).findFirst().orElse("empty"));
        System.out.println(collection.stream().skip(collection.size() - 1).findAny().orElse("empty"));


        // Find the item in the collection equal to "a3" or throw an error
        System.out.println("\nTask 4:");
        System.out.println(collection.stream().filter((s) -> s.equals("a3")).findFirst().orElse("error"));
        System.out.println(collection.stream().filter("a3"::equals).findFirst().orElse("error"));


        // Return the third element of the collection in order
        System.out.println("\nTask 5:");
        System.out.println(collection.stream().skip(2).findFirst().get());


        // Return two items begin from the second
        System.out.println("\nTask 6:");
        String[] strings = collection.stream().skip(1).limit(2).toArray(String[]::new);
        System.out.println(Arrays.toString(strings));

        System.out.println(collection.stream().skip(1).limit(2).collect(Collectors.toList()));

    }
}
