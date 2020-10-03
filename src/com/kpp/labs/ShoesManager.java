package com.kpp.labs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ShoesManager {
    private ArrayList<Shoes> shoes;

    public void sortByName(){
        Collections.sort(shoes, new Shoes().new ShoesSizeComparator());

    }

    public ShoesManager(ArrayList<Shoes> shoes) {
        this.shoes = shoes;
    }

    public void printListOfShoes(){
        for (Shoes o : shoes)
            System.out.println(o);
    }
}


