package com.pattern.decorator;

/**
 * ShopDecorator is the decorator base for the Decorator design pattern.
 */
public interface ShopDecorator extends Shop {
    // Additional methods for decorating the shop
    void decorate();
    void displayAvailableItems();

}