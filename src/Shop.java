import ru.zinnurov.Product;
import ru.zinnurov.ProductType;
import ru.zinnurov.UserBasket;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author Nail Zinnurov
 * cobratms@gmail.com
 * on 09.10.2018
 */

public class Shop {

    public static void main(String[] args) {
        System.out.println("Welcome!");
        System.out.println("Select the desired action.");
        while(chooseAction() <= 2) {}

    }

    private static int chooseAction() {
        System.out.println("1. Show product list");
        System.out.println("2. Show my cart");
        System.out.println("3. Exit");

        int choice = input();

        switch (choice) {
            case 1:
                showTypeProducts();
                break;

            case 2:
                showMenuCart();
                break;

            default:
                System.out.println("Goodbye!");
        }
        return  choice;
    }

    private static void showTypeProducts() {

        System.out.println();
        System.out.println("Choose product type to buy");
        ProductType[] productType = ProductType.values();
        for (int i = 0; i < productType.length; i++) {
            System.out.println((i + 1) + ". " + productType[i].getTypeName());
        }
        int choice = input();
        showProducts(productType, choice);
    }

    private static void showProducts(ProductType[] productType, int choice) {

        System.out.println();
        System.out.println("Choose product to buy");

        if(choice >= 0 && choice < productType.length) {
            List<Product> productList = getProducts();
            List<Integer> indexProduct = new ArrayList<>();

            int k = 1;
            for (int i = 0; i < productList.size(); i++) {
                if(productType[choice - 1].equals(productList.get(i).getType())) {
                    System.out.println(k + ". " + productList.get(i).getName());
                    indexProduct.add(i);
                    k++;
                }
            }

            chooseProduct(productList, indexProduct,k);
        }
    }

    private static void chooseProduct(List<Product> productList, List<Integer> indexProduct, int k) {
        int choice = input();
        if(choice > k) {
            System.out.println("This product is not available");

        }
        else {
            System.out.println("How many products do you need?");
            int quantity = input();
            UserBasket userBasket = new UserBasket();
            userBasket.addProduct(productList.get(indexProduct.get(choice - 1)).getName(), quantity);
        }
    }

    private static void showMenuCart() {
        System.out.println("1. Remove product");
        System.out.println("2. Clear basket");
        System.out.println();
        showSelectedProducts();

        int choice = input();
        UserBasket userBasket = new UserBasket();
        switch (choice) {
            case 1:
                //userBasket.removeProduct();
        }


    }

    private static void showSelectedProducts() {
        List<String> selectedProd = userBasket.getProducts();

        for (int i = 0; i < selectedProd.size(); i++) {
            System.out.println((i + 1) + ". " + selectedProd.get(i));
        }
    }

    private static List<Product> getProducts() {
        List<Product> productList = new ArrayList<>();
        productList.add(new Product(ProductType.BREAD, "Brown tommy"));
        productList.add(new Product(ProductType.MILK, "Soy Milk"));
        productList.add(new Product(ProductType.VEGETABLES, "Potato"));
        productList.add(new Product(ProductType.BREAD, "Wheat bread"));
        productList.add(new Product(ProductType.MILK, "Oat Milk"));
        productList.add(new Product(ProductType.VEGETABLES, "Tomato"));

        return productList;
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
