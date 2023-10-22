package lambdas;

public class MyConsumer {
    public void main () {
        Consumer<String> print = s -> System.out.println(s);
        // print;


        Runnable runner = () -> System.out.println(new String("Hello world, I am running!"));
    }
}
