package HW11.exercise115;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamZipperTest {
    public static void main(String[] args) {
        Stream<String> first = Stream.of("a", "b", "c");
        Stream<String> second = Stream.of("A","B", "C", "D");
        List<String> result = StreamZipper.zip(first, second).collect(Collectors.toList());
        System.out.println(result);
    }
}
