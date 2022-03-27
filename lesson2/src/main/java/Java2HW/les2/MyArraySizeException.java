package Java2HW.les2;

public class MyArraySizeException extends RuntimeException {
    int row, column;

    public MyArraySizeException(int row, int column) {
        super("Ошибка: Значения строк и столбцов могут быть равны только 4." + "\nВведенные значения: строк: " + row + ", столбцов: " + column);
        this.row = row;
        this.column = column;
    }
}
