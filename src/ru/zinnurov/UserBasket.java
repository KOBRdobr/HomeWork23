package ru.zinnurov;

import java.util.*;

/**
 * @author Nail Zinnurov
 * cobratms@gmail.com
 * on 26.10.2018
 */

public class UserBasket implements Basket {

    List<String> selectedProduct = new ArrayList<>();

    @Override
    public void addProduct(String product, int quantity) {
        selectedProduct.add(product);
        selectedProduct.add(String.valueOf(quantity));
    }

    @Override
    public void removeProduct(String product) {

    }

    @Override
    public void updateProductQuantity(String product, int quantity) {

    }

    @Override
    public void clear() {
        selectedProduct.clear();
    }

    @Override
    public List<String> getProducts() {
        return selectedProduct;
    }

    @Override
    public int getProductQuantity(String product) {
        return 0;
    }
}
