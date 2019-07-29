package module_7;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        Collection<StringBuilder> collection = Arrays.asList(new StringBuilder("a1"), new StringBuilder("a2"), new StringBuilder("a3"));


        // add "_new" to each element
        // forEach
        System.out.println("Task 1: forEach");
        collection.stream().forEach((s) -> s.append("_new"));
        System.out.println(collection);


        // peek
        System.out.println("\nTask 1: peek");
        System.out.println(collection.stream().peek((s) -> s.append("_new")).collect(Collectors.toList()));


        // Do all elements to uppercase and display it
        System.out.println("\nTask 2:");
        System.out.println(collection.stream().map(StringBuilder::toString).map(String::toUpperCase).collect(Collectors.toList()));
        collection.stream().map(StringBuilder::toString).map(String::toUpperCase).forEach((s) -> System.out.print(s + ","));
        collection.stream().map(StringBuilder::toString).map(String::toUpperCase).forEach(System.out::println);


    }
}
