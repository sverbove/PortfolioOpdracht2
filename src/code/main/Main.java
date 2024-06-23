package code.main;

import code.model.AZC;
import code.model.Gemeente;
import code.service.AZCService;
import code.model.COAMedewerker;
import code.inter.BeheerderInterface;
import code.inter.COAMedewerkerInterface;
import code.inter.VluchtelingInterface;
import code.utility.Utility;
import java.util.Scanner;
import java.util.ArrayList;
import code.model.Beheerder;

public class Main {
    public static ArrayList<AZC> azcs = new ArrayList<>();
    public static Gemeente denHaag = new Gemeente("Den Haag");
    public static Beheerder beheerder = new Beheerder("Alice");
    public static AZCService azcService = new AZCService(azcs);
    public static COAMedewerker coaMedewerker = new COAMedewerker.Builder("Bob")
            .setAzcs(azcs)
            .build();

    public static void main(String[] args) {
        initializeData();
        runMainMenu();
    }

    private static void initializeData() {
        // Voeg bestaande gemeente Den Haag en AZC "DH1" toe
        AZC dh1 = new AZC("DH1", "Den Haag");
        dh1.voegObserverToe(denHaag);
        azcs.add(dh1);
    }

    private static void runMainMenu() {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("Kies je rol: \n1. Beheerder\n2. COA-medewerker\n3. Vluchteling\n4. Exit");
            int roleChoice = Utility.readIntFromUser(scanner);

            switch (roleChoice) {
                case 1 -> {
                    BeheerderInterface beheerderInterface = new BeheerderInterface(beheerder, azcService);
                    beheerderInterface.run(scanner);
                }
                case 2 -> {
                    COAMedewerkerInterface coaMedewerkerInterface = new COAMedewerkerInterface(coaMedewerker);
                    coaMedewerkerInterface.run(scanner);
                }
                case 3 -> {
                    VluchtelingInterface vluchtelingInterface = new VluchtelingInterface();
                    vluchtelingInterface.run(scanner);
                }
                case 4 -> running = false;
                default -> System.out.println("Ongeldige keuze.");
            }
        }

        scanner.close();
    }
}
