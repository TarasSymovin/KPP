package com.kpp.labs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ShoesManager {
    private ArrayList<Shoes> shoes;

    public ShoesManager(ArrayList<Shoes> shoes) {
        this.shoes = shoes;
    }

    public void sortBySize(){
        Collections.sort(shoes, new Shoes().new ShoesSizeComparator());
    }

    public void sortByPrice(){
        Collections.sort(shoes, new Shoes.ShoesPriceComparator());
    }

    public void sortByName(){
        ShoesNameComparator shoesNameComparator = new ShoesNameComparator(){
            @Override
            public int compare(Shoes o1, Shoes o2) {
                return o1.getName().compareTo(o2.getName());
            }
        };
        Collections.sort(shoes, shoesNameComparator);
    }

    public void printListOfShoes(){
        for (Shoes o : shoes)
            System.out.println(o);
    }
}