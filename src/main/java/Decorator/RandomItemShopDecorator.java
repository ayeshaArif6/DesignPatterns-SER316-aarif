package Decorator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * This class is the concrete decorator for the decorator design pattern.
 */
public class RandomItemShopDecorator implements ShopDecorator {
    private Shop shop;

    public RandomItemShopDecorator(Shop shop) {
        this.shop = shop;
    }

    @Override
    public List<Item> getAvailableItems() {
        List<Item> items = new ArrayList<>(shop.getAvailableItems());
        Collections.shuffle(items); // This Shuffles the available items
        return items.subList(0, Math.min(3, items.size())); // This selects up to three items from the avialble items.
    }

    @Override
    public void decorate() {

    }

    //This method displays available items in the inventory
    @Override
    public void displayAvailableItems() {
        System.out.println("Available items in the shop:");
        List<Item> items = getAvailableItems();
        for (Item item : items) {
            System.out.println("- " + item.getDescription());
        }
    }

}
