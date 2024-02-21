package Decorator;

import java.util.ArrayList;
import java.util.List;

public class BasicShop implements Shop {
    private List<Item> availableItems;

    public BasicShop(List<Item> initialItems) {
        this.availableItems = new ArrayList<>(initialItems);
    }

    private void initializeItems() {
        availableItems = new ArrayList<>();
        availableItems.add(new Potion());
        availableItems.add(new Potion());
        availableItems.add(new Sword());
        availableItems.add(new Shield());
        availableItems.add(new Helmet());
        // Add more items as needed...
    }
    @Override
    public List<Item> getAvailableItems() {
        return new ArrayList<>(availableItems);
    }

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

