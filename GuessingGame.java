package at.bfi.guessing;

import java.util.Scanner;

public class GuessingGame {

    public static void main(String[] args) {

        String weiterSpielen = "j";

        do {
            System.out.println(
                    "\n\nWillkommen zu diesem Spiel.\n\nIch werde mir eine Zufallszahl zwischen 1 und 100 ausdenken. Bitte erraten Sie die Zahl!");

            playGame();

            System.out.print("\nWollen Sie noch einmal spielen? (j/n)");

            Scanner scanner = new Scanner(System.in);
            weiterSpielen = scanner.nextLine();

        } while (weiterSpielen.equalsIgnoreCase("j"));

        System.out.print("\nAuf wiedersehen!");
    }

    private static void playGame() {
        boolean spielEnde = false;
        int zufallsZahl = generateRandomNumber();
        int versuche = 0;

        do {
            int benutzerEingabe = getUserInput();
            versuche++;

            spielEnde = compareNumbers(zufallsZahl, benutzerEingabe);
        } while (!spielEnde);

        System.out.println("\nSie haben in " + versuche + " Versuchen gewonnen!");

    }

    private static int getUserInput() {
        System.out.print("\nGeben Sie eine Zahl zwischen 1 und 100 ein: ");

        Scanner scanner = new Scanner(System.in);
        int benutzerEingabe = scanner.nextInt();

        return benutzerEingabe;
    }

    private static int generateRandomNumber() {
        int rndNum = 1 + (int) (Math.random() * 100);

        return rndNum;
    }

    private static boolean compareNumbers(int rndNum, int input) {

        if (rndNum < input) {
            System.out.println("Ihre eingebene Zahl ist GRÖSSER als die Zufallszahl.");
        }
        if (rndNum > input) {
            System.out.println("Ihre eingebene Zahl ist KLEINER als die Zufallszahl.");
        }
        if (rndNum == input) {
            System.out.println("Sie haben die Zufallszahl " + rndNum + " erraten.");
            return true;
        }

        return false;
    }

}
