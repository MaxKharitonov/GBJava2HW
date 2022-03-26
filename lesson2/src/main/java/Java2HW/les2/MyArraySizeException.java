package Java2HW.les2;

import java.io.IOException;

public class MyArraySizeException {
    int row, column;

    public MyArraySizeException(int row, int column) throws IOException {
        if (row != 4 || column != 4)
            throw new IOException("Исключение: Значения строк и столбцов могут быть равны только 4." + "\nВведенные значения: строк: " + row + ", столбцов: " + column + "\nПродолжаю работу: Задан размер массива: строк: " + row + ", столбцов." + column);
        this.row = row;
        this.column = column;
    }
}
