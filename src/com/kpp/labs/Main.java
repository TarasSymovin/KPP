package com.kpp.labs;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        Shoes shoes = new Shoes("Кроси adidas", 42, 1300);
        Shoes shoes1 = new Shoes("sscs", 41, 3000);
        Shoes shoes2 = new Shoes("sscs", 39, 3000);
        Shoes shoes4 = new Shoes("Nike", 38, 3600);

        ArrayList<Shoes> list = new ArrayList<>();

        list.add(shoes);
        list.add(shoes1);
        list.add(shoes2);
        list.add(shoes4);

        ShoesManager shoesManager = new ShoesManager(list);
        shoesManager.sortByName();
        shoesManager.printListOfShoes();
    }
}
