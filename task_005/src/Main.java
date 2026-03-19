import java.util.Scanner;

//Завдання 5
//Створіть проєкт за допомогою IntelliJ IDEA. Створіть клас Calculator. У тілі класу створіть чотири методи для
//арифметичних дій: (add – додавання, sub – віднімання, mul – множення, div – поділ). Метод поділу повинен перевірити
//поділ на нуль, якщо перевірка не проходить, згенерувати виняток. Користувач вводить значення, над якими хоче зробити
//операцію та вибрати саму операцію. У разі виникнення помилок повинні викидатися винятки.
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Calculator calculator = new Calculator();

        try {
            System.out.println("Введіть перше число: ");
            double a = Double.parseDouble(scanner.nextLine());
            System.out.println("Введіть друге число: ");
            double b = Double.parseDouble(scanner.nextLine());
            System.out.println("Оберіть операцію (+, -, *, /)");
            String operation = scanner.nextLine().trim();
            double result;

            switch (operation) {
                case "+":
                    result = calculator.add(a, b);
                    break;
                case "-":
                    result = calculator.sub(a, b);
                    break;
                case "*":
                    result = calculator.mul(a, b);
                    break;
                case "/":
                    result = calculator.div(a, b);
                    break;
                default:
                    throw new IllegalArgumentException("Невідома операція: " + operation);
            }
            System.out.println("Результат: " + result);
        } catch (NumberFormatException e) {
            System.out.println("Помилка: введено не число.");
        } catch (ArithmeticException e) {
            System.out.println("Помилка: " + e.getMessage());
        }
    }
}
