package com.kodilla.patterns2.decorator.pizza;

import org.junit.jupiter.api.Test;
import java.math.BigDecimal;
import static org.junit.jupiter.api.Assertions.*;

public class PizzaOrderTestSuite {

    @Test
    public void testMargheritaPlusPepperoni() {

        //GIVEN
        Pizza pizza = new Margherita();
        pizza = new Pepperoni(pizza);
        System.out.println(pizza.getCost());
        System.out.println(pizza.getDescription());

        //WHEN
        BigDecimal pizzaCost = pizza.getCost();
        String pizzaDescription = pizza.getDescription();

        //THEN
        assertEquals(new BigDecimal(30), pizzaCost);
        assertEquals("Pizza: tomato sauce + cheese, pepperoni", pizzaDescription);
    }

    @Test
    public void testMargheritaPlusPepperoniPlusMushroomsPlusHotPepper() {

        //GIVEN
        Pizza pizza = new Margherita();
        pizza = new Pepperoni(pizza);
        pizza = new Mushrooms(pizza);
        pizza = new HotPepper(pizza);

        System.out.println(pizza.getCost());
        System.out.println(pizza.getDescription());

        //WHEN
        BigDecimal pizzaCost = pizza.getCost();
        String pizzaDescription = pizza.getDescription();

        //THEN
        assertEquals(new BigDecimal(36), pizzaCost);
        assertEquals("Pizza: tomato sauce + cheese, pepperoni, mushrooms, hot pepper", pizzaDescription);
    }
}
