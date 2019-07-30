package module_12;

public class Main {
    public static void main(String[] args) {

        String testString = "a.b.c.d.e.j.k.l.o";

        // It's necessary to find all points in the given line
        System.out.println(testString.chars().filter((s) -> s == '.').count());
        System.out.println(testString.codePoints().filter((s) -> s == '.').count());

    }
}
