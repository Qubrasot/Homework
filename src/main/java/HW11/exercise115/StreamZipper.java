package HW11.exercise115;

import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamZipper {
    public static <T> Stream<T> zip(Stream<T> first, Stream<T> second){
        Iterator<T> iteratorFirst = first.iterator();
        List<T> list = second.flatMap((el) -> {
            if (iteratorFirst.hasNext() && el != null) {
                return Stream.of(el, iteratorFirst.next());
            }
            return Stream.of();
        }).collect(Collectors.toList());

        return list.stream();
    }
}
