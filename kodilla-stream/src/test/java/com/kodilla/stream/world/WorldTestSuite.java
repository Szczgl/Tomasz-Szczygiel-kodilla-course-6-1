package com.kodilla.stream.world;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WorldTestSuite {

    @Test
    void testGetPeopleQuantity() {
        //Given
        Country poland = new Country("Poland", new BigDecimal("100000000"));
        Country germany = new Country("Germany", new BigDecimal("200000000"));
        Country england = new Country("England", new BigDecimal("300000000"));
        Country india = new Country("India", new BigDecimal("400000000"));
        Country china = new Country("China", new BigDecimal("500000000"));
        Country japan = new Country("Japan", new BigDecimal("600000000"));
        Country kenya = new Country("Kenya", new BigDecimal("700000000"));
        Country egypt = new Country("Egypt", new BigDecimal("800000000"));
        Country sudan = new Country("Sudan", new BigDecimal("900000000"));

        Continent europa = new Continent("Europa");
        europa.addCountry(poland);
        europa.addCountry(germany);
        europa.addCountry(england);
        Continent asia = new Continent("Asia");
        asia.addCountry(india);
        asia.addCountry(china);
        asia.addCountry(japan);
        Continent africa = new Continent("Africa");
        africa.addCountry(kenya);
        africa.addCountry(egypt);
        africa.addCountry(sudan);
        World world = new World();
        world.addContinent(europa);
        world.addContinent(asia);
        world.addContinent(africa);

        //When
        BigDecimal populationOfWorld = world.getPeopleQuantity();

        //Then
        BigDecimal expectedPopulation = new BigDecimal("4500000000");
        assertEquals(expectedPopulation,populationOfWorld);





    }
}
