package module_9;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        Collection<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        Collection<String> strings = Arrays.asList("a1", "b2", "c3", "a1");
        Collection<String> stringsWithoutDuplicateValue = Arrays.asList("a1", "b2", "c3");

        Collection<People> collectionPeople = Arrays.asList(
                new People("Olya", 16, People.Sex.WOMEN),
                new People("Petya", 23, People.Sex.MAN),
                new People("Vasya", 18, People.Sex.MAN),
                new People("Elena", 42, People.Sex.WOMEN),
                new People("Ivan", 69, People.Sex.MAN),
                new People("Irina", 69, People.Sex.MAN));


        // Get the sum of odd numbers
        System.out.println("Task 1:");
        System.out.println(numbers.stream().collect(Collectors.summingInt(((s) -> s % 2 == 0 ? s : 0))));
        System.out.println(numbers.stream().filter((s) -> s % 2 == 0).mapToInt(Integer::intValue).sum());
        System.out.println((Integer) numbers.stream().mapToInt(((s) -> s % 2 == 0 ? s : 0)).sum());


        // Subtract 1 from each element and get the average
        System.out.println("\nTask 2:");
        System.out.println(numbers.stream().collect(Collectors.averagingInt((s) -> s - 1)));
        System.out.println(numbers.stream().map((s) -> s - 1).mapToInt(Integer::intValue).average().getAsDouble());
        System.out.println(numbers.stream().mapToInt((s) -> s - 1).average().getAsDouble());


        // Add to all numbers 3 and get statistics
        System.out.println("\nTask 3:");
        System.out.println(numbers.stream().collect(Collectors.summarizingInt((s) -> s + 3)));


        // Add to all numbers 3 and get the sum of the numbers
        System.out.println("\nTask 4:");
        System.out.println(numbers.stream().collect(Collectors.summingInt((s) -> s + 3)));
        System.out.println(numbers.stream().map((s) -> s + 3).mapToInt(Integer::intValue).sum());
        System.out.println(numbers.stream().mapToInt((s) -> s + 3).sum());


        // Divide numbers into even and odd
        System.out.println("\nTask 4:");
        System.out.println(numbers.stream().collect(Collectors.partitioningBy((s) -> s % 2 == 0)));


        // Get a list without duplicates
        System.out.println("\nTask 5:");
        System.out.println(strings.stream().distinct().collect(Collectors.toList()));
        Object[] objects = strings.stream().distinct().toArray();
        System.out.println(Arrays.toString(objects));


        // Get an array of strings without duplicates and in upper case
        System.out.println("\nTask 6:");
        String[] stringResultArray = strings.stream().map(String::toUpperCase).distinct().toArray(String[]::new);
        System.out.println(Arrays.toString(stringResultArray));


        // Merge All Items Into One Line
        System.out.println("\nTask 7:");
        System.out.println(strings.stream().collect(Collectors.joining()));
        System.out.println(String.join("", strings));
//        System.out.println(strings.stream().flatMap((s) -> Arrays.asList(s.split(",")).stream()).collect(Collectors.toList()));


        // Merge all elements into one line through the separator ":"
        System.out.println("\nTask 8:");
        System.out.println(strings.stream().collect(Collectors.joining(":")));
        System.out.println(String.join(":", strings));


        // Merge all elements into a single line through the separator: and wrap the tags "<b>" and "</b>"
        System.out.println("\nTask 9:");
        System.out.println(strings.stream().collect(Collectors.joining(":", "<b>", "</b>")));


        // Convert to map, where the first character is the key, the second character is the value
        System.out.println("\nTask 10:");
        System.out.println(stringsWithoutDuplicateValue.stream().collect(Collectors.toMap((s) -> s.substring(0, 1), (s) -> s.substring(1, 2))));


        // Convert to map, grouped by the first character of the string
        System.out.println("\nTask 11:");
        System.out.println(stringsWithoutDuplicateValue.stream().collect(Collectors.groupingBy((s) -> s.substring(0, 1))));


        // Convert to map, grouped by the first character of the string and combine the second characters through ":"
        System.out.println("\nTask 12:");
        System.out.println(strings.stream().collect(Collectors.groupingBy((s) -> s.substring(0, 1), Collectors.mapping((s) -> s.substring(1, 2), Collectors.joining(":")))));


        // It is necessary to convert one collection to another, by names starting with "I"
        List<People> nameStartWithI = collectionPeople.stream().filter((s) -> s.getName().startsWith("I")).collect(Collectors.toList());
        for (People p : nameStartWithI) {
            System.out.println(p.getName());
        }


    }
}
