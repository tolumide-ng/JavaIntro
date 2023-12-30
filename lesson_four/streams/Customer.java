package lesson_four.streams;

import java.util.List;
import java.util.Optional;
import java.util.function.BiFunction;

record Article(String title, int inceptionYear, List<Author> authors) {
};

record Author(String name) implements Comparable<Author> {
    public int compareTo(Author other) {
        return this.name.compareTo(other.name);
    }
}

record PaurOfAuthors(Author first, Author second) {
    public static Optional<PairOfAuthors> of(Author first, Author second) {
        if (first.compareTo(second) > 0) {
            return Optional.of(new PairOfAuthors(first, second));
        } else {
            return Optional.empty();
        }
    }
}

public class Customer {
    private int id;
    private String name;

    Customer(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public static void main(String[] agrs) {
        // BiFunction<Article>
    }
}
