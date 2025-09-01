package f2_lambda.function;

@FunctionalInterface
public interface Supplier<T> {
    T get();
}
