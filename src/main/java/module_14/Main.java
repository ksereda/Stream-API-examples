package module_14;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    static void methodGetFiboNumber(int n) {
        Stream.iterate(new int[]{0, 1}, i -> new int[]{i[1], i[0] + i[1]})
                .limit(n)
                .forEach(p -> System.out.println(p[0]));
    }

    static List<Integer> methodGetFiboNumber2(int n) {
        return Stream.iterate(new int[]{0, 1}, i -> new int[]{i[1], i[0] + i[1]})
                .limit(n)
                .map(i -> i[0])
                .collect(Collectors.toList());
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter the number and press Enter");
        int n = in.nextInt();
        System.out.println(methodGetFiboNumber2(n));
    }

}
