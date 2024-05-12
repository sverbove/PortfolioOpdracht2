public class Vluchteling {
    private String naam;
    private String landVanHerkomst;
    private String adres;
    private Dossier dossier;

    // Constructor
    public Vluchteling(String naam, String landVanHerkomst, boolean paspoortGetoond) {
        this.naam = naam;
        this.landVanHerkomst = landVanHerkomst;
        this.adres = "Onbekend";
        this.dossier = new Dossier(paspoortGetoond, false, false, "geen", false, "nee", false);
    }

    public void toonGeregistreerdeGegevens() {
        System.out.println("Naam: " + naam);
        System.out.println("Land van herkomst: " + landVanHerkomst);
        System.out.println("Huidig adres: " + adres);
    }

    public void toonStatusDossier() {
        System.out.println("Paspoort getoond: " + (dossier.isPaspoortGetoond() ? "ja" : "nee"));
        System.out.println("Asielaanvraag is compleet: " + (dossier.isAsielaanvraagCompleet() ? "ja" : "nee"));
        System.out.println("Rechter toegewezen: " + (dossier.isRechterToegewezen() ? "ja" : "nee"));
        System.out.println("Rechter heeft uitspraak gedaan: " + (dossier.isRechterHeeftUitspraak() ? "ja" : "nee"));
        System.out.println("Uitspraak van de rechter: " + dossier.getRechterUitspraak());
        System.out.println("Plaatsing in eigen woning: " + dossier.getPlaatsingInEigenWoning());
    }

    public void registreerAdres(String nieuwAdres) {
        this.adres = nieuwAdres;
        System.out.println("Nieuw adres geregistreerd: " + adres);
    }

    public String getNaam() {
        return naam;
    }

    public String getLandVanHerkomst() {
        return landVanHerkomst;
    }

    public String getAdres() {
        return adres;
    }

    public Dossier getDossier() {
        return dossier;
    }
}
