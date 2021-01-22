package ru.geekbrains.java_two.chat.client;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Setting extends JFrame implements ActionListener {

    private static final int WINDOW_WIDTH = 400;
    private static final int WINDOW_HEIGHT = 80;
    private ClientGUI client;

    private final JPanel panelTop = new JPanel(new GridLayout(1, 2));
    private final JPanel panelBottom = new JPanel(new GridLayout(1, 2));
    private final JTextField tfNickname = new JTextField();
    private final JButton btnChange = new JButton("Change nickname");

    Setting( ClientGUI client ){

        this.client = client;
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);

        Rectangle gameWindowBounds = client.getBounds();
        int posX = (int) gameWindowBounds.getCenterX() - WINDOW_WIDTH / 2;
        int posY = (int) gameWindowBounds.getCenterY() - WINDOW_HEIGHT / 2;
        setResizable(false);
        setTitle("Settings new game");
        setLocation(posX, posY);
        btnChange.addActionListener(this);
        add(new JLabel("Change nickname:"));
        panelTop.add(new JLabel("new nickname"));
        panelTop.add(new JLabel(""));
        panelBottom.add(tfNickname);
        panelBottom.add(btnChange);
        add(panelTop, BorderLayout.NORTH);
        add(panelBottom, BorderLayout.SOUTH);

        setVisible(false);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object src = e.getSource();
        if (src == btnChange) {
           client.changeNickname(tfNickname.getText());
           setVisible(false);
        }
        else {
            throw new RuntimeException("Undefined source: " + src);
        }
    }
}
