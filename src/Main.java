import ru.zinnurov.Shop;


/**
 * @author Nail Zinnurov
 * cobratms@gmail.com
 * on 09.10.2018
 */

public class Main {
    public static void main(String[] args) {
        System.out.println("Welcome!");
        Shop shop = new Shop();

        while (shop.showWelcomeMenu() < 3) {}


    }
}
