package lambdas.functional;

import java.util.Comparator;
import java.util.function.Function;

public class CompareLength {
    public void main(String[] args) {
        Comparator<String> comparator = (s1, s2) -> Integer.compare(s1.length(), s2.length());


        Function<String, Integer> toLength = String::length;
        
        Comparator<String> compareStr = (s1, s2) -> Integer.compare(toLength.apply(s1), toLength.apply(s2));
        Comparator<Integer> compareLength = Integer::compare;


        String a = "hello";
        String b = "word";

        Integer x = toLength.apply(a);
        Integer y = toLength.apply(b);

        Integer comparisonResultA = compareStr.compare(a, b);
        Integer comparisonResultB = compareLength.compare(x, y);
        


        System.out.println("Result A" + comparisonResultA + "\n" + "Result B" + comparisonResultB);

        // compareThem.compare();

        // compareThem.compare("name", "abi");

        Comparator<String> compareX = Comparator.comparing(String::length);
        Integer abc = compareX.compare(a, b);

        System.out.println("Using the built in static method 'comparing' " + abc);
    }
}