package Decorator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RandomItemShopDecorator implements ShopDecorator {
    private Shop shop;

    public RandomItemShopDecorator(Shop shop) {
        this.shop = shop;
    }

    @Override
    public List<Item> getAvailableItems() {
        List<Item> items = new ArrayList<>(shop.getAvailableItems());
        Collections.shuffle(items); // Shuffle the items
        return items.subList(0, Math.min(3, items.size())); // Select up to three items
    }

    @Override
    public void decorate() {
        System.out.println("Shop has been decorated with random items!");
    }

    @Override
    public void displayAvailableItems() {
        System.out.println("Available items in the shop:");
        List<Item> items = getAvailableItems();
        for (Item item : items) {
            System.out.println("- " + item.getDescription());
        }
    }

    private Item generateRandomItem() {
        // Implement logic to generate a random item
        // For simplicity, returning a Potion or Sword alternately
        return new Potion(); // or new Sword();
    }
}
