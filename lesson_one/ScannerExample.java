import java.util.Scanner;
import java.util.regex.MatchResult;

public class ScannerExample {
    public static void main(String... args) {
        String wordsAndNumbers = """
                Longing rusted furnance
                daybreak 17 benign
                8 homecoming 1
                freight car
                """;

        try (Scanner scanner = new Scanner(wordsAndNumbers)) {
            scanner.findAll("benign").map(MatchResult::group).forEach(System.out::println);
        }
    }
}