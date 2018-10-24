package ru.zinnurov;

import java.util.List;

/**
 * @author Nail Zinnurov
 * cobratms@gmail.com
 * on 09.10.2018
 */

public interface Basket {
    void addProduct(int choice, int quantity, Products nameProducts);

    void removeProduct(String product);

    void updateProductQuantity(String product, int quantity);

    void clear();

    List<String> getProducts();

    int getProductQuantity(String product);
}
