package code.model;

public class Status {
    private boolean paspoortGetoond;
    private boolean asielaanvraagCompleet;
    private boolean rechterToegewezen;
    private boolean rechterHeeftUitspraak;
    private String rechterUitspraak;
    private boolean isTeruggekeerd;

    public Status() {
        this.paspoortGetoond = false;
        this.asielaanvraagCompleet = false;
        this.rechterToegewezen = false;
        this.rechterHeeftUitspraak = false;
        this.rechterUitspraak = "";
        this.isTeruggekeerd = false;
    }

    public Status(boolean paspoortGetoond, boolean asielaanvraagCompleet, boolean rechterToegewezen, boolean rechterHeeftUitspraak, String rechterUitspraak, boolean isTeruggekeerd) {
        this.paspoortGetoond = paspoortGetoond;
        this.asielaanvraagCompleet = asielaanvraagCompleet;
        this.rechterToegewezen = rechterToegewezen;
        this.rechterHeeftUitspraak = rechterHeeftUitspraak;
        this.rechterUitspraak = rechterUitspraak;
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

    public boolean isTeruggekeerd() {
        return isTeruggekeerd;
    }

    public void setTeruggekeerd(boolean isTeruggekeerd) {
        this.isTeruggekeerd = isTeruggekeerd;
    }
}
