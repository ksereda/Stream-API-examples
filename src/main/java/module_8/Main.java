package module_8;

import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) {

        Collection<Integer> collection = Arrays.asList(1, 2, 3, 4, 2);

        Collection<People> peoples = Arrays.asList(
                new People("Vasya", 16, People.Sex.MAN),
                new People("Petr", 23, People.Sex.MAN),
                new People("Elena", 42, People.Sex.WOMEN),
                new People("Ivan", 69, People.Sex.MAN)
        );


        // Get the sum of numbers or return 0
        System.out.println("Task 1:");
        System.out.println(collection.stream().reduce((s1, s2) -> s1 + s2).orElse(0));
        System.out.println(collection.stream().reduce(Integer::sum).orElse(0));

        System.out.println(collection.stream().mapToInt((s) -> Integer.parseInt(String.valueOf(s))).sum());
        System.out.println(collection.stream().mapToInt(Integer::intValue).sum());


        // Get the arithmetic average of all numbers
        System.out.println("\nTask 2:");
        System.out.println(collection.stream().mapToInt((s) -> Integer.parseInt(String.valueOf(s))).average().getAsDouble());
        System.out.println(collection.stream().mapToInt(Integer::intValue).average().getAsDouble());


        // Return the maximum or -1
        System.out.println("\nTask 3:");
        System.out.println(collection.stream().reduce((s1, s2) -> s1 > s2 ? s1 : s2).orElse(-1));
        System.out.println(collection.stream().reduce(Integer::max).orElse(-1));

        System.out.println(collection.stream().mapToInt((s) -> Integer.parseInt(String.valueOf(s))).max().orElse(-1));
        System.out.println(collection.stream().mapToInt(Integer::intValue).max().orElse(-1));
        System.out.println(collection.stream().max(Integer::compare).orElse(-1));
        System.out.println(collection.stream().max(Integer::compareTo).orElse(-1));


        // Return the minimum or -1
        System.out.println("\nTask 4:");
        System.out.println(collection.stream().reduce((s1, s2) -> s1 > s2 ? s2 : s1).orElse(-1));
        System.out.println(collection.stream().reduce(Integer::min).orElse(-1));

        System.out.println(collection.stream().mapToInt((s) -> Integer.parseInt(String.valueOf(s))).min().orElse(-1));
        System.out.println(collection.stream().mapToInt(Integer::intValue).min().orElse(-1));
        System.out.println(collection.stream().min(Integer::compare).orElse(-1));
        System.out.println(collection.stream().min(Integer::compareTo).orElse(-1));


        // Return the sum of even numbers or 0
        System.out.println("\nTask 5:");
        System.out.println(collection.stream().filter((s) -> s % 2 == 0).reduce((s1, s2) -> s1 + s2).orElse(-0));
        System.out.println(collection.stream().filter((s) -> s % 2 == 0).reduce(Integer::sum).orElse(-0));

        System.out.println(collection.stream().filter((s) -> s % 2 == 0).mapToInt(Integer::intValue).sum());


        // Return the last item
        System.out.println("\nTask 6:");
        System.out.println(collection.stream().reduce((s1, s2) -> s2).get());

        System.out.println(collection.stream().skip(collection.size() - 1).findFirst().get());


        // Return the sum of numbers that are greater than 2
        System.out.println("\nTask 7:");
        System.out.println(collection.stream().filter((s) -> s > 2).reduce((s1, s2) -> s1 + s2).get());
        System.out.println(collection.stream().filter((s) -> s > 2).reduce(Integer::sum).get());

        System.out.println(collection.stream().filter((s) -> s > 2).mapToInt((s) -> Integer.parseInt(String.valueOf(s))).sum());
        System.out.println(collection.stream().filter((s) -> s > 2).mapToInt(Integer::intValue).sum());


        // Find The Oldest Man
        System.out.println("\nTask 8:");
        System.out.println(peoples.stream().filter((s) -> s.getSex() == People.Sex.MAN).map(People::getAge).reduce(Integer::max).orElse(-1));
        System.out.println(peoples.stream().filter((s) -> s.getSex() == People.Sex.MAN).map(People::getAge).reduce((s1, s2) -> s1 > s2 ? s1 : s2).get());

        People people = peoples.stream().filter((s) -> s.getSex() == People.Sex.MAN).max((s1, s2) -> s1.getAge().compareTo(s2.getAge())).get();
        System.out.println(people.getName());

        People people1 = peoples.stream().filter((s) -> s.getSex() == People.Sex.MAN).max(Comparator.comparing(People::getAge)).get();
        System.out.println(people1.getName());


        //Find the minimum age of a person who contains "e" in the name
        System.out.println("\nTask 9:");
        System.out.println(peoples.stream().filter((s) -> s.getName().contains("e")).map(People::getAge).reduce(Integer::min).orElse(-1));

        People peopleWithNameContainsE = peoples.stream().filter((s) -> s.getName().contains("e")).min((s1, s2) -> s1.getAge().compareTo(s2.getAge())).get();
        System.out.println(peopleWithNameContainsE.getName());

        People peopleWithNameContainsE_2 = peoples.stream().filter((s) -> s.getName().contains("e")).min(Comparator.comparing(People::getAge)).get();
        System.out.println(peopleWithNameContainsE_2.getName());



    }
}
