package lesson_four.time;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.chrono.ChronoLocalDate;
import java.time.chrono.Chronology;
import java.time.chrono.HijrahDate;
import java.time.chrono.IsoChronology;
import java.time.chrono.JapaneseDate;
import java.time.chrono.MinguoDate;
import java.time.chrono.ThaiBuddhistDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.format.DecimalStyle;
import java.time.format.FormatStyle;
import java.time.temporal.TemporalAccessor;
import java.util.HashMap;
import java.util.Locale;

public class NonISO {
    public static void main(String[] args) {
        NonISO nonIso = new NonISO();
        HashMap<String, ChronoLocalDate> variousDates = nonIso.toNonISO();
        // for (String name : variousDates.keySet()) {
        //     System.out.println(name + ":::" + variousDates.get(name));
        // }

    }
    
    private HashMap<String, ChronoLocalDate> toNonISO() {
        HashMap<String, ChronoLocalDate> variousDates = new HashMap<>();
        LocalDateTime date = LocalDateTime.of(2013, Month.JULY, 20, 19, 20);
        JapaneseDate jdate = JapaneseDate.from(date);
        variousDates.put("japaneseDate", jdate);

        HijrahDate hdate = HijrahDate.from(date);
        variousDates.put("hijrahDate", hdate);

        MinguoDate mdate = MinguoDate.from(date);
        variousDates.put("minguoDate", mdate);

        ThaiBuddhistDate tdate = ThaiBuddhistDate.from(date);
        variousDates.put("thaiBuddhistDate", tdate);

        return variousDates;
    }

    public static String toString(LocalDate localDate, Chronology chrono) {
        if (localDate != null) {
            Locale locale = Locale.getDefault(Locale.Category.FORMAT);
            ChronoLocalDate cDate;
            if (chrono == null) {
                chrono = IsoChronology.INSTANCE;
            }

            try {
                cDate = chrono.date(localDate);
            } catch (DateTimeException ex) {
                System.err.println(ex);
                chrono = IsoChronology.INSTANCE;
                cDate = localDate;
            }
            String pattern = "M/d/yyy GGGGG";
            DateTimeFormatter dateFormatter = DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT).ofPattern(pattern)
                    .withLocale(locale)
                    .withChronology(chrono).withDecimalStyle(DecimalStyle.of(locale));
            return dateFormatter.format(cDate);
        }
        return "";
    }
    
    /**
     * Parses a String to a ChronoLocalDate using DateTimeFormatter
     * with a short pattern based on the current Locale and the provided
     * Chronolofy, then converts this to a LocalDate (ISO) value
     * 
     * @param text     - the input date text in the SHORT format expected
     *                   for the Chronology and the current locale.
     * @param chrono   - an optional Chronology. If null, then IsoChronology
     *                   is used.
     * 
     */
    public static LocalDate fromString(String text, Chronology chrono) {
        if (text != null && !text.isEmpty()) {
            Locale locale = Locale.getDefault(Locale.Category.FORMAT);
            if (chrono == null) {
                chrono = IsoChronology.INSTANCE;
            }

            String pattern = "d/M/yyyy GGGGG";
            DateTimeFormatter df = new DateTimeFormatterBuilder().parseLenient().appendPattern(pattern).toFormatter()
                    .withChronology(chrono).withDecimalStyle(DecimalStyle.of(locale));
            TemporalAccessor temporal = df.parse(text);
            ChronoLocalDate cDate = chrono.date(temporal);
            return LocalDate.from(cDate);
        }
        return null;
    }
}
