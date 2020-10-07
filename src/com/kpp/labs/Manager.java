package com.kpp.labs;

public interface Manager {
    void addProduct(Product product);
    void removeProduct(int id);
    void sortByName(boolean type);
    void sortBySize(boolean type);
    void sortByPrice(boolean type);
    void sortByColor(boolean type);
    void printListOfProducts();
}
