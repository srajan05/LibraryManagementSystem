import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class loading extends JFrame implements Runnable {

    JPanel contentPane;
    JProgressBar progressBar;
    int s;
    Thread th;

    public static void main(String[] args) {
        new loading().setVisible(true);
    }

    public void setUploading() {
        setVisible(false);
        th.start();
    }

    public void run() {
        try {
            for (int i = 0; i < 200; i++) {
                s = s + 1;
                int m = progressBar.getMaximum();
                int v = progressBar.getValue();
                if (v < m) {
                    progressBar.setValue(progressBar.getValue() + 1);
                } else {
                    i = 201;
                   setVisible(false);
                    new eg().setVisible(true);
                }
                Thread.sleep(50);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public loading() {

        setTitle("LMS-LOADING");
        setBackground(new Color(255, 255, 204));
        th = new Thread((Runnable) this);

        setBounds(600, 300, 600, 400);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(179, 255, 153));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel l1 = new JLabel("Digital Library 1.0");
        l1.setForeground(new Color(255, 165, 00));
        l1.setFont(new Font("Trebuchet MS", Font.BOLD, 35));
        l1.setBounds(130, 46, 500, 35);
        contentPane.add(l1);

        progressBar = new JProgressBar();
        progressBar.setFont(new Font("Tahoma", Font.BOLD, 12));
        progressBar.setStringPainted(true);
        progressBar.setBounds(130, 135, 300, 25);
        contentPane.add(progressBar);

        JLabel l2 = new JLabel("Please Wait....");
        l2.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 20));
        l2.setForeground(new Color(255, 0, 0));
        l2.setBounds(225, 165, 150, 20);
        contentPane.add(l2);

        JPanel panel = new JPanel();
        panel.setBackground(new Color(255, 255, 179));
        panel.setBounds(0, 0, 590, 390);
        contentPane.add(panel);

        setUploading();
    }
}
