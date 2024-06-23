package code.task;

public abstract class TaskTemplate {
    public final void voerTaakUit() {
        voorbereiden();
        uitvoerTaak();
        afsluiten();
    }

    protected abstract void uitvoerTaak();

    private void voorbereiden() {
        System.out.println("Voorbereiden van de taak.");
    }

    private void afsluiten() {
        System.out.println("Afsluiten van de taak.");
    }
}

