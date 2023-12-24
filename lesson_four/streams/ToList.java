package lesson_four.streams;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;

public class ToList<T> implements Collector<T, List<T>, List<T>> {
    
    public Supplier<List<T>> supplier() {
        return ArrayList::new;
    }

    public BiConsumer<List<T>, T> accumulator() {
        return Collection::add;
    }

    public BinaryOperator<List<T>> combiner() {
        return (l1, l2) -> {
            l1.addAll(l2);
            return l1;
        };
    }

    public Function<List<T>, List<T>> finisher() {
        return Function.identity();
    }

    public Set<Characteristics> characteristics() {
        return Set.of(Characteristics.IDENTITY_FINISH);
    }
}




class Implementor {
    public void main(String[] args) {
        Collection<String> strings = List.of("one", "two", "three", "four", "five");
        List<String> result = strings.stream().collect(new ToList<>());
        System.out.println("result = " + result);
    }
}