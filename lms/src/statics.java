import net.proteanit.sql.DbUtils;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class statics extends JFrame implements ActionListener {

    JPanel contentPane;
    JTable table;
    JTable table_1;
    JButton b1;

    public void issueBook() {
        try {
            conn con =  new conn();
            String sql = "select * from IssueBook";
            PreparedStatement st = con.c.prepareStatement(sql);
            ResultSet rs = st.executeQuery();

            table.setModel(DbUtils.resultSetToTableModel(rs));

        } catch (Exception e) {

        }
    }

    public void returnBook() {
        try {
            conn con = new conn();
            String sql = "select * from ReturnBok";
            PreparedStatement st = con.c.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            table_1.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (Exception e) {

        }
    }

    statics(){

        setTitle("LMS-STATICS");
        setBounds(400, 200, 810, 594);
        contentPane = new JPanel();
        contentPane.setBackground(Color.WHITE);
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("images/bacK2.jpg"));
        Image i2 = i1.getImage().getScaledInstance(800, 600, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l2 = new JLabel(i3);
        l2.setBounds(0, 0, 800, 600);
        contentPane.add(l2);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(40, 51, 708, 217);
        l2.add(scrollPane);

        table = new JTable();
        table.setBackground(new Color(224, 255, 255));
        table.setForeground(new Color(128, 128, 0));
        table.setFont(new Font("Trebuchet MS", Font.BOLD, 15));
        scrollPane.setViewportView(table);

        JPanel panel = new JPanel();
        panel.setBorder(new TitledBorder(new LineBorder(new Color(47, 79, 79), 2, true), "Issue-Book-Details",
                TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 128, 128)));
        panel.setForeground(new Color(0, 128, 128));
        panel.setBounds(26, 36, 737, 240);
        panel.setBackground(Color.WHITE);
        l2.add(panel);

        JScrollPane scrollPane_1 = new JScrollPane();
        scrollPane_1.setBounds(40, 316, 717, 217);
        l2.add(scrollPane_1);

        table_1 = new JTable();
        table_1.setBackground(new Color(204, 255, 255));
        table_1.setForeground(new Color(153, 51, 0));
        table_1.setFont(new Font("Sitka Small", Font.BOLD, 12));
        scrollPane_1.setViewportView(table_1);

        JPanel panel_1 = new JPanel();
        panel_1.setBorder(new TitledBorder(new LineBorder(new Color(0, 204, 153), 2, true), "Return-Book-Details",
                TitledBorder.RIGHT, TitledBorder.TOP, null, new Color(0, 102, 51)));
        panel_1.setBounds(22, 299, 741, 240);
        panel_1.setBackground(Color.WHITE);
        l2.add(panel_1);

        b1 = new JButton("Back");
        b1.addActionListener(this);
        b1.setFont(new Font("Arial", Font.BOLD, 15));
        b1.setBorder(new LineBorder(new Color(0, 0, 0), 0, true));
        b1.setBounds(690,10,75,24);
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        l2.add(b1);

        issueBook();
        returnBook();

        setLocation(200,100);
        setLayout(null);
        setSize(800, 600);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            if (e.getSource() == b1) {
                this.setVisible(false);
                new eg().setVisible(true);
            }
        } catch (Exception e6) {

        }
    }
    public static void main(String[] args) {
        new statics();
    }
}
