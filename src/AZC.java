import java.util.ArrayList;

public class AZC {
    private String straat;
    private String nummer;
    private String postcode;
    private String gemeente;
    private ArrayList<Vluchteling> vluchtelingen;

    public AZC(String straat, String nummer, String postcode, String gemeente) {
        this.straat = straat;
        this.nummer = nummer;
        this.postcode = postcode;
        this.gemeente = gemeente;
        this.vluchtelingen = new ArrayList<>();
    }

    public String getAdres() {
        return straat + " " + nummer + ", " + postcode;
    }

    public void setAdres(String straat, String nummer, String postcode) {
        this.straat = straat;
        this.nummer = nummer;
        this.postcode = postcode;
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
        return vluchtelingen.size() < 100; // Stel een maximale capaciteit per AZC.
    }

    public int beschikbarePlaatsen() {
        return 100 - vluchtelingen.size(); // Neemt aan dat de capaciteit 100 is.
    }

    public void voegVluchtelingToe(Vluchteling vluchteling) {
        vluchtelingen.add(vluchteling);
    }

    public void verwijderVluchteling(Vluchteling vluchteling) {
        vluchtelingen.remove(vluchteling);
    }
}
