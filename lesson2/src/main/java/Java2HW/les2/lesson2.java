package Java2HW.les2;

import java.io.IOException;
import java.util.Scanner;

public class lesson2 {
    public static void main(String[] args) {
        int row;
        int column;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите значения для двумерного массива."); // Запрос данных от пользователя
        System.out.println("Количество строк:");
        row = scanner.nextInt();
        System.out.println();
        System.out.println("Количество столбцов:");
        column = scanner.nextInt();
        try {
            new MyArraySizeException(row, column);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        System.out.println();
        String[][] newArray = new String[row][column];

        createArr(newArray, scanner); // Вызов метода для заполнения массива
        System.out.println("Сумма значений элементов массива = " + calcArr(newArray, row, column));
    }

    private static void createArr(String[][] array, Scanner scanner) { // Заполнение массива строк
        System.out.println("Заполните массив. ");
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                System.out.println("Строка: " + (i + 1) + " столбец: " + (j + 1));
                array[i][j] = scanner.next(); // Ввод элементов массива от пользователя
            }
        }
        System.out.println();
        System.out.println("Массив строк: ");
        new PrintArr(array); // Вызов метода печати заполненного массива строк
    }

    private static int calcArr(String[][] array, int row, int column) { // Приведение массива строк к массиву целых чисел
        // и подсчет суммы значений элементов массива
        int sum = 0;
        int[][] arrayInt = new int[row][column];
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                try {
                    arrayInt[i][j] = Integer.parseInt(array[i][j]); // Приведение массива строк к массиву целых чисел
                    sum += arrayInt[i][j]; // Подсчет суммы значений элементов массива
                } catch (NumberFormatException e) { // Вывод ошибки, если значение отличное от целого числа
                    System.out.println("Некорректный тип элемента массива по индексу: строка: " + (i + 1) + ", столбец: " + (j + 1));
                }
            }
        }
        System.out.println();
        System.out.println("Массив целых чисел: ");
        new PrintArr(arrayInt);
        return sum;
    }
}
