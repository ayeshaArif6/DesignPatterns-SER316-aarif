package com.pattern.decorator;

import java.util.ArrayList;
import java.util.List;

/**
 * Basic shop is the concrete component for the Decorator design pattern.
 */
public class BasicShop implements Shop {
    private List<Item> availableItems;

    public BasicShop(List<Item> initialItems) {
        this.availableItems = new ArrayList<>(initialItems);
    }

    @Override
    public List<Item> getAvailableItems() {
        return new ArrayList<>(availableItems);
    }

    //This method displays all items in shop.
    @Override
    public void displayAvailableItems() {
        System.out.println("-----Welcome To The Shop-----");

        List<Item> itemsToDisplay = getRandomItems(3);

        int index = 1;
        for (Item item : itemsToDisplay) {
            System.out.println(index + ". " + item.getDescription());
            index++;
        }
    }

    // Since the shop can have only three items at a time, this method randomly puts three objects every time a shop is called.
    private List<Item> getRandomItems(int count) {
        List<Item> randomItems = new ArrayList<>();

        List<Item> availableItemsCopy = new ArrayList<>(availableItems);

        for (int i = 0; i < count; i++) {
            if (!availableItemsCopy.isEmpty()) {
                int randomIndex = (int) (Math.random() * availableItemsCopy.size());
                randomItems.add(availableItemsCopy.remove(randomIndex));
            }
        }

        return randomItems;
    }

}

