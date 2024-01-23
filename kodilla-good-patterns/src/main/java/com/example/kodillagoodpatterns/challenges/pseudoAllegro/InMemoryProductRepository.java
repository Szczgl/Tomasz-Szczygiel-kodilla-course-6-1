package com.example.kodillagoodpatterns.challenges.pseudoAllegro;

public class InMemoryProductRepository implements ProductRepository{
    @Override
    public void createOrder(User user, Product product) {
        System.out.println("Tworzenie zamówienia na " + product.getProductName() + " dla użytkownika " + user.getUserName());
    }
}
