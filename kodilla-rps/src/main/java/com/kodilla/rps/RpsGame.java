package com.kodilla.rps;

import java.util.Random;
import java.util.Scanner;

public class RpsGame {

    Scanner scanner = new Scanner(System.in);
    Random random = new Random();
    private String computerChoiceString;
    String yesOrNot;
    private boolean end = false;
    private RpsWelcomeScreen rpsWelcomeScreen = new RpsWelcomeScreen();
    private RpsResults rpsResults = new RpsResults();

    public RpsGame() {
        rpsWelcomeScreen.userName();
        game();
    }

    public void setEnd(boolean end) {
        this.end = end;
    }

    public void game() {

        while (!end) {
            System.out.println("\nklawisz 1 - kamień");
            System.out.println("klawisz 2 - jaszczurka");
            System.out.println("klawisz 3 - Spock");
            System.out.println("klawisz 4 - nożyce");
            System.out.println("klawisz 5 - papier");
            System.out.println("\nklawisz x - koniec gry");
            System.out.println("klawisz n - nowa gra\n");

            System.out.print("Wybierz swoj ruch: ");
            String userChoice = scanner.nextLine();

            switch (userChoice) {
                case "1":
                    System.out.print("Wybrałeś kamień a ");
                    computerMove();
                    rpsResults.resultChoice(userChoice, computerChoiceString);
                    break;
                case "2":
                    System.out.print("Wybrałeś jaszurkę a ");
                    computerMove();
                    rpsResults.resultChoice(userChoice, computerChoiceString);
                    break;
                case "3":
                    System.out.print("Wybrałeś Spocka a ");
                    computerMove();
                    rpsResults.resultChoice(userChoice, computerChoiceString);
                    break;
                case "4":
                    System.out.print("Wybrałeś nożyce a ");
                    computerMove();
                    rpsResults.resultChoice(userChoice, computerChoiceString);
                    break;
                case "5":
                    System.out.print("Wybrałeś papier a ");
                    computerMove();
                    rpsResults.resultChoice(userChoice, computerChoiceString);
                    break;
                case "x":
                    System.out.print("Czy napewno zakończyć grę t/n ");
                    do {
                        yesOrNot = scanner.nextLine();
                        if (yesOrNot.equals("t")) {
                            end = true;
                        } else if (yesOrNot.equals("n")) {
                            game();
                        } else {
                            System.out.print("t/n ? ");
                        }
                    } while (!yesOrNot.equals("t") && !yesOrNot.equals("n"));
                    break;
                case "n":
                    System.out.print("Czy napewno zakończyć aktualną grę i zacząć nową t/n ");
                    do {
                        yesOrNot = scanner.nextLine();
                        if (yesOrNot.equals("t")) {
                            rpsWelcomeScreen.userName();
                        } else if (yesOrNot.equals("n")) {
                            game();
                        } else {
                            System.out.print("t/n ? ");
                        }
                    } while (!yesOrNot.equals("t") && !yesOrNot.equals("n"));
                    break;
                default:
                    System.out.println("Niepoprawny wybór");
                    break;
            }
        }
    }

    public void computerMove() {
        int computerChoice = random.nextInt(1,5);
        switch (computerChoice) {
            case 1:
                System.out.println("komputer wybrał kamień");
                break;
            case 2:
                System.out.println("komputer wybrał jaszurkę");
                break;
            case 3:
                System.out.println("komputer wybrał Spocka");
                break;
            case 4:
                System.out.println("komputer wybrał nożyce");
                break;
            case 5:
                System.out.println("komputer wybrał papier");
                break;
        }
        computerChoiceString = Integer.toString(computerChoice);
    }
}
