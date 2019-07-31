package module_13;

import java.util.Arrays;

public class Main {

    // It's necessary to convert multidimensional array to one-dimensional array

    private static int[] convertArray(int[][] A) {
        return Arrays.stream(A).flatMapToInt(Arrays::stream).toArray();
    }

    private static int[] convertArray2(int[][] A) {
        return Arrays.stream(A).flatMapToInt(i -> Arrays.stream(i)).toArray();
    }

    public static void main(String[] args) {
        int [][]A = {{5,7}, {7,0}};
        System.out.println("Multidimensional array: " + Arrays.deepToString(A));
        int [] result = convertArray(A);
        System.out.println("One-dimensional array: " + Arrays.toString(result));
    }

}
