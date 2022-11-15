package HW11.exercise114;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MyRandomTest {
    public static void main(String[] args) {
        Stream<Long> random = MyRandom.rand(25214903917L, 2^48, 11, 0);
        random.limit(5)
                .peek(System.out::println)
                .collect(Collectors.toList());
    }
}
