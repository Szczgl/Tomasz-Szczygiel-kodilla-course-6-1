package com.kodilla.patterns.strategy.social;

public final class TwitterPublisher implements SocialPublisher{

    public String share() {
        return "publicate on Twitter";
    }
}
