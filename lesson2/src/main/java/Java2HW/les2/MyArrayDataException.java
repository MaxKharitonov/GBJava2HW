package Java2HW.les2;

class MyArrayDataException extends RuntimeException {
    int i, j;
     
    public MyArrayDataException(int i, int j) {
        super("Некорректный тип элемента массива по индексу: строка: " + (i + 1) + ", столбец: " + (j + 1));
        this.i = i;
        this.j = j;
    }
}
