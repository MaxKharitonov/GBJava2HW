package Java2HW.lesson4;

import javax.swing.*;

public class lesson4 {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new MyWindow();
            }
        });
    }
}
