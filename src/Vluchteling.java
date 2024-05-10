public class Vluchteling {
    private String naam;
    private String landVanHerkomst;
    private String adres;
    private Dossier dossier;

    public Vluchteling(String naam, String landVanHerkomst, boolean paspoortGetoond) {
        this.naam = naam;
        this.landVanHerkomst = landVanHerkomst;
        this.dossier = new Dossier(paspoortGetoond, false, false, "", false, "nee"); // Initieel dossier bij aanmaken
        this.adres = ""; // Adres is initieel leeg
    }

    public String getNaam() { return naam; }
    public String getLandVanHerkomst() { return landVanHerkomst; }
    public String getAdres() { return adres; }
    public Dossier getDossier() { return dossier; }

    public void setNaam(String naam) { this.naam = naam; }
    public void setLandVanHerkomst(String landVanHerkomst) { this.landVanHerkomst = landVanHerkomst; }
    public void setAdres(String adres) { this.adres = adres; }

    public void toonGeregistreerdeGegevens() {
        System.out.println("Naam: " + naam);
        System.out.println("Land van herkomst: " + landVanHerkomst);
        System.out.println("Huidig adres: " + adres);
    }

    public void toonStatusDossier() {
        System.out.println("Paspoort getoond: " + dossier.isPaspoortGetoond());
        System.out.println("Asielaanvraag is compleet: " + dossier.isAsielaanvraagCompleet());
        System.out.println("Rechter toegewezen: " + dossier.isRechterToegewezen());
        System.out.println("Rechter heeft uitspraak gedaan: " + dossier.isRechterHeeftUitspraak());
        System.out.println("Plaatsing in eigen woning: " + dossier.getPlaatsingInEigenWoning());
    }

    public void registreerAdres(String nieuwAdres) {
        if (dossier.isRechterHeeftUitspraak() && "geaccepteerd".equals(dossier.getRechterUitspraak())) {
            setAdres(nieuwAdres);
            System.out.println("Adres succesvol geregistreerd: " + nieuwAdres);
        } else {
            System.out.println("Adres kan niet geregistreerd worden. Asielaanvraag is nog niet geaccepteerd.");
        }
    }
}
