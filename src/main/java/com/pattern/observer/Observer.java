package com.pattern.observer;

public interface Observer {

    void updateCycleEvent(int cycleNumber);

    void updateHealthEvent(int playerHealth, int monsterHealth);

}

