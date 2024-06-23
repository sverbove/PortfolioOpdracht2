package code.model;

import java.util.ArrayList;
import java.util.List;
import code.observer.Subject;

public class AZC extends Subject {
    private String naam;
    private String locatie;
    private String straat;
    private String nummer;
    private String postcode;
    private String gemeente;
    private List<Vluchteling> vluchtelingen;

    public AZC(String naam, String locatie) {
        this.naam = naam;
        this.locatie = locatie;
        this.vluchtelingen = new ArrayList<>();
    }

    public void voegVluchtelingToe(Vluchteling vluchteling) {
        vluchtelingen.add(vluchteling);
        notifyObservers("Nieuwe vluchteling toegevoegd aan AZC: " + naam);
    }

    public void verwijderVluchteling(Vluchteling vluchteling) {
        vluchtelingen.remove(vluchteling);
        notifyObservers("Vluchteling verwijderd uit code.model.AZC: " + naam);
    }

    public String getAdres() {
        return straat + " " + nummer + ", " + postcode;
    }

    public void setAdres(String straat, String nummer, String postcode) {
        this.straat = straat;
        this.nummer = nummer;
        this.postcode = postcode;
    }

    @Override
    public String toString() {
        return naam; // Of een andere weergave zoals "AZC naam: " + naam
    }

    public String getGemeente() {
        return gemeente;
    }

    public void setGemeente(String gemeente) {
        this.gemeente = gemeente;
    }

    public boolean isLeeg() {
        return vluchtelingen.isEmpty();
    }

    public boolean heeftRuimte() {
        return vluchtelingen.size() < 100;
    }

    public int beschikbarePlaatsen() {
        return 100 - vluchtelingen.size();
    }

    public List<Vluchteling> getVluchtelingen() {
        return vluchtelingen;
    }

    public void setVluchtelingen(List<Vluchteling> vluchtelingen) {
        this.vluchtelingen = vluchtelingen;
    }

    public String getNaam() {
        return naam;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }

    public String getLocatie() {
        return locatie;
    }

    public void setLocatie(String locatie) {
        this.locatie = locatie;
    }
}
