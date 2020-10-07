package com.kpp.labs;

import java.util.List;

public abstract class User {

    protected String name;
    protected String surname;
    protected double balance;
    protected Cart cart;

    public abstract void recharge(double sum);

    public void pay() {
        if (!cart.getProducts().isEmpty()){
            double cartSum = 0;
            for (Product product : cart.getProducts()){
                cartSum += product.getPrice();
            }

            if (cartSum <= balance){
                balance -= cartSum;
                cart.getProducts().clear();
                System.out.println(this.surname + " " + this.name + ". " + "Оперція пройшла успішно. Сума оплати: " + cartSum + ". Баланс: " + balance + ".");

            }
            else
            {
                System.out.println(this.surname + " " + this.name + ". " + "У вас недостатньо коштів для оплати. Поповніть ваш рахунок.");
            }
        }
        else
        {
            System.out.println(this.surname + " " + this.name + ". " + "Ваша корина пуста!");
        }
    }

    public void showBalance(){
        System.out.println(this.surname + " " + this.name + ". " + "Ваш баланс: " + this.balance);
    }

    public void showCart(){
        System.out.println("--------------------------------------------------------------");
        int count = 1;
        System.out.println("Корзина " + this.surname + " " + this.name + ":");
        for (Product o : cart.getProducts()){
            System.out.print(count++ + ") ");
            System.out.println(o);
        }
        System.out.println("--------------------------------------------------------------");
    }

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

    public void addToCart(Product product){
        this.cart.getProducts().add(product);
    }
}
