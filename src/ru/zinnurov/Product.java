package ru.zinnurov;


/**
 * In the class Product is stored the type and name of the product.
 *
 * @author Nail Zinnurov
 * @version 1.0
 * cobratms@gmail.com
 * on 26.10.2018
 */
public class Product {
    private final ProductType type;
    private final String name;
    private final int quantity;

    public Product(ProductType type, String name, int quantity) {
        this.type = type;
        this.name = name;
        this.quantity = quantity;
    }

    public ProductType getType() {
        return type;
    }

    public String getName() {
        return name;
    }

    public int getQuantity() {
        return quantity;
    }

    @Override
    public String toString() {
        return "Product{" +
                "type=" + type +
                ", name='" + name + '\'' +
                ", quantity=" + quantity +
                '}';
    }
}
