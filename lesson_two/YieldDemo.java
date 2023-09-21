public class YieldDemo {
    enum Day {
        MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY
    }


    public int calculate(Day d) {
        return switch (d) {
            case SATURDAY, SUNDAY -> 5;
                default -> {
                    int remainingWorkDays = 5 - d.ordinal();
                    yield remainingWorkDays;
                }
        };
    }
}
