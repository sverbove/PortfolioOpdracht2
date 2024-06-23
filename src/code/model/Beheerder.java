package code.model;

import java.util.ArrayList;
import java.util.List;

public class Beheerder {
    private String naam;
    private List<Gemeente> gemeentes;

    public Beheerder(String naam) {
        this.naam = naam;
        this.gemeentes = new ArrayList<>();
    }

    public void voegLandToe(String naam, boolean isVeilig) {
        System.out.println("Land toegevoegd: " + naam);
    }

    public void wijzigVeiligheidLand(String naam, boolean nieuweVeiligheid) {
        System.out.println("Veiligheid van land gewijzigd: " + naam);
    }

    public void voegGemeenteToe(String naam, int aantalInwoners) {
        Gemeente nieuweGemeente = new Gemeente(naam, aantalInwoners, 0);
        gemeentes.add(nieuweGemeente);
        System.out.println("Gemeente toegevoegd: " + naam);
    }

    public void verwijderGemeente(String naam) {
        gemeentes.removeIf(gemeente -> gemeente.getNaam().equals(naam));
        System.out.println("Gemeente verwijderd: " + naam);
    }

    public void rapportageUitkeringen() {
        System.out.println("Uitkeringen gerapporteerd.");
    }
}
