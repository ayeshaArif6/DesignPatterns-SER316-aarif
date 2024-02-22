package com.pattern.observer;

public class CycleEventObserver implements Observer {
    @Override
    public void updateCycleEvent(int cycleNumber) {
        System.out.println("Cycle " + cycleNumber );
    }

    @Override
    public void updateHealthEvent(int playerHealth, int monsterHealth) {
    }
}