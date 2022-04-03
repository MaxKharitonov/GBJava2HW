package Java2HW.lesson4;

import javax.swing.*;
import java.awt.*;

public class MyWindow extends JFrame {

    JTextArea textArea;
    JTextField textMessage;

    public MyWindow() {
        setTitle("Main"); //название
        setBounds(800, 300, 400, 400);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        JPanel centerPanel = new JPanel(); // Верхняя часть
        add(centerPanel, BorderLayout.CENTER);
        centerPanel.setBackground(Color.gray);
        centerPanel.setLayout(new BorderLayout());

        JPanel bottomPanel = new JPanel(); // Нижняя
        add(bottomPanel, BorderLayout.SOUTH);
        bottomPanel.setBackground(Color.darkGray);
        bottomPanel.setPreferredSize(new Dimension(1, 40));
        bottomPanel.setLayout(new BorderLayout());

        JButton startButton = new JButton("Отправить"); // Добавление кнопки
        bottomPanel.add(startButton, BorderLayout.EAST);

        textArea = new JTextArea();
        JScrollPane textAreaScroll = new JScrollPane(textArea); // прокрутка
        centerPanel.add(textAreaScroll, BorderLayout.CENTER);
        textArea.setEditable(false); // ограничение на ввод текста

        textMessage = new JTextField(); // поле ввода
        bottomPanel.add(textMessage, BorderLayout.CENTER);

        startButton.addActionListener(e -> addText());

        textMessage.addActionListener(e -> addText());

        setVisible(true); // видимость окна
    }
    void addText() {
        textArea.append(textMessage.getText()+"\n");
        textMessage.setText("");
    }
}
