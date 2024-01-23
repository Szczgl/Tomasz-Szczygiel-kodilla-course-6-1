package com.example.kodillagoodpatterns.challenges.pseudoAllegro;

public class ProductOrderServiceImpl implements ProductService {
    @Override
    public boolean order(User user, Product product) {
        System.out.println("Zamówienie " + product.getProductName() + " dla użytkownika " + user.getUserName());
        return true;
    }
}
