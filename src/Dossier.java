public class Dossier {
    private boolean paspoortGetoond;
    private boolean asielaanvraagCompleet;
    private boolean rechterToegewezen;
    private boolean rechterHeeftUitspraak;
    private String rechterUitspraak;
    private String plaatsingInEigenWoning;
    private boolean isTeruggekeerd;

    public Dossier(boolean paspoortGetoond, boolean asielaanvraagCompleet, boolean rechterToegewezen, String rechterUitspraak, boolean rechterHeeftUitspraak, String plaatsingInEigenWoning, boolean isTeruggekeerd) {
        this.paspoortGetoond = paspoortGetoond;
        this.asielaanvraagCompleet = asielaanvraagCompleet;
        this.rechterToegewezen = rechterToegewezen;
        this.rechterHeeftUitspraak = rechterHeeftUitspraak;
        this.rechterUitspraak = rechterUitspraak;
        this.plaatsingInEigenWoning = plaatsingInEigenWoning;
        this.isTeruggekeerd = isTeruggekeerd;
    }

    public boolean isPaspoortGetoond() {
        return paspoortGetoond;
    }

    public void setPaspoortGetoond(boolean paspoortGetoond) {
        this.paspoortGetoond = paspoortGetoond;
    }

    public boolean isAsielaanvraagCompleet() {
        return asielaanvraagCompleet;
    }

    public void setAsielaanvraagCompleet(boolean asielaanvraagCompleet) {
        this.asielaanvraagCompleet = asielaanvraagCompleet;
    }

    public boolean isRechterToegewezen() {
        return rechterToegewezen;
    }

    public void setRechterToegewezen(boolean rechterToegewezen) {
        this.rechterToegewezen = rechterToegewezen;
    }

    public boolean isRechterHeeftUitspraak() {
        return rechterHeeftUitspraak;
    }

    public void setRechterHeeftUitspraak(boolean rechterHeeftUitspraak) {
        this.rechterHeeftUitspraak = rechterHeeftUitspraak;
    }

    public String getRechterUitspraak() {
        return rechterUitspraak;
    }

    public void setRechterUitspraak(String rechterUitspraak) {
        this.rechterUitspraak = rechterUitspraak;
    }

    public String getPlaatsingInEigenWoning() {
        return plaatsingInEigenWoning;
    }

    public void setPlaatsingInEigenWoning(String plaatsingInEigenWoning) {
        this.plaatsingInEigenWoning = plaatsingInEigenWoning;
    }

    public boolean isIsTeruggekeerd() {
        return isTeruggekeerd;
    }

    public void setIsTeruggekeerd(boolean isTeruggekeerd) {
        this.isTeruggekeerd = isTeruggekeerd;
    }
}
