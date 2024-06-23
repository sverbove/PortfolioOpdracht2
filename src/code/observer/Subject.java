package code.observer;

import code.observer.Observer;

import java.util.ArrayList;
import java.util.List;

public class Subject {
    private final List<Observer> observers = new ArrayList<>();

    public void voegObserverToe(Observer observer) {
        observers.add(observer);
    }

    public void notifyObservers(String bericht) {
        for (Observer observer : observers) {
            observer.update(bericht);
        }
    }
}
