package com.kodilla.exception.test;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SecondChallengeTestSuits {

    @Test
    void probablyIWillThrowException() {
        // given
        SecondChallenge secondChallenge = new SecondChallenge();

        // when & then
        assertAll(
                () -> assertThrows(Exception.class, () -> secondChallenge.probablyIWillThrowException(1.0,1.5)),
                () -> assertThrows(Exception.class, () -> secondChallenge.probablyIWillThrowException(0.9,1.6)),
                () -> assertThrows(Exception.class, () -> secondChallenge.probablyIWillThrowException(2.0,1.6)),
                () -> assertDoesNotThrow(() -> secondChallenge.probablyIWillThrowException(1.0,1.6))
        );
    }

}