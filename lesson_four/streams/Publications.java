package lesson_four.streams;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

record Article(String title, int inceptionYear, List<Author> authors) {};

record Author(String name) implements Comparable<Author> {
    public int compareTo(Author other) {
        return this.name.compareTo(other.name);
    }
}

record PairOfAuthors(Author first, Author second) {
    public static Optional<PairOfAuthors> of(Author first, Author second) {
        if (first.compareTo(second) > 0) {
            return Optional.of(new PairOfAuthors(first, second));
        } else {
            return Optional.empty();
        }
    }
};

public class Publications {
    public static void main(String[] args) {
        // BiFunction<Article, Author, Stream<PairOfAuthors>> buildPairOfAuthors = (article, firstAuthor) -> article
        //         .authors().stream().flatMap(secondAuthor -> PairOfAuthors.of(firstAuthor, secondAuthor).stream());


        // Function<Article, Stream<PairOfAuthors>> toPairOfAuthors = article -> article.authors().stream()
        //         .flatMap(firstAuthor -> buildPairOfAuthors.apply(article, firstAuthor));
        
        // List<Article> articles = List.of();
        
        // Stream<PairOfAuthors> pairOfAuthors = articles.stream().flatMap(toPairOfAuthors);

        // Map<PairOfAuthors, Long> numberOfAuthorsTogether = articles.stream().flatMap(toPairOfAuthors)
        //         .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        
        // Function<Map<PairOfAuthors, Long>, Map.Entry<PairOfAuthors, Long>> maxExtractor = map -> map.entrySet().stream()
        //         .max(Map.Entry.comparingByValue()).orElseThrow();

        // System.out.println("The most publication was done by " + maxExtractor);
        // System.out.println("Together " + numberOfAuthorsTogether);
        // System.out.println("Pair of Authors " + pairOfAuthors);
    }
    
}
