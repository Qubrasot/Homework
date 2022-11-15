package HW11.exercise114;

import java.util.stream.Stream;

public class MyRandom {
    public static Stream<Long> rand(long a, long m, int c, long seed){
        return Stream.iterate(seed, (x) -> (a * x + c) % m);
    }
}
