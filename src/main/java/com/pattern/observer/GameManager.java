package com.pattern.observer;

import java.util.ArrayList;
import java.util.List;

public class GameManager implements Subject {
    private List<Observer> observers = new ArrayList<>();

    @Override
    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void notifyObserversCycleEvent(int cycleNumber) {
        for (Observer observer : observers) {
            observer.updateCycleEvent(cycleNumber);
        }
    }

    @Override
    public void notifyObserversHealthEvent(int playerHealth, int monsterHealth) {
        for (Observer observer : observers) {
            observer.updateHealthEvent(playerHealth, monsterHealth);
        }
    }
}
