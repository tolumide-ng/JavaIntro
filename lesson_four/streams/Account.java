package lesson_four.streams;
import lesson_four.streams.Sale;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Account {
    private List<Sale> sales;

    public static void main(String[] args) {
        Account account = new Account();

        int amountSoldInMarcUsingLoopApproach = account.usingLoop();
        System.out.println("Amount sold in March: " + amountSoldInMarcUsingLoopApproach);
    }

    public Account() {
        this.sales = List.of(new Sale("Monitor", LocalDate.now(), 19), new Sale("Keyboard", LocalDate.now(), 10));
    }
    
    
    public int usingLoop() {
        int amountSoldInMarch = 0;
        for (Sale sale : sales) {
            if (sale.getDate().getMonth() == Month.MARCH) {
                amountSoldInMarch += sale.getAmount();
            }
        }
        return amountSoldInMarch;
    }


    private void efficientStreamParser() {
        List<String> strings = List.of("1", "2", "", "3", "4", "  3  ");
        List<Integer> ints = strings.stream().<Integer>mapMulti((string, consumer) -> {
            try {
                consumer.accept(Integer.parseInt(string));
            } catch (NumberFormatException e) {}}).collect(Collectors.toList());
        
        System.out.println("ints = " + ints);
    }

    private void streamParser() {
        Function<String, Stream<Integer>> flatParser = s -> {
            try {
                return Stream.of(Integer.parseInt(s));
            } catch (NumberFormatException e) {
            }
            return Stream.empty();
        };

        List<String> strings = List.of("1", "2", "", "3", "4", "  3  ");
        
        List<Integer> ints = strings.stream().flatMap(flatParser).collect(Collectors.toList());
        System.out.println("ints = " + ints);
    }

    public boolean checkNumber(String s) {
        try {
            int i = Integer.parseInt(s);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public void isNumber() {
        Predicate<String> isANumber = s -> {
            try {
                int i = Integer.parseInt(s);
                return true;
            } catch (NumberFormatException e) {
                return false;
            }
        };

        List<String> strings = List.of("one ", "two", "three", "four", "five");
        List<String> validStrings = strings.stream().filter(isANumber).collect(Collectors.toList());

        System.out.println("the result of the map is ????" + validStrings);

        // return isANumber
    }
}
