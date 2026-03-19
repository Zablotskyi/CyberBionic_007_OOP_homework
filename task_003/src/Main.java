import java.sql.Array;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

//Завдання 3
//Створіть проєкт за допомогою IntelliJ IDEA. Потрібно: Описати клас з іменем Price, що містить такі поля:
//  назву товару;
//  назву магазину, в якому продається товар;
//  вартість товару у гривнях.
// Написати програму, яка виконує такі дії:
//  введення з клавіатури даних до масиву, що складається з двох елементів типу Price (записи мають бути впорядковані
// в алфавітному порядку за назвами магазинів);
//  виведення на екран інформації про товари, що продаються в магазині, назва якого введена з клавіатури (якщо такого
// магазину немає, вивести виняток).
public class Main {
    private static final Price[] arrayPrice = new Price[2];
    private static int count = 0;

    public static void main(String[] args) {
        Price price;

        for (int i = 0; i < 2; i++) {
            Scanner scanner = new Scanner(System.in);
            price = new Price();
            System.out.println("Введіть назва товару: ");
            price.setName(scanner.nextLine());
            System.out.println("Введіть магазин в якому продається товар: ");
            price.setStore(scanner.nextLine());
            System.out.println("Введіть ціну товару: ");
            price.setPrice(scanner.nextInt());
            addPrice(price);
        }
        sortArray(arrayPrice);
        System.out.println("Створено такий список товарів: ");
        showPrice(arrayPrice);
        findProductByStoreName();
    }

    private static void findProductByStoreName() {
        Scanner scanner = new Scanner(System.in);
        String nameStore;
        while (true) {
            System.out.println("Введіть назву магазину для виводу списку товарів: ");
            nameStore = scanner.nextLine();

            try {
                boolean found = false;
                for (Price item : arrayPrice) {
                    if (item.getStore().equals(nameStore)) {
                        System.out.println(item);
                        found = true;
                    }
                }

                if (!found) {
                    throw new InvalidStoreName("Такого магазину не існує");
                }
            } catch (InvalidStoreName e) {
                System.out.println("Помилка: " + e.getMessage());
            }
        }
    }

    private static void addPrice(Price price) {
        arrayPrice[count] = price;
        count++;
    }

    private static void sortArray(Price[] arrayPrice) {
        Arrays.sort(arrayPrice, Comparator.comparing(Price::getName));
    }

    private static void showPrice(Price[] arrayPrice) {
        for (Price item : arrayPrice) {
            System.out.println(item);
        }
    }
}
