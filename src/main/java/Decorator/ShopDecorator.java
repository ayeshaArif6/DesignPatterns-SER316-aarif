package Decorator;
import java.util.ArrayList;
import java.util.List;

/**
 * ShopDecorator is the decorator base for the Decorator design pattern.
 */
public interface ShopDecorator extends Shop {
    // Additional methods for decorating the shop
    void decorate();
    void displayAvailableItems();

}