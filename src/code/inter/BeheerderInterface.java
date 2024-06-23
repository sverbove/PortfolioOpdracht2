package code.inter;

import code.model.Beheerder;
import code.service.AZCService;
import code.utility.Utility;
import java.util.Scanner;

public class BeheerderInterface {
    private final Beheerder beheerder;
    private final AZCService azcService;

    public BeheerderInterface(Beheerder beheerder, AZCService azcService) {
        this.beheerder = beheerder;
        this.azcService = azcService;
    }

    public void run(Scanner scanner) {
        boolean keepRunning = true;
        while (keepRunning) {
            System.out.println("Kies een actie: \n1. Voeg land toe\n2. Wijzig veiligheid van een land\n3. Beheer gemeente\n4. Beheer AZC\n5. Rapporteer uitkeringen\n6. Terug");
            int choice = Utility.readIntFromUser(scanner);
            keepRunning = handleBeheerderOptions(scanner, choice);
        }
    }

    private boolean handleBeheerderOptions(Scanner scanner, int choice) {
        switch (choice) {
            case 1 -> addCountry(scanner);
            case 2 -> changeCountrySafety(scanner);
            case 3 -> manageGemeente(scanner);
            case 4 -> manageAZC(scanner);
            case 5 -> beheerder.rapportageUitkeringen();
            case 6 -> {
                return false;
            }
            default -> System.out.println("Ongeldige keuze.");
        }
        return true;
    }

    private void addCountry(Scanner scanner) {
        String naam = Utility.readStringFromUser(scanner, "Geef de naam van het land: ");
        boolean isVeilig = Utility.readBooleanFromUser(scanner, "Is het land veilig? (ja/nee): ");
        beheerder.voegLandToe(naam, isVeilig);
    }

    private void changeCountrySafety(Scanner scanner) {
        String naam = Utility.readStringFromUser(scanner, "Voer de naam van het land in waarvan je de veiligheid wilt wijzigen: ");
        boolean nieuweVeiligheid = Utility.readBooleanFromUser(scanner, "Is het land nu veilig? (ja/nee): ");
        beheerder.wijzigVeiligheidLand(naam, nieuweVeiligheid);
    }

    private void manageGemeente(Scanner scanner) {
        System.out.println("Beheer Gemeente: kies een optie:\n1. Voeg Gemeente toe\n2. Verwijder Gemeente\n3. Terug");
        int keuze = Utility.readIntFromUser(scanner);
        switch (keuze) {
            case 1 -> {
                String naam = Utility.readStringFromUser(scanner, "Voer de naam van de gemeente in: ");
                int aantalInwoners = Utility.readIntFromUser(scanner, "Voer het aantal inwoners van de gemeente in: ");
                beheerder.voegGemeenteToe(naam, aantalInwoners);
            }
            case 2 -> {
                String naam = Utility.readStringFromUser(scanner, "Voer de naam van de gemeente in om te verwijderen: ");
                beheerder.verwijderGemeente(naam);
            }
            case 3 -> {}
            default -> System.out.println("Ongeldige keuze.");
        }
    }

    private void manageAZC(Scanner scanner) {
        System.out.println("Beheer AZC: kies een optie:\n1. Voeg AZC toe\n2. Verwijder AZC\n3. Wijzig AZC\n4. Terug");
        int keuze = Utility.readIntFromUser(scanner);
        switch (keuze) {
            case 1 -> {
                String naam = Utility.readStringFromUser(scanner, "Voer de naam van het AZC in: ");
                String locatie = Utility.readStringFromUser(scanner, "Voer de locatie van het AZC in: ");
                azcService.voegAZCToe(naam, locatie);
            }
            case 2 -> {
                String naam = Utility.readStringFromUser(scanner, "Voer de naam van het AZC in om te verwijderen: ");
                azcService.verwijderAZC(naam);
            }
            case 3 -> {
                String huidigeNaam = Utility.readStringFromUser(scanner, "Voer de naam van het AZC in om te wijzigen: ");
                String nieuweNaam = Utility.readStringFromUser(scanner, "Voer de nieuwe naam van het AZC in: ");
                String nieuweLocatie = Utility.readStringFromUser(scanner, "Voer de nieuwe locatie van het AZC in: ");
                azcService.wijzigAZC(huidigeNaam, nieuweNaam, nieuweLocatie);
            }
            case 4 -> {}
            default -> System.out.println("Ongeldige keuze.");
        }
    }
}
