package Market;

import Market.config.MyConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MyConfig.class);
        Scanner scanner = context.getBean(Scanner.class);
        MyCart myCart = context.getBean(MyCart.class);
        ProductRepository productRepository = context.getBean(ProductRepository.class);
        boolean exit = true;
        myCart.removeProduct(0);

        while (exit) {
            if (myCart.getSizeList() == 0) {
                System.out.println("В вашей корзине " + myCart.getSizeList() + " товаров");
            } else  if (myCart.getSizeList() == 1) {
                System.out.println("В вашей корзине " + myCart.getSizeList() + " товар");
            } else if (myCart.getSizeList() > 1 && myCart.getSizeList() < 5) {
                System.out.println("В вашей корзине " + myCart.getSizeList() + " товара");
            } else {
                System.out.println("В вашей корзине " + myCart.getSizeList() + " товаров");
            }
            System.out.println("----------------------------------------");
            if (myCart.getSizeList() > 0) {
                myCart.getAllProductListForCart();
                System.out.println("----------------------------------------");
            }
            System.out.println("1. Добавить товары в корзину.");
            System.out.println("2. Удалить товары из корзины.");
            System.out.println("3. Выйти из магазина.");
            int input = scanner.nextInt();
            if (input < 1 || input > 3) {
                System.out.println("Не верное значение. Попробуйте еще раз.");
                System.out.println("----------------------------------------");
                continue;
            }
            switch (input) {
                case 1:
                    System.out.println("Выбирете id товара интересующего вас для добавления в корзину.");
                    productRepository.getAllProduct();
                    int input2 = scanner.nextInt();
                    myCart.addProduct(input2);
                    break;
                case 2:
                    if (myCart.getSizeList() < 1) {
                        System.out.println("Ваша корзина пустая. Удалять нечего.");
                    }
                    System.out.println("Выбирете id товара для удаления из корзины.");
                    myCart.getAllProductListForCart();
                    int input3 = scanner.nextInt();
                    myCart.removeProduct(input3);
                    break;
                case 3:
                    System.out.println("До свидания. Приходите еще.");
                    exit = false;
                    break;
            }
        }
    }
}