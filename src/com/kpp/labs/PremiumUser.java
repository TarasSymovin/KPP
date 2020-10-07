package com.kpp.labs;

public class PremiumUser extends User{

    private int bonuses;

    public PremiumUser(String name, String surname) {
        this.name = name;
        this.surname = surname;
        this.balance = 0;
        this.cart = new Cart();
        this.bonuses = 0;
    }

    @Override
    public void recharge(double sum) {
        this.balance += sum;
        this.bonuses += (int) sum * 0.03;
        System.out.println(this.surname + " " + this.name + ". " + "Ваш баланс поповнено на: " + sum + " грн. Сума на балансі: " + this.balance + ". Бонуси: " + this.bonuses);
    }

    public void showBonuses(){
        System.out.println(this.surname + " " + this.name + ". " + "Ваші бонуси: " + this.bonuses);
    }

    public void takeBonuses(){
        if (this.bonuses != 0){
            this.balance += this.bonuses;
            System.out.println(this.surname + " " + this.name + ". " + "Було знято " + this.bonuses + " бонусних гривень." +  "Баланс: " + this.balance);
        }
        else {
            System.out.println(this.surname + " " + this.name + ". " + "У вас 0 бонусних гривень");
        }
    }

    public int getBonuses() {
        return bonuses;
    }

    public void setBonuses(int bonuses) {
        this.bonuses = bonuses;
    }
}
