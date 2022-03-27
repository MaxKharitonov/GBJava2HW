package Java2HW.les2;

public class PrintArr {
    String[][] strArr;
    int[][] intArr;

    public PrintArr(int[][] intArr) {
        this.intArr = intArr;
        for (int i = 0; i <= intArr[1].length; i++) {
            System.out.print(i + "| ");
        }
        System.out.println();
        for (int i = 0; i < intArr.length; i++) {
            System.out.print(i + 1 + "| ");
            for (int j = 0; j < intArr[i].length; j++) {
                System.out.print(intArr[i][j] + "; ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public PrintArr(String[][] strArr) {
        this.strArr = strArr;

        for (int i = 0; i <= strArr[1].length; i++) {
            System.out.print(i + "| ");
        }
        System.out.println();
        for (int i = 0; i < strArr.length; i++) {
            System.out.print(i + 1 + "| ");
            for (int j = 0; j < strArr[i].length; j++) {
                System.out.print(strArr[i][j] + "; ");
            }
            System.out.println();
        }
        System.out.println();
    }
}

