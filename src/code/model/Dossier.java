package code.model;

public class Dossier {
    private Status status;
    private String plaatsingInEigenWoning;

    public Dossier() {
        this.status = new Status();
        this.plaatsingInEigenWoning = "Niet gestart";
    }

    public Dossier(Status status, String plaatsingInEigenWoning) {
        this.status = status;
        this.plaatsingInEigenWoning = plaatsingInEigenWoning;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public String getPlaatsingInEigenWoning() {
        return plaatsingInEigenWoning;
    }

    public void setPlaatsingInEigenWoning(String plaatsingInEigenWoning) {
        this.plaatsingInEigenWoning = plaatsingInEigenWoning;
    }
}
