package com.kpp.labs;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        Shoes shoes = new Shoes("Adidas", 42, 1300, "White");
        Shoes shoes1 = new Shoes("Puma", 41, 2000, "Black");
        Shoes shoes2 = new Shoes("Jordan", 39, 1000, "Blue");
        Shoes shoes4 = new Shoes("Nike", 38, 3600, "Yellow");

        ArrayList<Shoes> list = new ArrayList<>();

        list.add(shoes);
        list.add(shoes1);
        list.add(shoes2);
        list.add(shoes4);

        ShoesManager shoesManager = new ShoesManager(list);
        shoesManager.sortBySizeDown();
        shoesManager.printListOfShoes();

        System.out.println();
        shoesManager.sortByPriceDown();
        shoesManager.printListOfShoes();

        System.out.println();
        shoesManager.sortByNameDown();
        shoesManager.printListOfShoes();

        System.out.println();
        shoesManager.sortByColorDown();
        shoesManager.printListOfShoes();
    }
}