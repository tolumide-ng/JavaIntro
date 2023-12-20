import java.util.Comparator;
import java.util.Map;

record NumberOfCitiesPerState(State state, long numberOfCities) {
    public NumberOfCitiesPerState(Map.Entry<State,Long> entry) {
        this(entry.getKey(), entry.getValue());
    }

    public static Comparator<NumberOfCitiesPerState> comparingByNumberOfCities() {
        return Comparator.comparing(NumberOfCitiesPerState::numberOfCities);
    }
}

// NumberOfCitiesPerState stateWithTheMostCities = 
//     numberOfCitiesPerState.entrySet().stream().map(NumberOfCitiesPerState::new).max(NumberOfCitiesPerState.comparingByNumberOfCities()).orElseThrow();
whe