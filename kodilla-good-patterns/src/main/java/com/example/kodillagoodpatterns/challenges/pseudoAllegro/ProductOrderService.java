package com.example.kodillagoodpatterns.challenges.pseudoAllegro;

public class ProductOrderService {

    private InformationService informationService;
    private ProductService productService;
    private ProductRepository productRepository;

    public ProductOrderService(InformationService informationService, ProductService productService, ProductRepository productRepository) {
        this.informationService = informationService;
        this.productService = productService;
        this.productRepository = productRepository;
    }

    public OrderDto processOrder(User user, Product product) {
        boolean isOrdered = productService.order(user, product);

        if (isOrdered) {
            informationService.inform(user);
            productRepository.createOrder(user, product);
        }

        return new OrderDto(user, isOrdered);
    }
}
