package lambdas;

import java.util.ArrayList;
import java.util.List;

public class MyPredicate<T> implements Predicate<T> {

    @Override
    public boolean test(T t) {
        Predicate<String> predicate = s ->  s.length() == 3;
        
        return predicate != null;
        
    }


    List<String> retainStringsOfLength3(List<String> strings) {
        Predicate<String> predicate = s -> s.length() == 3;

        List<String> stringsOfLength3 = new ArrayList<>();

        for(String s: strings) {
            if (predicate.test(s)) {
                stringsOfLength3.add(s);
            }
        }

        return stringsOfLength3;
    }
    
}
