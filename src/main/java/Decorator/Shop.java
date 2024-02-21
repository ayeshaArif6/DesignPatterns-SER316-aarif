package Decorator;

import java.util.List;

public interface Shop {
    List<Item> getAvailableItems();
    void displayAvailableItems();
}
