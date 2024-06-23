package code.model;

import java.util.ArrayList;
import java.util.List;

public class COAMedewerker {
    private String naam;
    private List<AZC> azcs;
    private List<Vluchteling> vluchtelingen;

    private COAMedewerker(Builder builder) {
        this.naam = builder.naam;
        this.azcs = builder.azcs;
        this.vluchtelingen = new ArrayList<>();
    }

    public static class Builder {
        private String naam;
        private List<AZC> azcs;

        public Builder(String naam) {
            this.naam = naam;
        }

        public Builder setAzcs(List<AZC> azcs) {
            this.azcs = azcs;
            return this;
        }

        public COAMedewerker build() {
            return new COAMedewerker(this);
        }
    }

    public void registreerVluchteling(String naam, String landVanHerkomst, boolean paspoortGetoond) {
        Vluchteling vluchteling = new Vluchteling(naam, landVanHerkomst, paspoortGetoond);
        vluchtelingen.add(vluchteling);
        System.out.println("Vluchteling geregistreerd: " + naam);
    }

    public Vluchteling zoekVluchteling(String naam) {
        return vluchtelingen.stream()
                .filter(v -> v.getNaam().equals(naam))
                .findFirst()
                .orElse(null);
    }

    public void updateDossier(String naam, Status status, String plaatsingInEigenWoning) {
        Vluchteling vluchteling = zoekVluchteling(naam);
        if (vluchteling != null) {
            Dossier dossier = new Dossier(status, plaatsingInEigenWoning);
            vluchteling.setDossier(dossier);
            System.out.println("Dossier bijgewerkt voor: " + naam);
        } else {
            System.out.println("Vluchteling niet gevonden of dossier ontbreekt.");
        }
    }
}
