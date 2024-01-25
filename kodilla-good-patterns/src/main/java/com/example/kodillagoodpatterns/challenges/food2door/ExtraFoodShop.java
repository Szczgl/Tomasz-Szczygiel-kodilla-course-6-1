package com.example.kodillagoodpatterns.challenges.food2door;

public class ExtraFoodShop implements Producer{
    @Override
    public boolean process(Order order) {
        System.out.println("ExtraFoodShop");
        return true;
    }
}
