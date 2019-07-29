package module_6;

import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.Objects;

public class Main {
    public static void main(String[] args) {

        Collection<String> collection = Arrays.asList("a1", "a2", "a3", "a1");
        Collection<Integer> collection2 = Arrays.asList(1, 2, 3, 4, 5);

        Collection<People> people = Arrays.asList(
                new People("Olya", 16, People.Sex.WOMEN),
                new People("Petya", 23, People.Sex.MAN),
                new People("Vasya", 18, People.Sex.MAN),
                new People("Elena", 42, People.Sex.WOMEN));


        // Find the maximum value among the row collection
        System.out.println("Task 1:");
        System.out.println(collection.stream().max(String::compareTo).get());
        System.out.println(collection.stream().max(Comparator.naturalOrder()).get());
        System.out.println(collection.stream().max((s1, s2) -> s1.compareTo(s2)).get());


        // Find the minimum value among the string collection
        System.out.println("\nTask 2:");
        System.out.println(collection.stream().min(String::compareTo).get());
        System.out.println(collection.stream().min(Comparator.naturalOrder()).get());
        System.out.println(collection.stream().min((s1, s2) -> s1.compareTo(s2)).get());


        // Find the maximum value provided it is not equal to the "null"
        System.out.println("\nTask 3:");
        System.out.println(collection2.stream().filter((p) -> p != null).max(Integer::compareTo).get());
        System.out.println(collection2.stream().filter(Objects::nonNull).max(Integer::compareTo).get());


        // Find the person with the maximum age
        System.out.println("\nTask 4:");
        People people1 = people.stream().max((s1, s2) -> s1.getAge().compareTo(s2.getAge())).get();
        System.out.println(people1.getName());

        People people2 = people.stream().max(Comparator.comparing(People::getAge)).get();
        System.out.println(people2.getName());

    }
}
