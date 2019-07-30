package module_11;

import java.util.Arrays;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        String[] stringArray = {"1", "2", "3", "4", "5"};
        int[] intArray = {1, 2, 3, 4, 5};

        // Get a stream from a piece of array
        System.out.println(Arrays.stream(stringArray, 0, 2).map(String::trim).collect(Collectors.toList()));
        System.out.println(Arrays.toString(Arrays.stream(intArray, 0, 2).toArray()));

    }
}
