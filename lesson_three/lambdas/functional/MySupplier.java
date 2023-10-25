package lambdas.functional;

import java.util.Random;

public class MySupplier {
    public void main() {
        Supplier<String> supplier = () -> "Hello World as a String";

        Random random = new Random(314L);
        Supplier<Integer> newRandom = () -> random.nextInt(10);
        IntSupplier intRandom = () -> random.nextInt(10);


        Consumer<String> printer = s -> System.out.println(s);


        for (int index=0; index < 5; index++) {
            Integer randomValue = newRandom.get();
            System.out.println(randomValue + " ");
            System.out.println(intRandom.get() + " ");
            
            
            printer.accept("next Random =" + randomValue);
        }

        System.out.println("AS String" + supplier);
    }
}
