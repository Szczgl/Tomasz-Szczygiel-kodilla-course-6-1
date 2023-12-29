package com.kodilla.rps;

public class RpsResults {

    private int resultUser;
    private int resultComputer;

    private RpsWelcomeScreen rpsWelcomeScreen = new RpsWelcomeScreen();
    private RpsGame rpsGame = new RpsGame();
    public void resultChoice(String userChoice, String computerChoiceString) {
        if (userChoice.equals(computerChoiceString)) {
            System.out.println("Remis");
        } else if ((userChoice.equals("1") && ((computerChoiceString.equals("2") || computerChoiceString.equals("4"))))
                || (userChoice.equals("2") && ((computerChoiceString.equals("3") || computerChoiceString.equals("5"))))
                || (userChoice.equals("3") && ((computerChoiceString.equals("1") || computerChoiceString.equals("4"))))
                || (userChoice.equals("4") && ((computerChoiceString.equals("2") || computerChoiceString.equals("5"))))
                || (userChoice.equals("5") && ((computerChoiceString.equals("1") || computerChoiceString.equals("3"))))) {
            System.out.println(rpsWelcomeScreen.getUserName() + "wygrywa rundę");
            resultUser++;
        } else {
            System.out.println("Komputer wygrywa rundę");
            resultComputer++;
        }

        System.out.println("Aktualny wynik (" + rpsWelcomeScreen.getUserName() + ", Komputer): " + resultUser + ":" + resultComputer);
        System.out.println();
        if (rpsWelcomeScreen.getNumberOfWin() == resultUser || rpsWelcomeScreen.getNumberOfWin() == resultComputer) {
            if (resultUser > resultComputer) {
                System.out.println("Grę wygrywa " + rpsWelcomeScreen.getUserName() + " wynikiem " + resultUser + ":" + resultComputer);
            } else {
                System.out.println("Grę wygrywa komputer wynikiem " + resultComputer + ":" + resultUser);
            }
            rpsGame.setEnd(true);
        }
    }
}
