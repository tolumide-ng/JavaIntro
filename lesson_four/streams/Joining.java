package lesson_four.streams;

import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;

public class Joining implements Collector<String, StringBuffer, String> {
    
    public Supplier<StringBuffer> supplier() {
        return StringBuffer::new;
    }

    public BiConsumer<StringBuffer, String> accumulator() {
        return StringBuffer::append;
    }

    public BinaryOperator<StringBuffer> combiner() {
        return StringBuffer::append;
    }

    public Function<StringBuffer, String> finisher() {
        return Object::toString;
    }

    public Set<Characteristics> characteristics() {
        return Set.of();
    }
}


class Example {
    public void main(String[] args) {
        Collection<String> strings = List.of("one", "two", "three", "four");
        String result = strings.stream().collect(new Joining());
        System.out.println("result = " + result);
    }
}