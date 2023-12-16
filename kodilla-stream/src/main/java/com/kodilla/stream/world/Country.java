package com.kodilla.stream.world;

import java.math.BigDecimal;

public class Country {

    private final String name;

    private final BigDecimal population;

    public Country(final String name, final BigDecimal population) {
        this.name = name;
        this.population = population;
    }

    public BigDecimal getPeopleQuantity() {
        return population;
    }

    public String getName() {
        return name;
    }

    public BigDecimal getPopulation() {
        return population;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (!(object instanceof Country country)) return false;

        return getName().equals(country.getName());
    }
}

