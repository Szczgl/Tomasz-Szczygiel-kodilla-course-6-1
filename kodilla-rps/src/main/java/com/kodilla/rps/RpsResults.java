package com.kodilla.rps;


public class RpsResults {

    private int resultUser;
    private int resultComputer;
    private final String userName;
    private final int numberOfWin;
    public boolean end = false;

    public RpsResults(final String userName, final int numberOfWin) {
        this.userName = userName;
        this.numberOfWin = numberOfWin;
    }

    public void setResultUser(int resultUser) {
        this.resultUser = resultUser;
    }

    public void setResultComputer(int resultComputer) {
        this.resultComputer = resultComputer;
    }

    public void resultChoice(String userChoice, String computerChoiceString) {

        if (userChoice.equals(computerChoiceString)) {
            System.out.println("Remis");
        } else if ((userChoice.equals("1") && ((computerChoiceString.equals("2") || computerChoiceString.equals("4"))))
                || (userChoice.equals("2") && ((computerChoiceString.equals("3") || computerChoiceString.equals("5"))))
                || (userChoice.equals("3") && ((computerChoiceString.equals("1") || computerChoiceString.equals("4"))))
                || (userChoice.equals("4") && ((computerChoiceString.equals("2") || computerChoiceString.equals("5"))))
                || (userChoice.equals("5") && ((computerChoiceString.equals("1") || computerChoiceString.equals("3"))))) {
            System.out.println(userName + " wygrywa rundę");
            resultUser++;
        } else {
            System.out.println("Komputer wygrywa rundę");
            resultComputer++;
        }

        System.out.println("Aktualny wynik (" + userName + ", Komputer): " + resultUser + ":" + resultComputer);
        System.out.println();
        if (numberOfWin == resultUser || numberOfWin == resultComputer) {
            if (resultUser > resultComputer) {
                System.out.println("Grę wygrywa " + userName + " wynikiem " + resultUser + ":" + resultComputer);
            } else {
                System.out.println("Grę wygrywa komputer wynikiem " + resultComputer + ":" + resultUser);
            }
            end = true;
        }
    }
}
