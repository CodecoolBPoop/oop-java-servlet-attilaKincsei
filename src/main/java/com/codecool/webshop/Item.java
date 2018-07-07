package com.codecool.webshop;

import java.util.ArrayList;
import java.util.List;

public class Item {

    int id;
    String name;
    double price;
    static List<Integer> idList = new ArrayList<>();
    static List<Item> itemList = new ArrayList<>();

    public Item() {
    }

    public Item(String name, double price) {
        if (idList.isEmpty()) {
            this.id = 0;
        } else {
            this.id = idList.get(idList.size() - 1) + 1;
        }

        idList.add((Integer) this.id);
        itemList.add(this);
        this.name = name;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    static Item getItemById(int itemId, List<Item> list) {
        for (int i = 0; i < list.size(); i++) {
            Item itemToLookFor = list.get(i);
            if (itemToLookFor.getId() == itemId) {
                return itemToLookFor;
            }
        }
        return null;
    }

    static void removeItem(int itemId, List<Item> list) {
        Item itemToBeRemoved = getItemById(itemId, list);
        if (itemToBeRemoved == null) {
            System.out.println("Cart does not contain item with id: " + String.valueOf(itemId));
        } else {
            list.remove(itemToBeRemoved);
        }
    }

}
