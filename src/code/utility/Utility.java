package code.utility;

import java.util.Scanner;

public class Utility {

    public static int readIntFromUser(Scanner scanner) {
        while (true) {
            try {
                return Integer.parseInt(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Ongeldige invoer. Voer alstublieft een geldig nummer in. ");
            }
        }
    }

    public static int readIntFromUser(Scanner scanner, String prompt) {
        System.out.print(prompt);
        while (true) {
            try {
                return Integer.parseInt(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Ongeldige invoer. Voer alstublieft een geldig nummer in.");
            }
        }
    }

    public static String readStringFromUser(Scanner scanner, String prompt) {
        System.out.print(prompt);
        return scanner.nextLine().trim();
    }

    public static boolean readBooleanFromUser(Scanner scanner, String prompt) {
        while (true) {
            System.out.print(prompt);
            String input = scanner.nextLine().trim();
            if (input.equalsIgnoreCase("ja")) {
                return true;
            } else if (input.equalsIgnoreCase("nee")) {
                return false;
            } else {
                System.out.println("Ongeldige invoer. Voer alstublieft 'ja' of 'nee' in.");
            }
        }
    }
}
