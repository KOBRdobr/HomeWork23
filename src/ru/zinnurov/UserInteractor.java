package ru.zinnurov;

import java.util.List;
import java.util.Scanner;

import static ru.zinnurov.ActionType.*;

public class UserInteractor {
    private static final String WELCOME_MENU =
                    "Welcome!\n" +
                    "Select the desired action:\n" +
                    "1. Show product list\n" +
                    "2. Show my cart\n" +
                    "3. Exit";
    private static final String CART_ACTIONS_MENU =
                    "1. Remove product\n" +
                    "2. Clear basket\n" +
                    "3. Back\n";

    public ActionType showWelcomeMenu() {
        sendMessageToUser(WELCOME_MENU);

        ActionType action = null;
        int userInput = readIntFromConsole();
        switch (userInput) {
            case 1:
                action = SHOW_PRODUCTS;
                break;

            case 2:
                action = SHOW_CART;
                break;

            default:
                sendMessageToUser("Goodbye!");
                action = EXIT;
        }

        return action;
    }

    public ActionType showCartActionsMenu() {
        sendMessageToUser(CART_ACTIONS_MENU);

        ActionType action = null;
        int userInput = readIntFromConsole();
        switch (userInput) {
            case 1:
                action = REMOVE_PRODUCT;
                break;
            case 2:
                action = CLEAR_BASKET;
                break;
            default:
                action = BACK;
        }
        return action;
    }

    public Product showProductWantedToRemove(List<Product> products) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < products.size(); i++) {
            stringBuilder.append(i).append(". ")
                    .append(products.get(i).getName())
                    .append(" ")
                    .append(products.get(i).getType())
                    .append("\n");
        }
        sendMessageToUser(stringBuilder.toString());

        int indexOfProduct = readIntFromConsole();
        // TODO: add validation
        return products.get(indexOfProduct);
    }

    // TODO: add validation
    public Product showAllProductsMenu(List<Product> allProducts) {
        sendMessageToUser("Choose te product.\nAll products:");
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < allProducts.size(); i++) {
            stringBuilder.append(i).append(". ")
                    .append(allProducts.get(i).getName())
                    .append(" ")
                    .append(allProducts.get(i).getType())
                    .append("\n");
        }
        sendMessageToUser(stringBuilder.toString());

        int indexOfProduct = readIntFromConsole();
        Product chosenProduct = allProducts.get(indexOfProduct);

        sendMessageToUser("How much do you want?");
        int quantity = readIntFromConsole();

        // клонируем объект, чтобы в исходной коллекции он остался неизменным
        chosenProduct = new Product(
                chosenProduct.getType(),
                chosenProduct.getName(),
                quantity
        );

        return chosenProduct;
    }

    private void sendMessageToUser(String message) {
        System.out.println(message);
    }

    private int readIntFromConsole() {
        Scanner in = new Scanner(System.in);
        int result;

        while (true) {
            if (in.hasNextInt()) {
                result = in.nextInt();
                if (result != 0) break;
                else System.out.println("Enter numbers starting from 1!");
            } else {
                System.out.println("Enter the numbers!");
                in.next();
            }
        }

        return result;
    }
}
