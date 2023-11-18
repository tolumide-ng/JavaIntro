package lesson_four.collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ListIterator;
import java.util.Objects;

public class ListAccess {
    public static void main(String[] args) {
        ListAccess self = new ListAccess();
        self.iterate_over_list();
    }

    private void explore_list_interface() {
        List<String> strings = new ArrayList<>(List.of("0", "1", "2", "3", "4", "5", "6"));
        System.out.println("strings" + strings);

        strings.subList(2, 5).clear();
        System.out.println(strings);

        strings.add(3, "10");

        System.out.println("STRINGS    " + strings);

        strings.addAll(2, List.of("12", "13", "14", "15", "16"));
        System.out.print(strings);

        strings.addAll(List.of("12", "13", "14", "15", "16"));
        System.out.print(strings);
    }
    

    private void iterate_over_list() {
        List<String> numbers = Arrays.asList("one", "two", "three", "four");
        for (ListIterator<String> iterator = numbers.listIterator(); iterator.hasNext();) {
            String nextElement = iterator.next();
            if (Objects.equals(nextElement, "two")) {
                iterator.set("2");
            }
        }

        System.out.println("numbers = " + numbers);
    }
}
