package lesson_four.time;

import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.Month;
import java.time.temporal.ChronoField;
import java.time.temporal.TemporalAccessor;
import java.time.temporal.TemporalQuery;

public class FamilyVactions implements TemporalQuery<Boolean> {
    // returns true if the passed-in date occurs during one of the family vacations.
    // Because the query compares the month and day only, the check succeeds even if
    // the Temporal types are not the same
    public Boolean queryFrom(TemporalAccessor date) {
        int month = date.get(ChronoField.MONTH_OF_YEAR);
        int day = date.get(ChronoField.DAY_OF_MONTH);

        // DisneyLand spring break
        if ((month == Month.APRIL.getValue()) && ((day >= 3) && (day <= 8)))
            return Boolean.TRUE;

        // Smith family reunion on Lake Saugatuck
        if ((month == Month.AUGUST.getValue()) && ((day >= 8) && (day <= 14)))
            return Boolean.TRUE;

        return Boolean.FALSE;
    }
    
    public static void main(String[] args) {
        LocalDate date = LocalDate.of(10, Month.APRIL, 2013);
        boolean isFamilyOnVaction = date.query(new FamilyVactions());

        Instant inFortyFiveMinutesTime = Instant.now().plus(Duration.ofMinutes(45));
        System.out.printf("In forty five minutes, the time would be -- %s%n", inFortyFiveMinutesTime);
    }
}
