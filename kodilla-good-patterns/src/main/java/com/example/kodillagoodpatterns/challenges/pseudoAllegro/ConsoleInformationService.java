package com.example.kodillagoodpatterns.challenges.pseudoAllegro;

public class ConsoleInformationService implements InformationService{
    @Override
    public void inform(User user) {
        System.out.println("Informacje dla " + user.getUserName() + " o zamówieniu.");
    }
}
