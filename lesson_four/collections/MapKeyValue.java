package lesson_four.collections;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class MapKeyValue {
    public static void main(String[] args) {
        Map<Integer, String> map = new HashMap<Integer, String>();
        map.put(1, "one");
        map.put(2, "two");
        map.put(3, "three");
        map.put(4, "four");
        map.put(5, "five");
        map.put(6, "six");

        Set<Integer> keys = map.keySet();
        System.out.println("keys = " + keys);

        Collection<String> values = map.values();
        System.out.print("values =" + values);

        Set<Map.Entry<Integer, String>> entries = map.entrySet();
        System.out.println("entries = " + entries);

        keys.remove(3);
        entries.forEach(System.out::println);

        MapKeyValue mapKV = new MapKeyValue();

        mapKV.removing();
        mapKV.withLambdas();
    }
    
    void removing() {
        Map<Integer, String> map = Map.ofEntries(
                Map.entry(1, "one"),
                Map.entry(2, "two"),
                Map.entry(3, "three"),
                Map.entry(4, "three"));

        map = new HashMap<>(map);
        System.out.println("before the removal =" + map);
        map.values().remove("three");
        System.out.println("map = " + map);
    }
    
    void iterating(Map<Integer, String> map) {
        for (Map.Entry<Integer, String> entry : map.entrySet()) {
            System.out.println("entry =" + entry);
        }
    }

    void withLambdas() {
        Map<Integer, String> map = new HashMap<>();
        map.put(1, "One");
        map.put(2, "two");
        map.put(3, "three");
        map.put(4, "four");

        System.out.println("the map = " + map);
        map.replace(5, "five");
        System.out.println("after trying to do something weird =" + map);

        map.replaceAll((k, v) -> v.toUpperCase());
        map.forEach((k, v) -> System.out.println(k + "::::" + v));
    }


    void approachOne() {
        List<String> strings = List.of("one", "two", "three", "four", "five", "six", "seven", "eight", "nine");
        Map<Integer, List<String>> map = new HashMap<>();

        for (String word : strings) {
            int length = word.length();
            if (!map.containsKey(length)) {
                map.put(length, new ArrayList<>());
            }
            map.get(length).add(word);
        }

        map.forEach((k, v) -> System.out.println(k + "::::::::" + v));
    }

    void approachTwo() {
        List<String> strings = List.of("one", "two", "three", "four", "five", "six", "seven", "eight", "nine");
        Map<Integer, List<String>> map = new HashMap<>();

        for (String word : strings) {
            int length = word.length();
            map.putIfAbsent(length, new ArrayList<>());
            map.get(length).add(word);
        }
    }

    void approachThree() {
        List<String> strings = List.of("one", "two", "three", "four", "five", "six", "seven", "eight", "nine");
        Map<Integer, List<String>> map = new HashMap<>();

        for (String word : strings) {
            int length = word.length();
            map.computeIfAbsent(length, key -> new ArrayList<>()).add(word);
        }
    }
}
