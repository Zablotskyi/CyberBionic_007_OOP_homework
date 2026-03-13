import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

//Завдання 2
//Створіть проєкт за допомогою IntelliJ IDEA. Потрібно: Описати клас з ім'ям Worker, що містить такі поля:
//  прізвище та ініціали працівника;
//  назва посади;
//  рік надходження на роботу.
//Написати програму, яка виконує такі дії:
//  введення з клавіатури даних до масиву, що складається з п'яти елементів типу Worker (записи мають бути
//впорядковані за абеткою);
//  якщо значення року введено не у відповідному форматі, видає виняток.
//  виведення на екран прізвища працівника, стаж роботи якого перевищує введене значення.
public class Main {
    static class InvalidYearException extends Exception {
        public InvalidYearException(String message) {
            super(message);
        }
    }

    static Worker[] workers = new Worker[2];

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < workers.length; i++) {
            workers[i] = createWorker();
        }
        System.out.println("Введіть мінімальний стаж роботи у роках (ціле число): ");
        short minExperience = scanner.nextShort();

        Arrays.sort(workers, Comparator.comparing(Worker::getPib));
        employeesWhoseExperienceIsMoreThanYears(workers, minExperience);
    }

    public static Worker createWorker() {
        Scanner scanner = new Scanner(System.in);
        Worker worker = new Worker();

        System.out.println("Введіть прізвище та ініціали співробітника: ");
        worker.setPib(scanner.nextLine());

        System.out.println("Введіть посаду співробітника: ");
        worker.setPosition(scanner.nextLine());

        while (true) {
            System.out.println("Введіть рік працевлаштування працівника (YYYY): ");
            String yearStr = scanner.nextLine();

            try {
                worker.setYear(enterValidYear(yearStr));
                break;
            } catch (InvalidYearException e) {
                System.out.println("Помилка: " + e.getMessage());
            }
        }
        return worker;
    }

    public static short enterValidYear(String year) throws InvalidYearException {
        if (!year.matches("\\d{4}")) {
            throw new InvalidYearException("Рік має бути числом з 4 цифр (наприклад 2018). Ви ввели: " + year);
        }
        return Short.parseShort(year);
    }

    public static void employeesWhoseExperienceIsMoreThanYears(Worker[] workers, short year) {
        Worker[] temp = new Worker[workers.length];
        System.out.println("Співробітники (відсортовані у алфавітному порядку), у котрих стаж роботи більше ніж " + year + " років: ");
        for (int i = 0; i < workers.length; i++) {
            if (2026 - workers[i].getYear() > year) {
                System.out.println(workers[i]);
                temp[i] = workers[i];
            }
        }
        if (temp[0] == null) {
            System.out.println(" відсутні!");
        }
    }
}
