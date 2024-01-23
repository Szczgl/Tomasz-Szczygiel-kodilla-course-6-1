import com.example.kodillagoodpatterns.challenges.MovieStore;

import java.util.*;
import java.util.stream.Collectors;

public class GoodPatternsMain {

    public static void main(String[] args) {
        MovieStore movieStore = new MovieStore();
        Map<String, List<String>> movies = movieStore.getMovies();

        String print = movies.values().stream()
                .flatMap(List::stream)
                .collect(Collectors.joining(" ! "));
        System.out.println(print);
    }
}

