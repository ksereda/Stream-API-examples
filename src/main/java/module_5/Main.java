package module_5;

import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        Collection<String> collection =  Arrays.asList("a1", "a4", "a3", "a2", "a1", "a4");

        Collection<People> people = Arrays.asList(
                new People("Olya", 16, People.Sex.WOMEN),
                new People("Petya", 23, People.Sex.MAN),
                new People("Vasya", 18, People.Sex.MAN),
                new People("Inessa", 42, People.Sex.WOMEN));


        // Sort the string collection alphabetically
        System.out.println("Task 1:");
        System.out.println(collection.stream().sorted().collect(Collectors.toList()));
        System.out.println(collection.stream().sorted((s1, s2) -> s1.compareTo(s2)).collect(Collectors.toList()));
        System.out.println(collection.stream().sorted(Comparator.naturalOrder()).collect(Collectors.toList()));


        // Sort the collection of strings alphabetically in reverse order.
        System.out.println("\nTask 2:");
        System.out.println(collection.stream().sorted((s1, s2) -> s2.compareTo(s1)).collect(Collectors.toList()));
        System.out.println(collection.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList()));


        // Sort the collection of strings alphabetically and remove duplicates
        System.out.println("\nTask 3:");
        System.out.println(collection.stream().sorted().distinct().collect(Collectors.toList()));
        System.out.println(collection.stream().sorted((s1, s2) -> s1.compareTo(s2)).distinct().collect(Collectors.toList()));
        System.out.println(collection.stream().sorted(Comparator.naturalOrder()).distinct().collect(Collectors.toList()));


        // Sort the collection of strings alphabetically in reverse order and remove duplicates.
        System.out.println("\nTask 4:");
        System.out.println(collection.stream().sorted((s1, s2) -> s2.compareTo(s1)).distinct().collect(Collectors.toList()));
        System.out.println(collection.stream().sorted(Comparator.reverseOrder()).distinct().collect(Collectors.toList()));


        // Sort the collection of people by name in reverse alphabetical order
        System.out.println("\nTask 5:");
        List<People> collect = people.stream().sorted((s1, s2) -> s2.getName().compareTo(s1.getName())).collect(Collectors.toList());
        for (People p : collect) {
            System.out.println(p.getName());
        }


        // Sort the collection of people by name in alphabetical order
        System.out.println("\nTask 6:");
        List<People> collect3 = people.stream().sorted((s1, s2) -> s1.getName().compareTo(s2.getName())).collect(Collectors.toList());
        for (People p : collect3) {
            System.out.println(p.getName());
        }

        List<People> collect4 = people.stream().sorted(Comparator.comparing(People::getName)).collect(Collectors.toList());
        for (People p : collect4) {
            System.out.println(p.getName());
        }


        // Sort a collection of people, first by gender, and then by age
        System.out.println("\nTask 7:");
        List<People> collect1 = people.stream().sorted((s1, s2) -> s1.getSex() != s2.getSex() ? s1.getSex().compareTo(s2.getSex()) : s1.getAge().compareTo(s2.getAge())).collect(Collectors.toList());
        for (People p : collect) {
            System.out.println(p.getName());
        }


    }
}
