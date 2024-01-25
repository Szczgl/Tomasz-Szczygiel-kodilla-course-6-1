package com.example.kodillagoodpatterns.challenges.food2door;

public class ProcessingOrder {
    public boolean processingOrder (Order order) {
        return order.getProducer().process(order);
    }
}
