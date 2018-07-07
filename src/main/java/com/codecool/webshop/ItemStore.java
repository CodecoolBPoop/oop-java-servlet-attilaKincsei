package com.codecool.webshop;

import java.util.ArrayList;
import java.util.List;

public class ItemStore extends Item {

    static List<Item> cartContent = new ArrayList<>();
    static double totalPrice;

    static double calculateTotalPrice() {
        totalPrice = 0;
        for (Item item : cartContent) {
            totalPrice += item.getPrice();
        }
        return totalPrice;
    }

    public static double getTotalPrice() {
        return totalPrice;
    }
}
