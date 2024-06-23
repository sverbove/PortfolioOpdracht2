package code.model;

public class Vluchteling {
    private String naam;
    private String landVanHerkomst;
    private boolean paspoortGetoond;
    private Dossier dossier;

    public Vluchteling(String naam, String landVanHerkomst, boolean paspoortGetoond) {
        this.naam = naam;
        this.landVanHerkomst = landVanHerkomst;
        this.paspoortGetoond = paspoortGetoond;
        this.dossier = new Dossier(); // Correcte constructor aanroep
    }

    public String getNaam() {
        return naam;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }

    public String getLandVanHerkomst() {
        return landVanHerkomst;
    }

    public void setLandVanHerkomst(String landVanHerkomst) {
        this.landVanHerkomst = landVanHerkomst;
    }

    public boolean isPaspoortGetoond() {
        return paspoortGetoond;
    }

    public void setPaspoortGetoond(boolean paspoortGetoond) {
        this.paspoortGetoond = paspoortGetoond;
    }

    public Dossier getDossier() {
        return dossier;
    }

    public void setDossier(Dossier dossier) {
        this.dossier = dossier;
    }

    public void toonGeregistreerdeGegevens() {
        System.out.println("Naam: " + naam);
        System.out.println("Land van herkomst: " + landVanHerkomst);
        System.out.println("Paspoort getoond: " + (paspoortGetoond ? "Ja" : "Nee"));
    }

    public void toonStatusDossier() {
        System.out.println("Status van het dossier:");
        System.out.println("Paspoort getoond: " + (dossier.getStatus().isPaspoortGetoond() ? "Ja" : "Nee"));
        System.out.println("Asielaanvraag compleet: " + (dossier.getStatus().isAsielaanvraagCompleet() ? "Ja" : "Nee"));
        System.out.println("Rechter toegewezen: " + (dossier.getStatus().isRechterToegewezen() ? "Ja" : "Nee"));
        System.out.println("Rechter heeft uitspraak gedaan: " + (dossier.getStatus().isRechterHeeftUitspraak() ? "Ja" : "Nee"));
        System.out.println("Uitspraak van de rechter: " + dossier.getStatus().getRechterUitspraak());
        System.out.println("Teruggekeerd naar land van herkomst: " + (dossier.getStatus().isTeruggekeerd() ? "Ja" : "Nee"));
        System.out.println("Status plaatsing in eigen woning: " + dossier.getPlaatsingInEigenWoning());
    }

    public void registreerAdres(String adres) {
        System.out.println("Nieuw adres geregistreerd: " + adres);
    }

    @Override
    public String toString() {
        return "Vluchteling: " + naam;
    }
}
