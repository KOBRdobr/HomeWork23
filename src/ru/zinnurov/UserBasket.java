package ru.zinnurov;

import java.util.*;

/**
 * The class implements the interface Basket with List collection
 *
 * @author Nail Zinnurov
 * @version 1.0
 * cobratms@gmail.com
 * on 26.10.2018
 */
public class UserBasket implements Basket {

    private List<Product> selectedProduct = new ArrayList<>();

    @Override
    public void addProduct(Product product) {
        selectedProduct.add(product);
    }

    @Override
    public void removeProduct(Product product) {
        selectedProduct.remove(product);
        System.out.println("Product " + product + " was removed");
    }
    @Override
    public void updateProduct(Product product) {
        selectedProduct.set(selectedProduct.indexOf(product), product);
    }

    @Override
    public void clear() {
        selectedProduct.clear();
        System.out.println("Basket is cleared!");
    }

    @Override
    public List<Product> getProducts() {
        return selectedProduct;
    }

}
