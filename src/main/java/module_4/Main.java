package module_4;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        Collection<String> collection1 = Arrays.asList("a1", "a2", "a3", "a1");
        Collection<String> collection2 = Arrays.asList("1,2,0", "4,5");


        // Add "_1" to each element of the first collection
        System.out.println("Task 1:");
        System.out.println(collection1.stream().map((s) -> s + "_1").collect(Collectors.toList()));


        // Make all items to uppercase and display
        System.out.println("\nTask 2:");
        System.out.println(collection1.stream().map((s) -> s.toUpperCase()).collect(Collectors.toList()));
        System.out.println(collection1.stream().map(String::toUpperCase).collect(Collectors.toList()));


        // In the first collection, remove the first character and return an array of numbers (int [])
        System.out.println("\nTask 3:");
        int[] ints = collection1.stream().mapToInt((s) -> Integer.parseInt(s.substring(1))).toArray();
        System.out.println(Arrays.toString(ints));


        // From the second collection to get all the numbers, separated by commas
        System.out.println("\nTask 4:");
        int[] ints1 = collection2.stream().flatMap((s) -> Arrays.asList(s.split(",")).stream()).mapToInt(Integer::parseInt).toArray();
        System.out.println(Arrays.toString(ints1));

        int[] ints2 = collection2.stream().flatMap((s) -> Arrays.stream(s.split(","))).mapToInt(Integer::parseInt).toArray();
        System.out.println(Arrays.toString(ints2));


        // From the second collection to get the sum of all the numbers, separated by commas
        System.out.println("\nTask 5:");
        System.out.println(collection2.stream().flatMapToInt((s) -> Arrays.asList(s.split(",")).stream().mapToInt(Integer::parseInt)).average().getAsDouble());
        System.out.println(collection2.stream().flatMapToInt((s) -> Arrays.stream(s.split(",")).mapToInt(Integer::parseInt)).average().getAsDouble());


    }
}
