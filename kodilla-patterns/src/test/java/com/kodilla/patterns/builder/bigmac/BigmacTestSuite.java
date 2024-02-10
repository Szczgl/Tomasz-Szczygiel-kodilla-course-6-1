package com.kodilla.patterns.builder.bigmac;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BigmacTestSuite {

    @Test
    void testBigmacNew() {
        //Given
        Bigmac bigmac = new Bigmac.BigmacBuilder()
                .bun(Bun.ROLL)
                .burgers(2)
                .sauce(Sauce.BARBECUE)
                .ingredients(Ingredients.BACON)
                .ingredients(Ingredients.MUSHROOMS)
                .ingredients(Ingredients.CHEESE)
                .build();
        System.out.println(bigmac);

        //When
        int howManyIngredients = bigmac.getIngredients().size();

        //Then
        assertEquals(3, howManyIngredients );
        assertEquals(Bun.ROLL, bigmac.getBun());
        assertEquals(2, bigmac.getBurgers());
        assertNotEquals(Sauce.STANDARD, bigmac.getSauce());
        assertTrue(bigmac.getIngredients().contains("cheese"));
        assertTrue(bigmac.getIngredients().contains("bacon"));
    }
}
