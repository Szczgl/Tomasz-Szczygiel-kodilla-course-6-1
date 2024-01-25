package com.example.kodillagoodpatterns.challenges.food2door;

public class GlutenFreeShop implements Producer{

    @Override
    public boolean process(Order order) {
        System.out.println("GlutenFreeShop");
        return true;
    }
}
