package com.kpp.labs;

import java.util.List;

public abstract class User {

    protected String name;
    protected String surname;
    protected double balance;

    public abstract void recharge(double sum);
    public abstract void pay();
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public List<Shoes> getProducts() {
        return products;
    }

    public void setProducts(List<Shoes> products) {
        this.products = products;
    }

    protected List<Shoes> products;

    public void addToCart(Shoes product){
        this.products.add(product);
    }

}
