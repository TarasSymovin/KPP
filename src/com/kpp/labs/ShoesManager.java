package com.kpp.labs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ShoesManager implements Manager {
    private List<Shoes> shoes;

    public ShoesManager() {
        this.shoes = new ArrayList<>();
    }

    @Override
    public void addProduct(Product product) {
        shoes.add((Shoes) product);
    }

    @Override
    public void removeProduct(int id) {
        for (Shoes sh : shoes){
            if (sh.getId() == id){
                shoes.remove(shoes.indexOf(sh));
            }
        }
    }

    @Override
    public void sortByName(boolean type) {
        ShoesNameComparator shoesNameComparator = new ShoesNameComparator(){
            @Override
            public int compare(Shoes o1, Shoes o2) {
                return o1.getName().compareTo(o2.getName());
            }
        };

        if (type){
            Collections.sort(shoes, shoesNameComparator);
        }
        else
        {
            Collections.sort(shoes, Collections.reverseOrder(shoesNameComparator));
        }
    }

    @Override
    public void sortBySize(boolean type) {
        if (type){
            Collections.sort(shoes, new Shoes().new ShoesSizeComparator());
        }
        else
        {
            Collections.sort(shoes, Collections.reverseOrder(new Shoes().new ShoesSizeComparator()));
        }
    }

    @Override
    public void sortByPrice(boolean type) {
        if (type){
            Collections.sort(shoes, new Shoes.ShoesPriceComparator());
        }
        else
        {
            Collections.sort(shoes, Collections.reverseOrder(new Shoes.ShoesPriceComparator()));
        }
    }

    @Override
    public void sortByColor(boolean type) {
        if (type){
            shoes.sort((Shoes o1, Shoes o2)->o1.getColor().compareTo(o2.getColor()));
        }
        else
        {
            Collections.sort(shoes, Collections.reverseOrder((Shoes o1, Shoes o2)->o1.getColor().compareTo(o2.getColor())));
        }
    }

    public void printListOfProducts(){
        for (Shoes o : shoes)
            System.out.println(o);
    }
}