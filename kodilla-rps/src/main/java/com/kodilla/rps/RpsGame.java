package com.kodilla.rps;

import java.util.Random;
import java.util.Scanner;

public class RpsGame {

    Scanner scanner = new Scanner(System.in);
    Random random = new Random();
    private String computerChoiceString;
    private int resultUser = 0;
    private int resultComputer = 0;
    private String userName;
    private int numberOfWin;
    private String yesOrNot;
    private boolean end = false;

    public RpsGame() {
        userName();
    }

    public void userName() {
        System.out.println("\nGra w papier, nożyce, kamień, jaszczurke, Spocka\n");
        System.out.print("Podaj swoje imie: ");
        userName = scanner.nextLine();
        System.out.println("\nWitaj " + userName + "\n");
        numberOfWin();
    }

    public void numberOfWin() {
        System.out.print("Podaj do ilu wygranych gramy: ");
        numberOfWin = scanner.nextInt();
        scanner.nextLine();
        System.out.println("OK " + userName + " gramy do " + numberOfWin + " wygranych");
        game();
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
                    resultChoice(userChoice, computerChoiceString);
                    break;
                case "2":
                    System.out.print("Wybrałeś jaszurkę a ");
                    computerMove();
                    resultChoice(userChoice, computerChoiceString);
                    break;
                case "3":
                    System.out.print("Wybrałeś Spocka a ");
                    computerMove();
                    resultChoice(userChoice, computerChoiceString);
                    break;
                case "4":
                    System.out.print("Wybrałeś nożyce a ");
                    computerMove();
                    resultChoice(userChoice, computerChoiceString);
                    break;
                case "5":
                    System.out.print("Wybrałeś papier a ");
                    computerMove();
                    resultChoice(userChoice, computerChoiceString);
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
                            resultUser = 0;
                            resultComputer = 0;
                            userName();
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
    public void resultChoice(String userChoice, String computerChoiceString) {
        if (userChoice.equals(computerChoiceString)) {
            System.out.println("Remis");
        } else if ((userChoice.equals("1") && ((computerChoiceString.equals("2") || computerChoiceString.equals("4"))))
            || (userChoice.equals("2") && ((computerChoiceString.equals("3") || computerChoiceString.equals("5"))))
            || (userChoice.equals("3") && ((computerChoiceString.equals("1") || computerChoiceString.equals("4"))))
            || (userChoice.equals("4") && ((computerChoiceString.equals("2") || computerChoiceString.equals("5"))))
            || (userChoice.equals("5") && ((computerChoiceString.equals("1") || computerChoiceString.equals("3"))))) {
            System.out.println(userName + "wygrywa rundę");
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
