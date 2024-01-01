package lesson_four.time;

import java.time.LocalDate;
import java.time.Month;
import java.time.Period;
import java.time.temporal.ChronoUnit;

public class Birthday {
    
    public String getAge(LocalDate birthday) {
        LocalDate today = LocalDate.now();
        Period p = Period.between(birthday, today);

        String text = String.format("You are %s years, %s months, and %s days old", p.getYears(), p.getMonths(),
                p.getDays());

        return text;
    }
    
    public String nextBirthday(LocalDate birthday) {
        LocalDate today = LocalDate.now();
        LocalDate nextBDay = birthday.withYear(today.getYear());

        if (nextBDay.isBefore(today) || nextBDay.isEqual(today)) {
            nextBDay = nextBDay.plusYears(1);
        }

        Period p = Period.between(today, nextBDay);
        long p2 = ChronoUnit.DAYS.between(today, nextBDay);
        String text = String.format("You have %s months and %s days until your next birthday --- days until next birthday (%s days)", p.getMonths(), p.getDays(), p2);
        return text;
    }

    
    public static void main(String[] args) {
        Birthday birthday = new Birthday();
        LocalDate day = LocalDate.of(1940, Month.MAY, 16);
        // String text = birthday.getAge(day);
        String text = birthday.nextBirthday(day);
        System.out.println(text);
    }
}
