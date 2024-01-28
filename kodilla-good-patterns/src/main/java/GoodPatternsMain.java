import com.example.kodillagoodpatterns.challenges.MovieStore;
import com.example.kodillagoodpatterns.challenges.flyApp.Flight;
import com.example.kodillagoodpatterns.challenges.flyApp.FlightService;
import com.example.kodillagoodpatterns.challenges.food2door.*;
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

        Producer extraFoodShop = new ExtraFoodShop();
        Producer healthyShop = new HealthyShop();
        Producer glutenFreeShop = new GlutenFreeShop();

        Order order1 = new Order(healthyShop,"Kawa", 20);
        Order order2 = new Order(glutenFreeShop,"Czekolada", 10);

        ProcessingOrder processingOrder = new ProcessingOrder();
        boolean ifSuccessOrder = processingOrder.processingOrder(order1);

        if (ifSuccessOrder) {
            System.out.println("zamówienie w realizacji");
        } else {
            System.out.println("zamówienie odrzucono");
        }
        System.out.println();

        //12.5

        FlightService flightService = new FlightService();

        flightService.addFlight(new Flight("Gdańsk", "Wrocław"));
        flightService.addFlight(new Flight("Kraków", "Wrocław"));
        flightService.addFlight(new Flight("Warszawa", "Gdańsk"));
        flightService.addFlight(new Flight("Kraków", "Warszawa", "Gdańsk"));
        flightService.addFlight(new Flight("Kraków", "Katowice", "Gdańsk"));

        List<Flight> flightFromKrakow = flightService.findFlightFromCity("Kraków");
        List<Flight> flightToWroclaw = flightService.findFlightToCity("Wrocław");
        List<Flight> flightToGdanskViaKatowice = flightService.findFlightThroughCity("Gdańsk", "Katowice");

        System.out.println("Loty z Krakowa: " + flightFromKrakow);
        System.out.println("Loty do Wrocławia: " + flightToWroclaw);
        System.out.println("Loty do Gdańska z przesiadką w Katowicach: " + flightToGdanskViaKatowice);
    }
}

