package com.kpp.labs;

public class SummerShoes implements Shoes{
    private String name;
    private int size;
    private double price;

    public SummerShoes(String name, int size, double price) {
        this.name = name;
        this.size = size;
        this.price = price;
    }

    @Override
    public void printParam() {
        System.out.println("Назва: " + name);
        System.out.println("Розмір: " + size);
        System.out.println("Ціна: " + price);
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


}
