package code.inter;

import code.utility.Utility;
import code.model.COAMedewerker;
import code.model.Vluchteling;
import code.model.AZC;
import code.model.Status;
import code.main.Main;
import java.util.Scanner;

public class COAMedewerkerInterface {
    private final COAMedewerker coaMedewerker;

    public COAMedewerkerInterface(COAMedewerker coaMedewerker) {
        this.coaMedewerker = coaMedewerker;
    }

    public void run(Scanner scanner) {
        boolean keepRunning = true;
        while (keepRunning) {
            System.out.println("Kies een actie: \n1. Registreer Vluchteling\n2. Plaats Vluchteling\n3. Werk Dossier Bij\n4. Terug");
            int choice = Utility.readIntFromUser(scanner);
            keepRunning = handleCoaMedewerkerOptions(scanner, choice);
        }
    }

    private boolean handleCoaMedewerkerOptions(Scanner scanner, int choice) {
        switch (choice) {
            case 1 -> registerVluchteling(scanner);
            case 2 -> plaatsVluchteling(scanner);
            case 3 -> updateDossier(scanner);
            case 4 -> {
                return false;
            }
            default -> System.out.println("Ongeldige keuze.");
        }
        return true;
    }

    private void registerVluchteling(Scanner scanner) {
        String naam = Utility.readStringFromUser(scanner, "Naam van de vluchteling: ");
        String landVanHerkomst = Utility.readStringFromUser(scanner, "Land van herkomst: ");
        boolean paspoortGetoond = Utility.readBooleanFromUser(scanner, "Paspoort getoond? (ja/nee): ");
        coaMedewerker.registreerVluchteling(naam, landVanHerkomst, paspoortGetoond);
    }

    private void plaatsVluchteling(Scanner scanner) {
        String naamPlaatsing = Utility.readStringFromUser(scanner, "Naam van de vluchteling voor plaatsing: ");
        String azcNaam = Utility.readStringFromUser(scanner, "Naam van het AZC waar de vluchteling geplaatst moet worden: ");
        AZC azc = Main.azcs.stream()
                .filter(a -> a.getNaam().equals(azcNaam))
                .findFirst()
                .orElse(null);
        if (azc != null && azc.heeftRuimte()) {
            Vluchteling vluchteling = coaMedewerker.zoekVluchteling(naamPlaatsing);
            if (vluchteling != null) {
                azc.voegVluchtelingToe(vluchteling);
                System.out.println("Vluchteling " + vluchteling.getNaam() + " is geplaatst in " + azcNaam);
                azc.notifyObservers("Vluchteling " + vluchteling.getNaam() + " is geplaatst in " + azcNaam);
            } else {
                System.out.println("Vluchteling niet gevonden: " + naamPlaatsing);
            }
        } else {
            System.out.println("Geen ruimte beschikbaar in " + azcNaam + " of AZC niet gevonden.");
        }
    }

    private void updateDossier(Scanner scanner) {
        String naam = Utility.readStringFromUser(scanner, "Naam van de vluchteling wiens dossier bijgewerkt moet worden: ");
        boolean paspoortGetoond = Utility.readBooleanFromUser(scanner, "Paspoort getoond? (ja/nee): ");
        boolean asielaanvraagCompleet = Utility.readBooleanFromUser(scanner, "Asielaanvraag compleet? (ja/nee): ");
        boolean rechterToegewezen = Utility.readBooleanFromUser(scanner, "Rechter toegewezen? (ja/nee): ");
        boolean rechterHeeftUitspraak = Utility.readBooleanFromUser(scanner, "Heeft de rechter een uitspraak gedaan? (ja/nee): ");
        String rechterUitspraak = Utility.readStringFromUser(scanner, "Uitspraak van de rechter: ");
        boolean isTeruggekeerd = Utility.readBooleanFromUser(scanner, "Is de vluchteling teruggekeerd naar het land van herkomst? (ja/nee): ");

        Status status = new Status(paspoortGetoond, asielaanvraagCompleet, rechterToegewezen, rechterHeeftUitspraak, rechterUitspraak, isTeruggekeerd);
        String plaatsingInEigenWoning = Utility.readStringFromUser(scanner, "Status van plaatsing in eigen woning: ");

        coaMedewerker.updateDossier(naam, status, plaatsingInEigenWoning);
    }
}
