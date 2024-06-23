package code.model;

import code.observer.Observer;

public class Gemeente implements Observer {
    private String naam;
    private int aantalInwoners;
    private int aantalVluchtelingen;

    // Constructor om de naam in te stellen
    public Gemeente(String naam) {
        this.naam = naam;
    }

    // Constructor om alle velden in te stellen
    public Gemeente(String naam, int aantalInwoners, int aantalVluchtelingen) {
        this.naam = naam;
        this.aantalInwoners = aantalInwoners;
        this.aantalVluchtelingen = aantalVluchtelingen;
    }

    @Override
    public void update(String bericht) {
        System.out.println("Gemeente " + naam + " ontving update: " + bericht);
    }

    // Getters en setters
    public String getNaam() {
        return naam;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }

    public int getAantalInwoners() {
        return aantalInwoners;
    }

    public void setAantalInwoners(int aantalInwoners) {
        this.aantalInwoners = aantalInwoners;
    }

    public int getAantalVluchtelingen() {
        return aantalVluchtelingen;
    }

    public void setAantalVluchtelingen(int aantalVluchtelingen) {
        this.aantalVluchtelingen = aantalVluchtelingen;
    }

    // Andere bestaande methoden...
}
