package lesson_four.streams;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class StreamCollectors {
    public static void main(String[] args) {
        StreamCollectors example = new StreamCollectors();
        // example.createMapWithPredicate();
        example.mapConstructor();
    }

    StreamCollectors() {}

    void creatingCollectors() {
        List<Integer> numbers = IntStream.range(0, 10).boxed().collect(Collectors.toList());
        System.out.println("numbers = " + numbers);

        Set<Integer> evenNumbers = IntStream.range(0, 10).filter(number -> number % 2 == 0).boxed()
                .collect(Collectors.toSet());

        System.out.println("set = " + evenNumbers);

        LinkedList<Integer> linkedList = IntStream.range(0, 10).boxed()
                .collect(Collectors.toCollection(LinkedList::new));

        System.out.println("linked lists =" + linkedList);
    }
    
    void counting() {
        Collection<String> strings = List.of("one", "two", "three", "four", "five");

        long count = strings.stream().count();
        long countWithACollector = strings.stream().collect(Collectors.counting());

        System.out.println("count = " + count);
        System.out.println("countWithACollector = " + countWithACollector);

    }
    
    void createStringFromStream() {
        String justJoined = IntStream.range(0, 10).boxed().map(Object::toString).collect(Collectors.joining());
        System.out.println("formed strings from IntStream " + justJoined);

        String joined = IntStream.range(0, 10).boxed().map(Object::toString).collect(Collectors.joining(", "));
        System.out.println("joined with separator = " + joined);

        String joinedWithPrefixSuffixAndSeparator = IntStream.range(0, 10).boxed().map(Object::toString)
                .collect(Collectors.joining(", ", "{", "}"));
        System.out.println("joinedWithPrefixSuffixAndSeparator = " + joinedWithPrefixSuffixAndSeparator);
    }

    void createMapWithPredicate() {
        List<String> strings = List.of("one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten",
                "eleven", "twelve", "thirteen");

        Map<Boolean, List<String>> map = strings.stream().collect(Collectors.partitioningBy(s -> s.length() > 4));

        map.forEach((k, v) -> System.out.println(k + " ::::::::: " + v));
    }
    
    void mapConstructor() {
        Collection<String> strings = List.of("one", "two", "three", "four", "five");
        
        Map<Integer, List<String>> map = strings.stream().collect(Collectors.groupingBy(String::length));
        map.forEach((k, v) -> System.out.println(k + "::::::::" + v));

        Map<Integer, Long> occurence = strings.stream()
                .collect(Collectors.groupingBy(String::length, Collectors.counting()));
        occurence.forEach((k, v) -> System.out.println(k + "::::::" + v));


        Map<Integer, String> concat = strings.stream()
                .collect(Collectors.groupingBy(String::length, Collectors.joining(", ")));
        
                System.out.println("concatenation = " + concat);
    }

    void histogramCreator() {
        List<String> strings = List.of("one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten",
                "eleven", "twelve", "thirteen");

        Map<Integer, Long> histogram = strings.stream()
                .collect(Collectors.groupingBy(String::length, Collectors.counting()));
        
        Map.Entry<Integer, Long> maxValue = histogram.entrySet().stream().max(Map.Entry.comparingByValue())
                .orElseThrow();
    }
}