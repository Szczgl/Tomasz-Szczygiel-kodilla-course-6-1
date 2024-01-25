package com.example.kodillagoodpatterns.challenges.food2door;

public class HealthyShop implements Producer{

    @Override
    public boolean process(Order order) {
        System.out.println("HealthyShop");
        return true;
    }
}
