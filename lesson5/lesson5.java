package Java2HW.lesson5;

import java.util.Arrays;

public class lesson5 {
    static final int size = 10000000; // Объявление длины для массива
    static float[] arr = new float[size]; // Объявление массива

    public static void main(String[] args) {
        System.out.println("Начало программы.");
        oneThread(arr);
        twoThreads(arr);
        System.out.println("Завершение программы.");
    }

    public static void oneThread(float[] arr) {
        Arrays.fill(arr, 1.0f); // Заполнение массива
        long start = System.currentTimeMillis(); // Начало отсчета времени
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (float) (arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2)); // Подсчет значений
        }
        System.out.println("Время выполнения метода с одним потоком равно: " + (System.currentTimeMillis() - start) + " мс."); // Вывод результата
    }

    public static void twoThreads(float[] arr) {
        final int half = size / 2;
        Arrays.fill(arr, 1.0f);
        long start = System.currentTimeMillis();
        float[] left = new float[(int) half];
        float[] right = new float[(int) half];
        System.arraycopy(arr, 0, left, 0, half); /* Деление основного массива на половины
        arr - основной массив. 0 - индекс основного массива, с которого берутся элементы.
        left - принимающий массив. 0 - индекс принимающего массива, с которого записываются элементы.
        half - количество, копируемых элементов */
        System.arraycopy(arr, half, right, 0, half);
        System.out.println("Время выполнения разбивки массива равно: " + (System.currentTimeMillis() - start) + " мс.");

        Thread thread1 = new Thread(() -> { // Первый поток
            long threadOneStart = System.currentTimeMillis();
            for (int i = 0; i < left.length; i++) {
                left[i] = (float) (left[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
            }
            System.out.println("Время выполнения просчета в первом потоке равно: " + (System.currentTimeMillis() - threadOneStart) + " мс.");
        });

        Thread thread2 = new Thread(() -> { // Второй поток
            long threadTwoStart = System.currentTimeMillis();
            for (int i = 0; i < right.length; i++) {
                right[i] = (float) (right[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
            }
            System.out.println("Время выполнения просчета во втором потоке равно: " + (System.currentTimeMillis() - threadTwoStart) + " мс.");
        });

        thread1.start();
        thread2.start();
        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        float[] newArr = new float[size];
        long unionStart = System.currentTimeMillis();
        System.arraycopy(left, 0, newArr, 0, half);
        System.arraycopy(right, 0, newArr, half, half);
        System.out.println("Время выполнения объединения массивов равно: " + (System.currentTimeMillis() - unionStart) + " мс.");
        System.out.println("Общее время выполнения метода с двумя потоками равно: " + (System.currentTimeMillis() - start) + " мс.");
    }
}
