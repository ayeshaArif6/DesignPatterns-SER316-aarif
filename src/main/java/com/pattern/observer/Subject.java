package com.pattern.observer;

public interface Subject {
    void addObserver(Observer observer);
    void notifyObserversCycleEvent(int cycleNumber);
    void notifyObserversHealthEvent(int playerHealth, int monsterHealth);
}
