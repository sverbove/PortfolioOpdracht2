package code.service;

import code.model.AZC;
import java.util.List;

public class AZCService {
    private List<AZC> azcs;

    public AZCService(List<AZC> azcs) {
        this.azcs = azcs;
    }

    public void voegAZCToe(String naam, String locatie) {
        AZC nieuwAZC = new AZC(naam, locatie);
        azcs.add(nieuwAZC);
        System.out.println("AZC toegevoegd: " + naam);
    }

    public void verwijderAZC(String naam) {
        azcs.removeIf(azc -> azc.getNaam().equals(naam));
        System.out.println("AZC verwijderd: " + naam);
    }

    public void wijzigAZC(String huidigeNaam, String nieuweNaam, String nieuweLocatie) {
        AZC azc = azcs.stream()
                .filter(a -> a.getNaam().equals(huidigeNaam))
                .findFirst()
                .orElse(null);
        if (azc != null) {
            azc.setNaam(nieuweNaam);
            azc.setLocatie(nieuweLocatie);
            System.out.println("AZC gewijzigd: " + nieuweNaam);
        } else {
            System.out.println("AZC niet gevonden: " + huidigeNaam);
        }
    }
}
