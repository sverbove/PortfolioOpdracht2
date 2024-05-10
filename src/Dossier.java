public class Dossier {
    private boolean paspoortGetoond;
    private boolean asielaanvraagCompleet;
    private boolean rechterToegewezen;
    private boolean rechterHeeftUitspraak;
    private String rechterUitspraak;
    private boolean isTeruggekeerd;
    private String plaatsingInEigenWoning;

    public Dossier(boolean paspoortGetoond, boolean asielaanvraagCompleet, boolean rechterToegewezen, String rechterUitspraak, boolean isTeruggekeerd, String plaatsingInEigenWoning) {
        this.paspoortGetoond = paspoortGetoond;
        this.asielaanvraagCompleet = asielaanvraagCompleet;
        this.rechterToegewezen = rechterToegewezen;
        this.rechterHeeftUitspraak = false; // Deze waarde wordt later bijgewerkt
        this.rechterUitspraak = rechterUitspraak;
        this.isTeruggekeerd = isTeruggekeerd;
        this.plaatsingInEigenWoning = plaatsingInEigenWoning;
    }

    public boolean isPaspoortGetoond() { return paspoortGetoond; }
    public boolean isAsielaanvraagCompleet() { return asielaanvraagCompleet; }
    public boolean isRechterToegewezen() { return rechterToegewezen; }
    public boolean isRechterHeeftUitspraak() { return rechterHeeftUitspraak; }
    public String getRechterUitspraak() { return rechterUitspraak; }
    public boolean isTeruggekeerd() { return isTeruggekeerd; }
    public String getPlaatsingInEigenWoning() { return plaatsingInEigenWoning; }

    public void setPaspoortGetoond(boolean paspoortGetoond) { this.paspoortGetoond = paspoortGetoond; }
    public void setAsielaanvraagCompleet(boolean asielaanvraagCompleet) { this.asielaanvraagCompleet = asielaanvraagCompleet; }
    public void setRechterToegewezen(boolean rechterToegewezen) { this.rechterToegewezen = rechterToegewezen; }
    public void setRechterHeeftUitspraak(boolean rechterHeeftUitspraak) { this.rechterHeeftUitspraak = rechterHeeftUitspraak; }
    public void setRechterUitspraak(String rechterUitspraak) { this.rechterUitspraak = rechterUitspraak; }
    public void setIsTeruggekeerd(boolean isTeruggekeerd) { this.isTeruggekeerd = isTeruggekeerd; }
    public void setPlaatsingInEigenWoning(String status) { this.plaatsingInEigenWoning = status; }
}
