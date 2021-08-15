import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class IssueBook extends JFrame implements ActionListener {

    JPanel contentPane;
    JDateChooser dateChooser;
    JTextField t1,t2,t3,t4,t5,t6,t7,t8,t9,t10,t11,t12,t13,t14;
    JButton b1,b2,b3,b4;

    IssueBook(){
        setTitle("LMS-ISSUE BOOK");
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setBackground(Color.ORANGE);
        contentPane.setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("images/bacKfront.jpg"));
        Image i2 = i1.getImage().getScaledInstance(800, 500, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l111 = new JLabel(i3);
        l111.setBounds(0, 0, 800, 500);
        contentPane.add(l111);

        JLabel l1 = new JLabel("Book Id");
        l1.setFont(new Font("Raleway", Font.BOLD, 14));
        l1.setForeground(new Color(47, 79, 79));
        l1.setBounds(47, 63, 100, 23);
        l111.add(l1);

        JLabel l2 = new JLabel("Name");
        l2.setForeground(new Color(47, 79, 79));
        l2.setFont(new Font("Raleway", Font.BOLD, 14));
        l2.setBounds(47, 97, 100, 23);
        l111.add(l2);

        JLabel l3 = new JLabel("ISBN");
        l3.setForeground(new Color(47, 79, 79));
        l3.setFont(new Font("Raleway", Font.BOLD, 14));
        l3.setBounds(47, 131, 100, 23);
        l111.add(l3);

        JLabel l4 = new JLabel("Publisher");
        l4.setForeground(new Color(47, 79, 79));
        l4.setFont(new Font("Raleway", Font.BOLD, 14));
        l4.setBounds(47, 165, 100, 23);
        l111.add(l4);

        JLabel l5 = new JLabel("Edition");
        l5.setForeground(new Color(47, 79, 79));
        l5.setFont(new Font("Raleway", Font.BOLD, 14));
        l5.setBounds(47, 199, 100, 23);
        l111.add(l5);

        JLabel l6 = new JLabel("Price");
        l6.setForeground(new Color(47, 79, 79));
        l6.setFont(new Font("Raleway", Font.BOLD, 14));
        l6.setBounds(47, 233, 100, 23);
        l111.add(l6);

        JLabel l7 = new JLabel("Pages");
        l7.setForeground(new Color(47, 79, 79));
        l7.setFont(new Font("Raleway", Font.BOLD, 14));
        l7.setBounds(47, 267, 100, 23);
        l111.add(l7);

        t1 = new JTextField();
        t1.setForeground(new Color(47, 79, 79));
        t1.setFont(new Font("Arial", Font.BOLD, 14));
        t1.setBounds(126, 66, 86, 20);
        l111.add(t1);

        b1 = new JButton("Search");
        b1.setBorder(new LineBorder(new Color(192, 192, 192), 1, true));
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        b1.setFont(new Font("Arial", Font.BOLD, 14));
        b1.setBounds(234, 59, 100, 30);

        l111.add(b1);

        t2 = new JTextField();
        t2.setEditable(false);
        t2.setForeground(new Color(47, 79, 79));
        t2.setFont(new Font("Arial", Font.BOLD, 14));
        t2.setBounds(126, 100, 208, 20);
        l111.add(t2);
        t2.setColumns(10);

        t3 = new JTextField();
        t3.setEditable(false);
        t3.setForeground(new Color(47, 79, 79));
        t3.setFont(new Font("Arial", Font.BOLD, 14));
        t3.setColumns(10);
        t3.setBounds(126, 131, 208, 20);
        l111.add(t3);

        t4 = new JTextField();
        t4.setEditable(false);
        t4.setForeground(new Color(47, 79, 79));
        t4.setFont(new Font("Arial", Font.BOLD, 14));
        t4.setColumns(10);
        t4.setBounds(126, 168, 208, 20);
        l111.add(t4);

        t5 = new JTextField();
        t5.setEditable(false);
        t5.setForeground(new Color(47, 79, 79));
        t5.setFont(new Font("Arial", Font.BOLD, 14));
        t5.setColumns(10);
        t5.setBounds(126, 202, 208, 20);
        l111.add(t5);

        t6 = new JTextField();
        t6.setEditable(false);
        t6.setForeground(new Color(47, 79, 79));
        t6.setFont(new Font("Arial", Font.BOLD, 14));
        t6.setColumns(10);
        t6.setBounds(126, 236, 208, 20);
        l111.add(t6);

        t7 = new JTextField();
        t7.setEditable(false);
        t7.setForeground(new Color(47, 79, 79));
        t7.setFont(new Font("Arial", Font.BOLD, 14));
        t7.setColumns(10);
        t7.setBounds(126, 270, 208, 20);
        l111.add(t7);

        JPanel panel = new JPanel();
        panel.setBorder(new TitledBorder(new LineBorder(new Color(47, 79, 79), 2, true), "Issue-Book",
                TitledBorder.LEADING, TitledBorder.TOP, null, new Color(34, 139, 34)));
        panel.setFont(new Font("Raleway", Font.BOLD, 14));
        panel.setBounds(25, 38, 345, 288);
        panel.setBackground(Color.WHITE);
        l111.add(panel);

        JLabel l8 = new JLabel("Student Id");
        l8.setForeground(new Color(47, 79, 79));
        l8.setFont(new Font("Raleway", Font.BOLD, 14));
        l8.setBounds(400, 63, 100, 23);
        l111.add(l8);

        JLabel l9 = new JLabel("Name");
        l9.setForeground(new Color(47, 79, 79));
        l9.setFont(new Font("Raleway", Font.BOLD, 14));
        l9.setBounds(400, 103, 100, 23);
        l111.add(l9);

        JLabel l10 = new JLabel("Father's Name");
        l10.setForeground(new Color(47, 79, 79));
        l10.setFont(new Font("Raleway", Font.BOLD, 14));
        l10.setBounds(400, 147, 150, 23);
        l111.add(l10);

        JLabel l11 = new JLabel("Course");
        l11.setForeground(new Color(47, 79, 79));
        l11.setFont(new Font("Raleway", Font.BOLD, 14));
        l11.setBounds(400, 187, 100, 23);
        l111.add(l11);

        JLabel l12 = new JLabel("Branch");
        l12.setForeground(new Color(47, 79, 79));
        l12.setFont(new Font("Raleway", Font.BOLD, 14));
        l12.setBounds(400, 233, 100, 23);
        l111.add(l12);

        JLabel l13 = new JLabel("Semester");
        l13.setForeground(new Color(47, 79, 79));
        l13.setFont(new Font("Raleway", Font.BOLD, 14));
        l13.setBounds(400, 284, 100, 23);
        l111.add(l13);

        t8 = new JTextField();
        t8.setForeground(new Color(47, 79, 79));
        t8.setFont(new Font("Arial", Font.BOLD, 14));
        t8.setColumns(10);
        t8.setBounds(508, 66, 86, 20);
        l111.add(t8);

        b2 = new JButton("Search");
        b2.setFont(new Font("Arial", Font.BOLD, 14));
        b2.setBorder(new LineBorder(new Color(192, 192, 192), 1, true));
        b2.setBounds(604, 59, 100, 30);
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        l111.add(b2);

        t9 = new JTextField();
        t9.setForeground(new Color(47, 79, 79));
        t9.setFont(new Font("Arial", Font.BOLD, 14));
        t9.setEditable(false);
        t9.setColumns(10);
        t9.setBounds(508, 106, 208, 20);
        l111.add(t9);

        t10 = new JTextField();
        t10.setForeground(new Color(47, 79, 79));
        t10.setFont(new Font("Arial", Font.BOLD, 14));
        t10.setEditable(false);
        t10.setColumns(10);
        t10.setBounds(508, 150, 208, 20);
        l111.add(t10);

        t11 = new JTextField();
        t11.setForeground(new Color(47, 79, 79));
        t11.setFont(new Font("Arial", Font.BOLD, 14));
        t11.setEditable(false);
        t11.setColumns(10);
        t11.setBounds(508, 190, 208, 20);
        l111.add(t11);

        t12 = new JTextField();
        t12.setForeground(new Color(47, 79, 79));
        t12.setFont(new Font("Arial", Font.BOLD, 14));
        t12.setEditable(false);
        t12.setColumns(10);
        t12.setBounds(508, 236, 208, 20);
        l111.add(t12);

        t13 = new JTextField();
        t13.setForeground(new Color(47, 79, 79));
        t13.setFont(new Font("Arial", Font.BOLD, 14));
        t13.setEditable(false);
        t13.setColumns(10);
        t13.setBounds(508, 286, 208, 20);
        l111.add(t13);

        JPanel panel_1 = new JPanel();
        panel_1.setBorder(new TitledBorder(new LineBorder(new Color(70, 130, 180), 2, true), "Student-Details",
                TitledBorder.LEADING, TitledBorder.TOP, null, new Color(100, 149, 237)));
        panel_1.setForeground(new Color(0, 100, 0));
        panel_1.setBounds(390, 38, 378, 372);
        panel_1.setBackground(Color.WHITE);
        l111.add(panel_1);

        JLabel l15 = new JLabel(" Date of Issue :");
        l15.setFont(new Font("Raleway", Font.BOLD, 15));
        l15.setBounds(20, 340, 118, 26);
        l111.add(l15);

        dateChooser = new JDateChooser();
        dateChooser.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
        dateChooser.setForeground(new Color(105, 105, 105));
        dateChooser.setBounds(137, 337, 200, 29);
        l111.add(dateChooser);

        b3 = new JButton("Issue");
        b3.setFont(new Font("Arial", Font.BOLD, 14));
        b3.setBorder(new LineBorder(new Color(192, 192, 192), 1, true));
        b3.setBounds(47, 377, 118, 33);
        b3.setBackground(Color.BLACK);
        b3.setForeground(Color.WHITE);
        l111.add(b3);

        b4 = new JButton("Back");
        b4.setFont(new Font("Arial", Font.BOLD, 14));
        b4.setBorder(new LineBorder(new Color(192, 192, 192), 1, true));
        b4.setBounds(199, 377, 100, 33);
        b4.setBackground(Color.BLACK);
        b4.setForeground(Color.WHITE);
        l111.add(b4);

        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        b4.addActionListener(this);

        setLocation(200,100);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setSize(800, 500);
        setVisible(true);
    }


    @Override
    public void actionPerformed(ActionEvent ae) {

        try{
            conn con = new conn();
            if(ae.getSource() == b1){
                String sql = "select * from book1 where BOOKID = ?";
                PreparedStatement st = con.c.prepareStatement(sql);
                st.setString(1, t1.getText());
                ResultSet rs = st.executeQuery();

                while (rs.next()) {
                    t2.setText(rs.getString("NAME"));
                    t3.setText(rs.getString("ISBN"));
                    t4.setText(rs.getString("PUBLISHER"));
                    t5.setText(rs.getString("EDITION"));
                    t6.setText(rs.getString("PRICE"));
                    t7.setText(rs.getString("PAGES"));
                }
                st.close();
                rs.close();

            }
            if(ae.getSource() == b2){
                String sql = "select * from student1 where STUDENTID = ?";
                PreparedStatement st = con.c.prepareStatement(sql);
                st.setString(1, t8.getText());
                ResultSet rs = st.executeQuery();

                while (rs.next()) {
                    t9.setText(rs.getString("NAME"));
                    t10.setText(rs.getString("FNAME"));
                    t11.setText(rs.getString("COURSE"));
                    t12.setText(rs.getString("BRANCH"));
                    t14.setText(rs.getString("SEM"));
                }
                st.close();
                rs.close();
            }

            if(ae.getSource() == b3){
                try{
                    String sql = "insert into IssueBook(BOOKID, STUDENTID, BNAME, SNAME, COURSE, BRANCH, DateOfIssue) values(?, ?, ?, ?, ?, ?, ?)";
                    PreparedStatement st = con.c.prepareStatement(sql);
                    st.setString(1, t1.getText());
                    st.setString(2, t8.getText());
                    st.setString(3, t2.getText());
                    st.setString(4, t9.getText());
                    st.setString(5, t11.getText());
                    st.setString(6, t12.getText());
                    st.setString(7, ((JTextField) dateChooser.getDateEditor().getUiComponent()).getText());
                    int i = st.executeUpdate();
                    if (i > 0)
                        JOptionPane.showMessageDialog(null, "Successfully Book Issued..!");
                    else
                        JOptionPane.showMessageDialog(null, "error");
                }catch(Exception e){
                    e.printStackTrace();
                }
            }
            if(ae.getSource() == b4){
                this.setVisible(false);
                new eg().setVisible(true);
            }
            con.c.close();
        }catch(Exception e){

        }
    }
    public static void main(String[] args) {
        new IssueBook().setVisible(true);
    }
}
