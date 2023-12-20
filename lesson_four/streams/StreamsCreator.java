package lesson_four.streams;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Spliterator;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public class StreamsCreator {
    Iterator<String> iterator;

    public void fromIterator() {
        List<String> strings = List.of("one");

        long estimateSize = 10L;
        int characteristics = 0;
        // Spliterator<String> spliterator = Spliterator.spliterator(strings.iterator(), estimateSize, characteristics);
        // Stream<String> stream = StreamSupport.stream(strings.iterator(), false);
    }

    public Stream<String> emptyStream() {
        Stream<String> empty = Stream.empty();
        List<String> strings = empty.collect(Collectors.toList());

        System.out.println("string =" + strings);

        return empty;
    }

    public List<Integer> varArg() {
        Stream<Integer> intStream = Stream.of(1, 2, 3, 4);
        List<Integer> ints = intStream.collect(Collectors.toList());

        String[] stringArray = { "one", "two", "three", "four" };
        Stream<String> stringStream = Arrays.stream(stringArray);
        List<String> strings = stringStream.collect(Collectors.toList());

        System.out.println("strings = " + strings);
        System.out.println("ints =" + ints);

        return ints;
    }

    public List<String> usingGenerate() {
        Stream<String> generated = Stream.generate(() -> "+");
        return generated.limit(10L).collect(Collectors.toList());
    }

    public void usingIterate() {
        Stream<String> iterated = Stream.iterate("+", s -> s.length() <= 5, s -> s + "+");
        iterated.forEach(System.out::println);

        Stream<String> strings = Stream.iterate("+", s -> s + "+");
        strings.limit(5L).forEach(System.out::println);
    }

}
