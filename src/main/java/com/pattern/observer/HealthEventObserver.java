package com.pattern.observer;

public class HealthEventObserver implements Observer {
    @Override
    public void updateCycleEvent(int cycleNumber) {
    }

    @Override
    public void updateHealthEvent(int playerHealth, int monsterHealth) {
        System.out.println("Player Health: " + playerHealth);
        System.out.println("Monster Health: " + monsterHealth);
    }
}
