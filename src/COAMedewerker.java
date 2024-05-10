import java.util.ArrayList;

public class COAMedewerker {
    private ArrayList<Vluchteling> vluchtelingen = new ArrayList<>();
    private ArrayList<AZC> azcs;

    public COAMedewerker(ArrayList<AZC> azcs) {
        this.azcs = azcs;
    }

    public void registreerVluchteling(String naam, String landVanHerkomst, boolean paspoortGetoond) {
        Vluchteling nieuweVluchteling = new Vluchteling(naam, landVanHerkomst, paspoortGetoond);
        vluchtelingen.add(nieuweVluchteling);
        System.out.println("Vluchteling geregistreerd: " + naam);
    }

    public void plaatsVluchteling(String naam, String gemeente) {
        Vluchteling vluchteling = zoekVluchteling(naam);
        if (vluchteling != null) {
            AZC azc = azcs.stream()
                    .filter(a -> a.getGemeente().equals(gemeente))
                    .findFirst()
                    .orElse(null);
            if (azc != null && azc.heeftRuimte()) {
                azc.voegVluchtelingToe(vluchteling);
                System.out.println("Vluchteling " + vluchteling.getNaam() + " is geplaatst in " + gemeente);
            } else {
                System.out.println("Geen ruimte beschikbaar in " + gemeente + " of AZC niet gevonden.");
            }
        } else {
            System.out.println("Vluchteling met naam " + vluchteling.getNaam() + " niet gevonden.");
        }
    }

    public void updateDossier(String naam, boolean paspoortGetoond, boolean asielaanvraagCompleet, boolean rechterToegewezen, boolean rechterHeeftUitspraak, String rechterUitspraak, boolean isTeruggekeerd) {
        Vluchteling vluchteling = zoekVluchteling(naam);
        if (vluchteling != null && vluchteling.getDossier() != null) {
            Dossier dossier = vluchteling.getDossier();
            dossier.setPaspoortGetoond(paspoortGetoond);
            dossier.setAsielaanvraagCompleet(asielaanvraagCompleet);
            dossier.setRechterToegewezen(rechterToegewezen);
            dossier.setRechterHeeftUitspraak(rechterHeeftUitspraak);
            dossier.setRechterUitspraak(rechterUitspraak);
            dossier.setIsTeruggekeerd(isTeruggekeerd);
            System.out.println("Dossier bijgewerkt voor: " + naam);
        } else {
            System.out.println("Vluchteling niet gevonden of dossier ontbreekt.");
        }
    }

    public Vluchteling zoekVluchteling(String naam) {
        return vluchtelingen.stream()
                .filter(v -> v.getNaam().equals(naam))
                .findFirst()
                .orElse(null);
    }
}
