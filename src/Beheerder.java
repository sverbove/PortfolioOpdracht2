import java.util.ArrayList;

public class Beheerder {
    private ArrayList<Land> landen = new ArrayList<>();
    private ArrayList<Gemeente> gemeentes = new ArrayList<>();
    private ArrayList<AZC> azcs = new ArrayList<>();

    public void voegLandToe(String naam, boolean isVeilig) {
        landen.add(new Land(naam, isVeilig));
        System.out.println("Land toegevoegd: " + naam);
    }

    public void wijzigVeiligheidLand(String naam, boolean nieuweVeiligheid) {
        for (Land land : landen) {
            if (land.getNaam().equals(naam)) {
                land.setIsVeilig(nieuweVeiligheid);
                System.out.println("Veiligheidsstatus van land " + naam + " is bijgewerkt.");
                return;
            }
        }
        System.out.println("Land niet gevonden: " + naam);
    }

    public void voegGemeenteToe(String naam, int aantalInwoners) {
        int aantalVluchtelingen = 123;
        gemeentes.add(new Gemeente(naam, aantalInwoners, aantalVluchtelingen));
        System.out.println("Gemeente toegevoegd: " + naam);
    }

    public void rapportageUitkeringen() {
        for (Gemeente gemeente : gemeentes) {
            int verplichtAantalAsielzoekers = (int) (gemeente.getAantalInwoners() * 0.005);
            int extraAsielzoekers = gemeente.getAantalVluchtelingen() - verplichtAantalAsielzoekers;
            int uitkering = 0;
            if (extraAsielzoekers > 0) {
                uitkering = (verplichtAantalAsielzoekers * 1000) + (extraAsielzoekers * 2000);
            } else {
                uitkering = gemeente.getAantalVluchtelingen() * 1000;
            }
            System.out.println("Gemeente " + gemeente.getNaam() + " met " + gemeente.getAantalVluchtelingen() + " asielzoekers krijgt een uitkering van €" + uitkering);
        }
    }
}
