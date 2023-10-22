package lambdas;

@FunctionalInterface
public interface Predicate<T> {
    boolean test(T t);

    default Predicate<T> and(Predicate<? super T> other) {
        return t-> this.test(t) && other.test(t);
    }

    default Predicate<T> or(Predicate<? super T> other) {
        return t -> this.test(t) || other.test(t);
    }

    static <T> Predicate<T> isEqual(Object targetRef) {
        return (T input) -> targetRef.equals(input);
    }
}
