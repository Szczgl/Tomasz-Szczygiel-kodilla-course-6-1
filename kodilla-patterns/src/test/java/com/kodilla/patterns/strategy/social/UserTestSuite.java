package com.kodilla.patterns.strategy.social;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UserTestSuite {

    @Test
    void testDefaultSharingStrategies() {
        //Given
        User adam = new Millenials("Adam Milen");
        User pawel = new ZGeneration("Pawel Zgen");
        User tomasz = new YGeneration("Tomasz Ygen");

        //When
        String adamPublished = adam.sharePost();
        System.out.println("Adam " + adamPublished);
        String pawelPublished = pawel.sharePost();
        System.out.println("Pawel " + pawelPublished);
        String tomaszPublished = tomasz.sharePost();
        System.out.println("Tomasz " + tomaszPublished);

        //Then
        assertEquals("publicate on Facebook", adamPublished);
        assertEquals("publicate on Snapchat", pawelPublished);
        assertEquals("publicate on Twitter", tomaszPublished);
    }

    @Test
    void testIndividualSharingStrategy() {
        //Given
        User adam = new Millenials("Adam Milen");

        //When
        String adamPublished = adam.sharePost();
        System.out.println("Adam " + adamPublished);
        adam.setSocialPublisher(new SnapchatPublisher());
        adamPublished = adam.sharePost();
        System.out.println("Adam now " + adamPublished);

        //Then
        assertEquals("publicate on Snapchat", adamPublished);
    }
}
