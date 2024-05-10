public class Land {
    private String naam;
    private boolean isVeilig;

    public Land(String naam, boolean isVeilig) {
        this.naam = naam;
        this.isVeilig = isVeilig;
    }

    public String getNaam() {
        return naam;
    }

    public boolean getIsVeilig() {
        return isVeilig;
    }

    public void setIsVeilig(boolean isVeilig) {
        this.isVeilig = isVeilig;
    }
}
