import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    static Beheerder beheerder = new Beheerder();
    static ArrayList<AZC> azcs = new ArrayList<>();
    static COAMedewerker coaMedewerker = new COAMedewerker(azcs);

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("Kies je rol: \n1. Beheerder\n2. COA-medewerker\n3. Vluchteling\n4. Exit");
            int roleChoice = readIntFromUser(scanner);

            switch (roleChoice) {
                case 1:
                    beheerderInterface(scanner);
                    break;
                case 2:
                    coaMedewerkerInterface(scanner);
                    break;
                case 3:
                    vluchtelingInterface(scanner);
                    break;
                case 4:
                    running = false;
                    break;
                default:
                    System.out.println("Ongeldige keuze.");
                    break;
            }
        }

        scanner.close();
    }

    private static int readIntFromUser(Scanner scanner) {
        while (true) {
            String input = scanner.nextLine();
            try {
                return Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("Ongeldige invoer. Voer alstublieft een geldig nummer in.");
            }
        }
    }

    private static void vluchtelingInterface(Scanner scanner) {
        System.out.println("Voer uw naam in:");
        String naam = scanner.nextLine();
        Vluchteling vluchteling = coaMedewerker.zoekVluchteling(naam);
        if (vluchteling != null) {
            boolean blijven = true;
            while (blijven) {
                System.out.println("Kies een optie:");
                System.out.println("1: Eigen gegevens opvragen");
                System.out.println("2: Status van dossier opvragen");
                if (vluchteling.getDossier().getRechterUitspraak().equals("geaccepteerd") && vluchteling.getDossier().getPlaatsingInEigenWoning().equals("gestart")) {
                    System.out.println("3: Adres registreren");
                }
                System.out.println("0: Terug naar hoofdmenu");

                int keuze = Integer.parseInt(scanner.nextLine());
                switch (keuze) {
                    case 1:
                        vluchteling.toonGeregistreerdeGegevens();
                        break;
                    case 2:
                        vluchteling.toonStatusDossier();
                        break;
                    case 3:
                        if (vluchteling.getDossier().getRechterUitspraak().equals("geaccepteerd") && vluchteling.getDossier().getPlaatsingInEigenWoning().equals("gestart")) {
                            System.out.println("Voer uw nieuwe adres in:");
                            String nieuwAdres = scanner.nextLine();
                            vluchteling.registreerAdres(nieuwAdres);
                        } else {
                            System.out.println("Uw asielaanvraag is nog niet geaccepteerd of plaatsing is niet gestart.");
                        }
                        break;
                    case 0:
                        blijven = false;
                        break;
                    default:
                        System.out.println("Ongeldige keuze, probeer opnieuw.");
                        break;
                }
            }
        } else {
            System.out.println("Vluchteling niet gevonden.");
        }
    }


    private static void beheerderInterface(Scanner scanner) {
        boolean keepRunning = true;
        while (keepRunning) {
            System.out.println("Kies een actie: \n1. Voeg land toe\n2. Wijzig veiligheid van een land\n3. Beheer gemeente\n4. Beheer AZC\n5. Rapporteer uitkeringen\n6. Terug");
            int choice = readIntFromUser(scanner);
            switch (choice) {
                case 1:
                    addCountry(scanner);
                    break;
                case 2:
                    changeCountrySafety(scanner);
                    break;
                case 3:
                    manageGemeente(scanner);
                    break;
                case 4:
                    manageAZC(scanner);
                    break;
                case 5:
                    beheerder.rapportageUitkeringen();
                    break;
                case 6:
                    keepRunning = false;
                    break;
                default:
                    System.out.println("Ongeldige keuze.");
                    break;
            }
        }
    }

    private static void manageAZC(Scanner scanner) {
    }

    private static void manageGemeente(Scanner scanner) {
    }

    private static void addCountry(Scanner scanner) {
        System.out.println("Geef de naam van het land:");
        String naam = scanner.nextLine();
        System.out.println("Is het land veilig? (ja/nee):");
        boolean isVeilig = scanner.nextLine().trim().equalsIgnoreCase("ja");
        beheerder.voegLandToe(naam, isVeilig);
    }

    private static void changeCountrySafety(Scanner scanner) {
        System.out.println("Voer de naam van het land in waarvan je de veiligheid wilt wijzigen:");
        String naam = scanner.nextLine();
        System.out.println("Is het land nu veilig? (ja/nee):");
        boolean nieuweVeiligheid = scanner.nextLine().trim().equalsIgnoreCase("ja");
        beheerder.wijzigVeiligheidLand(naam, nieuweVeiligheid);
    }

    private static void coaMedewerkerInterface(Scanner scanner) {
        boolean keepRunning = true;
        while (keepRunning) {
            System.out.println("Kies een actie: \n1. Registreer Vluchteling\n2. Plaats Vluchteling\n3. Werk Dossier Bij\n4. Terug");
            int choice = readIntFromUser(scanner);
            switch (choice) {
                case 1:
                    registerVluchteling(scanner);
                    break;
                case 2:
                    plaatsVluchteling(scanner);
                    break;
                case 3:
                    updateDossier(scanner);
                    break;
                case 4:
                    keepRunning = false;
                    break;
                default:
                    System.out.println("Ongeldige keuze.");
                    break;
            }
        }
    }

    private static void registerVluchteling(Scanner scanner) {
        System.out.println("Naam van de vluchteling:");
        String naam = scanner.nextLine();
        System.out.println("Land van herkomst:");
        String landVanHerkomst = scanner.nextLine();
        System.out.println("Is het paspoort getoond? (ja/nee):");
        boolean paspoortGetoond = scanner.nextLine().trim().equalsIgnoreCase("ja");
        coaMedewerker.registreerVluchteling(naam, landVanHerkomst, paspoortGetoond);
    }

    private static void updateDossier(Scanner scanner) {
        System.out.println("Naam van de vluchteling wiens dossier bijgewerkt moet worden:");
        String naam = scanner.nextLine();
        System.out.println("Paspoort getoond? (ja/nee):");
        boolean paspoortGetoond = scanner.nextLine().trim().equalsIgnoreCase("ja");
        System.out.println("Asielaanvraag compleet? (ja/nee):");
        boolean asielaanvraagCompleet = scanner.nextLine().trim().equalsIgnoreCase("ja");
        System.out.println("Rechter toegewezen? (ja/nee):");
        boolean rechterToegewezen = scanner.nextLine().trim().equalsIgnoreCase("ja");
        System.out.println("Heeft de rechter een uitspraak gedaan? (ja/nee):");
        boolean rechterHeeftUitspraak = scanner.nextLine().trim().equalsIgnoreCase("ja");
        System.out.println("Uitspraak van de rechter:");
        String rechterUitspraak = scanner.nextLine();
        System.out.println("Is de vluchteling teruggekeerd naar het land van herkomst? (ja/nee):");
        boolean isTeruggekeerd = scanner.nextLine().trim().equalsIgnoreCase("ja");
        coaMedewerker.updateDossier(naam, paspoortGetoond, asielaanvraagCompleet, rechterToegewezen, rechterHeeftUitspraak, rechterUitspraak, isTeruggekeerd);
    }

    private static void plaatsVluchteling(Scanner scanner) {
        System.out.println("Naam van de vluchteling voor plaatsing:");
        String naamPlaatsing = scanner.nextLine();
        System.out.println("Gemeente waar de vluchteling geplaatst moet worden:");
        String gemeente = scanner.nextLine();
        coaMedewerker.plaatsVluchteling(naamPlaatsing, gemeente);
    }
}
