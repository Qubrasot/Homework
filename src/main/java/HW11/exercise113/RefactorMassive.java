package HW11.exercise113;

import java.util.Arrays;
import java.util.stream.Collectors;

public class RefactorMassive {
    public static void main(String[] args) {
        String[] numbers = {"1, 2, 0", "4, 5"};

        String res = Arrays.stream(numbers)
                .map(number -> Arrays.asList(number.split(", ")))
                .flatMap(list -> list.stream())
                .sorted()
                .collect(Collectors.joining(", "));
        System.out.println(res);
    }
}
