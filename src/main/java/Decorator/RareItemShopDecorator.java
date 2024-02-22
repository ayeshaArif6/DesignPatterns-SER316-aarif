package Decorator;

import java.util.ArrayList;
import java.util.List;

public class RareItemShopDecorator implements ShopDecorator {
    private Shop shop;

    public RareItemShopDecorator(Shop shop) {
        this.shop = shop;
    }

    @Override
    public List<Item> getAvailableItems() {
        List<Item> items = new ArrayList<>(shop.getAvailableItems());
        items.add(new InstantLevelUpItem());
        return items;
    }

    @Override
    public void decorate() {
        System.out.println("Shop has been decorated with rare items!");
    }

    @Override
    public void displayAvailableItems() {

    }
}