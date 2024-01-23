import com.example.kodillagoodpatterns.challenges.MovieStore;
import com.example.kodillagoodpatterns.challenges.pseudoAllegro.*;

import java.util.*;
import java.util.stream.Collectors;

public class GoodPatternsMain {

    public static void main(String[] args) {

        // 12.1

        MovieStore movieStore = new MovieStore();
        Map<String, List<String>> movies = movieStore.getMovies();

        String print = movies.values().stream()
                .flatMap(List::stream)
                .collect(Collectors.joining(" ! "));
        System.out.println(print);
        System.out.println();

        //  12.2

        InformationService informationService = new ConsoleInformationService();
        ProductService productService = new ProductOrderServiceImpl();
        ProductRepository productRepository = new InMemoryProductRepository();

        ProductOrderService orderService = new ProductOrderService(informationService, productService, productRepository);

        User user = new User("Jan Kowalski");
        Product product = new Product("Smartphone");

        OrderDto orderResult = orderService.processOrder(user, product);
        System.out.println("Zamówienie dla " + orderResult.getUser().getUserName() + ": " + (orderResult.isOrdered() ? "Powodzenie" : "Brak"));

        //12.4

    }
}

