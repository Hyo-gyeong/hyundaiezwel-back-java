package f2_lambda.function;

@FunctionalInterface
public interface Consumer<T> {
    void accept(T t);
}
