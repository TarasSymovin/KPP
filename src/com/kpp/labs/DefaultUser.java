package com.kpp.labs;

import java.util.ArrayList;

public class DefaultUser extends User{

    @Override
    public void recharge(double sum) {
        this.balance += sum;
        System.out.println(this.surname + " " + this.name + ". " + "Ваш баланс поповнено на: " + sum + " грн. Сума на балансі: " + this.balance);
    }

    public DefaultUser(String name, String surname) {
        this.name = name;
        this.surname = surname;
        this.balance = 0;
        this.cart = new Cart();
    }
}
