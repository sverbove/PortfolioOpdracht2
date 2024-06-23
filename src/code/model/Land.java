package code.model;

public class Land {
    private final String naam;
    private boolean isVeilig;

    public Land(String naam, boolean isVeilig) {
        this.naam = naam;
        this.isVeilig = isVeilig;
    }

    public String getNaam() {
        return naam;
    }

    public void setIsVeilig(boolean isVeilig) {
        this.isVeilig = isVeilig;
    }
}
