package com.kodilla.testing;

import com.kodilla.testing.user.SimpleUser;
import com.kodilla.testing.calculator.Calculator;

public class TestingMain {
    public static void main(String[] args) {
        System.out.println("Moduł 6. Wprowadzenie do testowania oprogramowania");

        SimpleUser simpleUser = new SimpleUser("theForumUser");

        String result = simpleUser.getUsername();

        if (result.equals("theForumUser")) {
            System.out.println("test OK");
        } else {
            System.out.println("Error!");
        }

        System.out.println("Test - pierwszy test jednostkowy:");
        Calculator calculator = new Calculator(5,4);
        int addResoult = calculator.add();
        int substractResoult = calculator.substract();

        if (addResoult == 9) {
            System.out.println("test OK");
        } else {
            System.out.println("Error!");
        }
        if (substractResoult == 1) {
            System.out.println("test OK");
        } else {
            System.out.println("Error!");
        }
    }
}
