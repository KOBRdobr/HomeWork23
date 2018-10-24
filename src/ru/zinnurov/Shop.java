package ru.zinnurov;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

/**
 * Class that implements the basket interface
 *
 * @author Nail Zinnurov
 * cobratms@gmail.com
 * on 23.10.2018
 */

public class Shop implements Basket{
    List<String> products = new ArrayList<>();;

    @Override
    public void addProduct(int choice, int quantity, Products nameProducts) {

        for (int i = 0; i < quantity; i++) {
            getProducts().add(nameProducts.getGoods().get(choice - 1));
        }
        System.out.println("Done!");
        System.out.println();
    }

    @Override
    public void removeProduct(String product) {
        Iterator<String> iterator = products.iterator();
        while (iterator.hasNext()) {
            if(product == iterator.next()) iterator.remove();
        }
    }

    @Override
    public void updateProductQuantity(String product, int quantity) {

    }

    @Override
    public void clear() {
        getProducts().clear();
        System.out.println("Basket cleared");
    }

    @Override
    public List<String> getProducts() {
        return products;
    }

    @Override
    public int getProductQuantity(String product) {
        int quanity = 0;
        for (int i = 0; i < getProducts().size(); i++) {
            if(product == getProducts().get(i)) quanity++;
        }

        return quanity;
    }

    public int showWelcomeMenu() {
        System.out.println("1. List if goods");
        System.out.println("2. Show Cart");
        System.out.println("3. Exit");

        return chooseMenu();
    }

    private int chooseMenu() {
        int choice = input();

        switch (choice) {
            case 1:
                listGoods();
                break;

            case 2:
                showBasketMenu();
                break;

            default:
                System.out.println("Goodbye!");
        }
        return  choice;
    }

    private void listGoods() {
        Products products = new Products();
        products.showProducts();

        System.out.println("Select the desired item.");
        int choiceProduct = input();

        System.out.println("Enter the quantity.");
        int quantityProduct = input();

        addProduct(choiceProduct, quantityProduct, products);

    }

    private void showBasketMenu() {
        if(getProducts().size() != 0) {

            System.out.println("1. Remove product");
            System.out.println("2. Clear basket");
            System.out.println("3. Show my basket");

            int choice = input();
            List<String> list = new ArrayList<>();
            showSelectedProducts(list);

            switch (choice) {
                case 1:
                    choice = input();
                    removeProduct(list.get(choice - 1));
                    break;

                case 2:
                    clear();
                    System.out.println("Done!");
                    break;

            }
        } else System.out.println("Basket is empty!\n");
    }

    private void showSelectedProducts(List<String> list) {
        Products products = new Products();
        int productQuanity;

        System.out.println("___________________________________");
        for (int i = 0; i < products.getGoods().size(); i++) {
            productQuanity = getProductQuantity(products.getGoods().get(i));
            if(productQuanity != 0) {
                list.add(products.getGoods().get(i));
                System.out.println((i + 1) + ")" + products.getGoods().get(i) + ": " + productQuanity);
            }
        }
        System.out.println("___________________________________");
    }

    private static int input() {
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
