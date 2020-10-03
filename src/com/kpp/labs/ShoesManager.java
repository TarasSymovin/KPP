package com.kpp.labs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ShoesManager {
    private ArrayList<Shoes> shoes;

    public ShoesManager(ArrayList<Shoes> shoes) {
        this.shoes = shoes;
    }

    public void sortBySizeUp(){
        Collections.sort(shoes, new Shoes().new ShoesSizeComparator());
    }

    public void sortByPriceUp(){
        Collections.sort(shoes, new Shoes.ShoesPriceComparator());
    }

    public void sortByNameUp(){
        ShoesNameComparator shoesNameComparator = new ShoesNameComparator(){
            @Override
            public int compare(Shoes o1, Shoes o2) {
                return o1.getName().compareTo(o2.getName());
            }
        };
        Collections.sort(shoes, shoesNameComparator);
    }

    public void sortByColorUp(){
        shoes.sort((Shoes o1, Shoes o2)->o1.getColor().compareTo(o2.getColor()));
    }

    public void sortByColorDown(){
        shoes.sort((Shoes o1, Shoes o2)->o1.getColor().compareTo(o2.getColor()));
        Collections.sort(shoes, Collections.reverseOrder((Shoes o1, Shoes o2)->o1.getColor().compareTo(o2.getColor())));
    }

    public void sortBySizeDown(){
        Collections.sort(shoes, Collections.reverseOrder(new Shoes().new ShoesSizeComparator()));
    }

    public void sortByPriceDown(){
        Collections.sort(shoes, Collections.reverseOrder(new Shoes.ShoesPriceComparator()));
    }

    public void sortByNameDown(){
        ShoesNameComparator shoesNameComparator = new ShoesNameComparator(){
            @Override
            public int compare(Shoes o1, Shoes o2) {
                return o1.getName().compareTo(o2.getName());
            }
        };
        Collections.sort(shoes, Collections.reverseOrder(shoesNameComparator));
    }

    public void printListOfShoes(){
        for (Shoes o : shoes)
            System.out.println(o);
    }
}