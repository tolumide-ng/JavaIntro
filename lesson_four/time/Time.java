package lesson_four.time;

import java.time.DayOfWeek;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.OffsetDateTime;
import java.time.YearMonth;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;
import java.time.temporal.TemporalQueries;
import java.time.temporal.TemporalQuery;
import java.time.temporal.TemporalUnit;

public class Time {
    private static void instantTime() {
        Instant oneHourLater = Instant.now().plus(1, ChronoUnit.HOURS);
        long secondsSinceEpoch = Instant.ofEpochSecond(0L).until(Instant.now(), ChronoUnit.SECONDS);

        // long ati = Instant.now().getEpochSecond();

        System.out.println("one hour later is " + oneHourLater);
        System.out.println("secondsSinceEpoch " + secondsSinceEpoch);
    }
    
    private static void readableTimeStamp() {
        Instant timeStamp = Instant.now();
        LocalDateTime ldt = LocalDateTime.ofInstant(timeStamp, ZoneId.systemDefault());
        ZonedDateTime zdt = ZonedDateTime.ofInstant(timeStamp, ZoneId.of("Europe/Berlin"));
        System.out.println("the zoned datetime " + zdt);
        System.out.printf("%s %d %d at %d:%d%n", ldt.getMonth(), ldt.getDayOfMonth(), ldt.getYear(), ldt.getHour(), ldt.getMinute());
    }

    private static void temporal() {
        boolean isSupported = LocalDate.now().isSupported(ChronoField.CLOCK_HOUR_OF_DAY);
        System.out.println("is supported?? " + isSupported);

        LocalDateTime ldt = LocalDateTime.of(2020, 11, 10, 1, 30, 10);
        int dayOfTheYear = ldt.get(ChronoField.DAY_OF_YEAR);
        Instant timeStamp = Instant.now();
        ZonedDateTime zdt = ZonedDateTime.now();
        OffsetDateTime odt = OffsetDateTime.now();
        System.out.printf("How many days since %s --->>>> %d%n", ldt.toString(), dayOfTheYear);
        System.out.println("How does that differ from instant? " + timeStamp);
        System.out.println("Compared to the ZonedDateTime " + zdt);
        System.out.println("To fulfill all righteousness " + odt);
    }

    private static void temporalAdjusters() {
        LocalDate date = LocalDate.of(2000, Month.OCTOBER, 16);
        DayOfWeek dayOfTheWeek = date.getDayOfWeek();
        System.out.printf("%s is on a %s%n", date, dayOfTheWeek);

        System.out.printf("first day of the Month: %s%n", date.with(TemporalAdjusters.firstDayOfMonth()));
        System.out.printf("first day of next year", date.with(TemporalAdjusters.firstDayOfNextYear()));
    }

    public static void main(String[] args) {
        // Time.readableTimeStamp();
        // Time.temporal();
        // Time.temporalAdjusters();
        Time.temporalQuery();
    }

    private static void temporalQuery() {
        TemporalQuery<TemporalUnit> query = TemporalQueries.precision();
        System.out.printf("LocalDate precision is %s%n", LocalDate.now().query(query));
        System.out.printf("LocalDateTime precision is %s%n", LocalDateTime.now().query(query));
        System.out.printf("YearMonth precision is %s%n", YearMonth.now().query(query));
        System.out.printf("Instant precision is %s%n", Instant.now().query(query));
    }
}
