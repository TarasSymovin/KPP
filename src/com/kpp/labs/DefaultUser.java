package com.kpp.labs;

import java.util.ArrayList;

public class DefaultUser extends User{

    @Override
    public void recharge(double sum) {
        this.balance += sum;
    }

    public DefaultUser(String name, String surname) {
        this.name = name;
        this.surname = surname;
        this.balance = 0;
        this.products = new ArrayList<>();
    }

    @Override
    public void pay() {
        double cartSum = 0;
        for (Shoes product : products){
            cartSum += product.getPrice();
        }

        if (cartSum <= balance){
            balance -= cartSum;
            products.clear();
            System.out.println("Оперція пройшла успішно. Сума оплати: " + cartSum + ". Баланс: " + balance + ".");
        }
        else
        {
            System.out.println("У вас недостатньо коштів для оплати. Поповніть ваш рахунок.");
        }
    }
}
