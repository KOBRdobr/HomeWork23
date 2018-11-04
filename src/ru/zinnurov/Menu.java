package ru.zinnurov;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * The Menu class implements a custom menu and product operations.
 *
 * @author Nail Zinnurov
 * @version 1.0
 * cobratms@gmail.com
 * on 03.11.2018
 */

public class Menu {
    Shop products = new Shop();
    UserBasket userBasket = new UserBasket();

    private ProductType[] productType;
    private List<Product> productList;
    private List<Integer> indexProduct;
    
    public int chooseAction() {
        System.out.println("1. Show product list");
        System.out.println("2. Show my cart");
        System.out.println("3. Exit");

        int choice = input();

        switch (choice) {
            case 1:
                workWithProducts();
                break;

            case 2:
                workWithCart();
                break;

            default:
                System.out.println("Goodbye!");
        }
        return  choice;
    }



    private void workWithCart() {
        System.out.println("1. Remove product");
        System.out.println("2. Clear basket");
        System.out.println("3. Back");

        int choice = input();
        if(choice == 1) remove();
        else if(choice == 2) userBasket.clear();

    }

    private void remove() {
        if(userBasket.getProducts().size() > 0) {
            showSelectedProducts();
            System.out.println("Select the product you want to remove");
            int choice = input();

            if (choice < userBasket.getProducts().size() && choice >= 1) userBasket.removeProduct(getProductToRemove(choice));
            else System.out.println("This product is not available");
        }
        else System.out.println("Basket is empty!");
    }

    private String getProductToRemove(int choice) {
        return userBasket.getProducts().get((choice - 1) * 2);
    }

    private void showSelectedProducts() {
        System.out.println();
        int k = 1;
        for (int i = 0; i < userBasket.getProducts().size() - 1; i+=2) {
            System.out.println(k + ". " + userBasket.getProducts().get(i) + ": " + userBasket.getProducts().get(i + 1));
            k++;
        }
        System.out.println();
    }



    private void workWithProducts() {
        showTypeProducts();
        showProducts();
        chooseProductToAdd();

    }

    private void showTypeProducts() {
        productType = ProductType.values();

        System.out.println();
        System.out.println("Choose product type");
        
        for (int i = 0; i < productType.length; i++) {
            System.out.println((i + 1) + ". " + productType[i].getTypeName());
        }
    }

    private void showProducts() {
        int choice = input();

        System.out.println();
        System.out.println("Choose product to buy");

        if(choice >= 0 && choice <= productType.length) {
            productList = products.getProducts();
            indexProduct = new ArrayList<>();

            int k = 1;
            for (int i = 0; i < productList.size(); i++) {
                if(productType[choice - 1].equals(productList.get(i).getType())) {
                    System.out.println(k + ". " + productList.get(i).getName());
                    indexProduct.add(i);
                    k++;
                }
            }
        }
    }

    private void chooseProductToAdd() {
        int choice = input();
        if(choice > indexProduct.size()) {
            System.out.println("This product is not available");

        }
        else {
            System.out.println("How many products do you need?");
            int quantity = input();
            userBasket.addProduct(productList.get(indexProduct.get(choice - 1)).getName(), quantity);
        }
    }



    private int input() {
        Scanner in = new Scanner(System.in);
        int choice;

        while (true) {
            if (in.hasNextInt()) {
                choice = in.nextInt();
                if (choice != 0) break;
                else System.out.println("Enter numbers starting from 1!");
            } else {
                System.out.println("Enter the numbers!");
                in.next();
            }
        }

        return choice;
    }
}


