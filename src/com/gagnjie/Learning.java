package com.gagnjie;
import java.awt.*;
import java.awt.event.*;
import java.time.*;
import java.util.Arrays;
import javax.swing.*;

public class Learning {
    public static void main(String[] args) {
        var planets = new String[]{"Mercury", "Venus", "Earth", "Mars", "Jupiter", "Saturn", "Uranus", "Neptune"};
        System.out.println(Arrays.toString(planets));
        Arrays.sort(planets);
        System.out.println(Arrays.toString(planets));
        Arrays.sort(planets, (String first, String second) -> first.length() - second.length());
        System.out.println(Arrays.toString(planets));

        var listener = new TimePrinter();
        var timer = new Timer(1000, e -> {
            System.out.println("At the tone, the time is "+Instant.ofEpochMilli(e.getWhen()));
            Toolkit.getDefaultToolkit().beep();
        });
        timer.start();
        JOptionPane.showMessageDialog(null, "Quit program?");
        System.exit(0);
    }
}

class TimePrinter implements ActionListener{
    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("At the tone, the time is "+Instant.ofEpochMilli(e.getWhen()));
        Toolkit.getDefaultToolkit().beep();
    }
}
