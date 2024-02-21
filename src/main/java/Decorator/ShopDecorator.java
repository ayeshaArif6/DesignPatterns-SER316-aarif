package Decorator;
import java.util.ArrayList;
import java.util.List;
public interface ShopDecorator extends Shop {
    // Additional methods for decorating the shop
    void decorate();
    void displayAvailableItems();

}