package com.kpp.labs;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        Shoes shoes = new Shoes("Adidas", 42, 1300, "White");
        Shoes shoes1 = new Shoes("Puma", 41, 2000, "Black");
        Shoes shoes2 = new Shoes("Jordan", 39, 1000, "Blue");
        Shoes shoes4 = new Shoes("Nike", 38, 3600, "Yellow");

        User user = new DefaultUser("Taras", "Symovin");

        user.addToCart(shoes);
        user.recharge(8000);
        user.pay();
    }
}
