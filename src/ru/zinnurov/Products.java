package ru.zinnurov;

import java.util.ArrayList;
import java.util.List;

/**
 * Class store products store
 *
 * @author Nail Zinnurov
 * cobratms@gmail.com
 * on 23.10.2018
 */

public class Products {
    List<String> goods = new ArrayList<>();

    public Products() {
        goods.add("Bread");
        goods.add("Milk");
        goods.add("Vegetables");
    }

    public List<String> getGoods() {
        return goods;
    }

    public void showProducts() {
        for (int i = 0; i < goods.size(); i++) {
            System.out.println((i + 1) + ". " + goods.get(i));
        }
    }
}
