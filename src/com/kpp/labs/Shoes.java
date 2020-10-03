package com.kpp.labs;

import java.util.Comparator;

public class Shoes{
    private String name;
    private int size;
    private double price;
    private String color;

    public Shoes() {

    }

    public Shoes(String name, int size, double price, String color) {
        this.name = name;
        this.size = size;
        this.price = price;
        this.color = color;
    }

    public class ShoesSizeComparator implements Comparator<Shoes> {

        @Override
        public int compare(Shoes o1, Shoes o2) {
            return o1.size - o2.size;
        }
    }

    public static class ShoesPriceComparator implements Comparator<Shoes>{

        @Override
        public int compare(Shoes o1, Shoes o2) {
            return (int) (o1.price - o2.price);
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "SummerShoes{" +
                "name='" + name + '\'' +
                ", size=" + size +
                ", price=" + price +
                ", color=" + color +
                '}';
    }
}