package com.java8;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class MyWindowMain {

    public static void main(String[] args) {
        // Window: JFrame Object

        JFrame frame = new JFrame("MyWindow");

        frame.setSize(400, 400);

        frame.setLayout(new FlowLayout());

        // Create button and add Jframe

        JButton button = new JButton("Click Me!!");

//        button.addActionListener(new AbstractAction() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                System.out.println("Button is Clicked!");
//                JOptionPane.showMessageDialog(null, "Hey, Button is Clicked!!😊😊");
//            }
//        });

        button.addActionListener((ActionEvent e) -> {
            System.out.println("Button is Clicked!");
            JOptionPane.showMessageDialog(null, "Hey, Button is Clicked!!😊😊");
        });
        frame.add(button);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setVisible(true);
    }

}
