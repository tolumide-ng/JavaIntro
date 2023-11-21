package lesson_four.collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Set;

public class MyCollectionsFactory {
    public static void main(String[] args) {
        // convenience factory methods for collections
        List<String> stringList = List.of("one", "two", "three");
        Set<String> setList = Set.of("one", "two", "three");

        System.out.println("stringList {}{}{}  " + stringList);
        System.out.println("setList: {{{}}}    " + setList);

        Collection<String> strings = Arrays.asList("one", "two", "three", "four", "three");
        List<String> list = List.copyOf(strings);
        Set<String> set = Set.copyOf(strings);

        System.out.println("list copy of a collection: -->>  " + list);
        System.out.println("set copy of a collection: ->>>  " + set);

        // strings[0] = "five";

        // System.out.println("strings |||| " + strings);
        // System.out.println("list |||| " + list);
        // System.out.println("set |||| " + set);

        List<String> letters = Collections.unmodifiableList(new ArrayList<>(Arrays.asList("a", "b", "c")));
        System.out.println("the letters <><><><> " + letters);
    }
}
