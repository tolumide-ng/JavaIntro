package lambdas.functional;

@FunctionalInterface
public interface Supplier<T> {
    T get();
}
