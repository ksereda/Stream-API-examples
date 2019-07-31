package module_15;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        // Multiply all elements by 2

        List<Integer> list = Arrays.asList(1, 2, 3);

        System.out.println("Version 1:");
        list.replaceAll(s -> s * 2);
        System.out.println(list);

        System.out.println("\nVersion 2:");
        int[] ints = list.stream().mapToInt(x -> x * 2).toArray();
        System.out.println(Arrays.toString(ints));

        System.out.println("\nVersion 3:");
        System.out.println(list.stream().map((s) -> s * 2).collect(Collectors.toList()));


    }
}
