package module_1;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class Main2 {
    public static void main(String[] args) {

        Collection<People> collection = Arrays.asList(
                new People("Olya", 16, People.Sex.WOMEN),
                new People("Petya", 23, People.Sex.MAN),
                new People("Vasya", 18, People.Sex.MAN),
                new People("Elena", 42, People.Sex.WOMEN),
                new People("Ivan", 69, People.Sex.MAN));


        // Select the men who are liable for military service (from 18 to 27 years old)
        System.out.println("Task 1:");
        List<People> collect = collection.stream().filter((s) -> s.getSex() == People.Sex.MAN).filter((s) -> s.getAge() >= 18 && s.getAge() < 27).collect(Collectors.toList());
        for (People p : collect) {
            System.out.println(p.getName());
        }


        // Find the average age among men
        System.out.println("\nTask 2:");
        System.out.println(collect.stream().filter((s) -> s.getSex() == People.Sex.MAN).mapToInt(People::getAge).average().getAsDouble());


        // Find the number of potentially working people in the sample (i.e., from the age of 18 and considering that women retire at 55, and a man at 60)
        System.out.println("\nTask 3:");
        List<People> collect1 = collection.stream().filter((s) -> s.getAge() >= 18).filter((s) -> s.getSex() == People.Sex.WOMEN && s.getAge() < 55 || s.getSex() == People.Sex.MAN && s.getAge() < 60).collect(Collectors.toList());
        for (People p : collect1) {
            System.out.println(p.getName());
        }


        // Find how often the name Ivan is found
        System.out.println(collection.stream().filter((s) -> s.getName() != null && s.getName().equals("Ivan")).count());


    }
}
