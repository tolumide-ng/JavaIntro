package lesson_four.time;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.time.temporal.Temporal;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;

public class PaydayAdjuster implements TemporalAdjuster {
    
    public Temporal adjustInto(Temporal input) {
        LocalDate date = LocalDate.from(input);
        int day;
        if (date.getDayOfMonth() < 15) {
            day = 15;
        } else {
            day = date.with(TemporalAdjusters.lastDayOfMonth()).getDayOfMonth();
        }
        date = date.withDayOfMonth(day);
        if (date.getDayOfWeek() == DayOfWeek.SATURDAY || date.getDayOfWeek() == DayOfWeek.SUNDAY) {
            date = date.with(TemporalAdjusters.previous(DayOfWeek.FRIDAY));
        }

        return input.with(date);
    }

    public static void main(String[] args) {
        LocalDate day = LocalDate.now();
        LocalDate nextPayday = day.with(new PaydayAdjuster());

        LocalDate anotherDay = LocalDate.of(2013, Month.JUNE, 10);
        LocalDate anotherPayday = anotherDay.with(new PaydayAdjuster());

        System.out.printf("Payday for %s is %s%n", day, nextPayday);
        System.out.printf("...and the Payday for %s is %s%n", anotherDay, anotherPayday);
    }
}