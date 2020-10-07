package com.kpp.labs;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        Shoes shoes = new Shoes(52, "Adidas", 42, 1300, "White");
        Shoes shoes1 = new Shoes(58, "Puma", 41, 2000, "Black");
        Shoes shoes2 = new Shoes(12, "Jordan", 39, 1000, "Blue");
        Shoes shoes4 = new Shoes(56, "Nike", 38, 3600, "Yellow");

        User user = new DefaultUser("Taras", "Symovin");

        Manager manager = new ShoesManager();
        manager.addProduct(shoes);
        manager.addProduct(shoes1);
        manager.printListOfProducts();
        manager.removeProduct(shoes.getId());
        manager.printListOfProducts();

        user.addToCart(shoes);
        user.recharge(8000);
        user.pay();
    }
}
