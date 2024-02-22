package com.pattern.decorator;

import java.util.List;


/**
 * Shop is the Component Base of the Decorator design pattern.
 */
public interface Shop {
    List<Item> getAvailableItems();
    void displayAvailableItems();
}
