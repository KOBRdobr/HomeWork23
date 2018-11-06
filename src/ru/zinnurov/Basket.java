package ru.zinnurov;

import java.util.List;

/**
 * @author Nail Zinnurov
 * cobratms@gmail.com
 * on 09.10.2018
 */
public interface Basket {
    void addProduct(Product product);

    void removeProduct(Product product);

    void updateProduct(Product product);

    void clear();

    List<Product> getProducts();
}
