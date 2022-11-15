package HW11.exercise115;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Stream;

public class StreamZipper {
    public static <T> Stream<T> zip(Stream<T> first, Stream<T> second){
        Iterator<T> iteratorFirst = first.iterator();
        Iterator<T> iteratorSecond = second.iterator();
        List<T> list = new ArrayList<T>();

        while(iteratorFirst.hasNext() && iteratorSecond.hasNext()){
            list.add(iteratorFirst.next());
            list.add(iteratorSecond.next());
        }

        return list.stream();
    }
}
