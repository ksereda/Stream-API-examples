package module_10;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {

        Map<Integer, Integer> map = new HashMap<>();
        map.put(1, 10);
        map.put(2, 20);
        map.put(3, 100);


        // iterate map: Must find the sum of all keys and all values

        System.out.println("Java 7: ");
        long i = 0;

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            i += entry.getKey() + entry.getValue();
        }

        System.out.println(i);

        System.out.println("\n\nJava 8: ");
        System.out.println("Version 1: ");

        final long[] a = {0};
        map.forEach((k, v) -> a[0] += k + v);
        System.out.println(Arrays.toString(a));

        System.out.println("\nVersion 2: ");

        final long[] p = {0};
        map.entrySet().stream().forEach((s) -> p[0] += s.getKey() + s.getValue());
        System.out.println(Arrays.toString(p));

        System.out.println("\nVersion 3: ");

        System.out.println(map.entrySet().stream().mapToLong(s -> s.getKey() + s.getValue()).sum());

        System.out.println("\nVersion 4: ");

        System.out.println(map.entrySet().parallelStream().mapToLong(s -> s.getKey() + s.getValue()).sum());




    }
}
