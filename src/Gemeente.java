public class Gemeente {
    private String naam;
    private int aantalInwoners;
    private int aantalVluchtelingen;  // Correcte variabele voor het aantal vluchtelingen

    public Gemeente(String naam, int aantalInwoners, int aantalVluchtelingen) {
        this.naam = naam;
        this.aantalInwoners = aantalInwoners;
        this.aantalVluchtelingen = aantalVluchtelingen;
    }

    public String getNaam() {
        return naam;
    }

    public int getAantalInwoners() {
        return aantalInwoners;
    }

    public int getAantalVluchtelingen() {
        return aantalVluchtelingen;  // Correcte getter voor het aantal vluchtelingen
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }

    public void setAantalInwoners(int aantalInwoners) {
        this.aantalInwoners = aantalInwoners;
    }

    public void setAantalVluchtelingen(int aantalVluchtelingen) {
        this.aantalVluchtelingen = aantalVluchtelingen;
    }
}
