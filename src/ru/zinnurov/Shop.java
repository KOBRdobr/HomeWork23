package ru.zinnurov;


import java.util.ArrayList;
import java.util.List;

/**
 * @author Nail Zinnurov
 * cobratms@gmail.com
 * on 09.10.2018
 */

public class Shop {

    public static void main(String[] args) {
        System.out.println("Welcome!");
        System.out.println("Select the desired action.");

        Menu startMenu = new Menu();
        while(startMenu.chooseAction() <= 2) {}

    }

    public static List<Product> getProducts() {
        List<Product> productList = new ArrayList<>();
        productList.add(new Product(ProductType.BREAD, "Brown tommy"));
        productList.add(new Product(ProductType.MILK, "Soy Milk"));
        productList.add(new Product(ProductType.VEGETABLES, "Potato"));
        productList.add(new Product(ProductType.BREAD, "Wheat bread"));
        productList.add(new Product(ProductType.MILK, "Oat Milk"));
        productList.add(new Product(ProductType.VEGETABLES, "Tomato"));

        return productList;
    }

}
