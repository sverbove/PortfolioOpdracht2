package code.inter;

import code.utility.Utility;
import code.model.Vluchteling;
import code.main.Main;
import java.util.Scanner;

public class VluchtelingInterface {
    public void run(Scanner scanner) {
        String naam = Utility.readStringFromUser(scanner, "Voer uw naam in:");
        Vluchteling vluchteling = Main.coaMedewerker.zoekVluchteling(naam);
        if (vluchteling != null) {
            boolean blijven = true;
            while (blijven) {
                System.out.println("Kies een optie:");
                System.out.println("1: Eigen gegevens opvragen");
                System.out.println("2: Status van dossier opvragen");
                if (vluchteling.getDossier().getStatus().getRechterUitspraak().equals("geaccepteerd") && vluchteling.getDossier().getPlaatsingInEigenWoning().equals("gestart")) {
                    System.out.println("3: Adres registreren");
                }
                System.out.println("0: Terug naar hoofdmenu");

                int keuze = Utility.readIntFromUser(scanner);
                blijven = handleVluchtelingOptions(scanner, vluchteling, keuze);
            }
        } else {
            System.out.println("Vluchteling niet gevonden.");
        }
    }

    private boolean handleVluchtelingOptions(Scanner scanner, Vluchteling vluchteling, int keuze) {
        switch (keuze) {
            case 1 -> vluchteling.toonGeregistreerdeGegevens();
            case 2 -> vluchteling.toonStatusDossier();
            case 3 -> {
                if (vluchteling.getDossier().getStatus().getRechterUitspraak().equals("geaccepteerd") && vluchteling.getDossier().getPlaatsingInEigenWoning().equals("gestart")) {
                    String nieuwAdres = Utility.readStringFromUser(scanner, "Voer uw nieuwe adres in:");
                    vluchteling.registreerAdres(nieuwAdres);
                } else {
                    System.out.println("Uw asielaanvraag is nog niet geaccepteerd of plaatsing is niet gestart.");
                }
            }
            case 0 -> {
                return false;
            }
            default -> System.out.println("Ongeldige keuze, probeer opnieuw.");
        }
        return true;
    }
}
