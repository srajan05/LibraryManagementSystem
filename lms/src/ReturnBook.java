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
import java.sql.SQLException;

public class ReturnBook extends JFrame implements ActionListener {

    JPanel contentPane;
    JTextField tf,tf1,tf2,tf3,tf4,tf5,tf6;
    JButton b1,b2,b3;
    JDateChooser dateChooser;

    public void delete() {
        try {
            conn con = new conn();
            String sql = "delete from IssueBook where BOOKID=?";
            PreparedStatement st = con.c.prepareStatement(sql);
            st.setString(1, tf.getText());
            int i = st.executeUpdate();
            if (i > 0)
                JOptionPane.showConfirmDialog(null, "Book Returned Successfully!!");
            else
                JOptionPane.showMessageDialog(null, "ERROR in Deleting!!");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
            e.printStackTrace();
        }
    }

    ReturnBook(){

        setTitle("LMS-RETURN BOOK");
        setBounds(450, 300, 617, 363);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setBackground(Color.WHITE);
        contentPane.setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("images/bacKfront.jpg"));
        Image i2 = i1.getImage().getScaledInstance(650, 400, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l2 = new JLabel(i3);
        l2.setBounds(0, 0, 650, 400);
        contentPane.add(l2);

        JLabel lblNewLabel = new JLabel("Book Id");
        lblNewLabel.setForeground(new Color(0, 0, 0));
        lblNewLabel.setFont(new Font("Raleway", Font.BOLD, 14));
        lblNewLabel.setBounds(52, 52, 87, 24);
        l2.add(lblNewLabel);

        JLabel lblStudentid = new JLabel("Student Id");
        lblStudentid.setForeground(Color.BLACK);
        lblStudentid.setFont(new Font("Raleway", Font.BOLD, 14));
        lblStudentid.setBounds(243, 52, 87, 24);
        l2.add(lblStudentid);

        JLabel lblBook = new JLabel("Book");
        lblBook.setForeground(Color.BLACK);
        lblBook.setFont(new Font("Raleway", Font.BOLD, 14));
        lblBook.setBounds(52, 98, 71, 24);
        l2.add(lblBook);

        JLabel lblName = new JLabel("Name");
        lblName.setForeground(Color.BLACK);
        lblName.setFont(new Font("Raleway", Font.BOLD, 14));
        lblName.setBounds(300, 98, 71, 24);
        l2.add(lblName);

        JLabel lblCourse = new JLabel("Course");
        lblCourse.setForeground(Color.BLACK);
        lblCourse.setFont(new Font("Raleway", Font.BOLD, 14));
        lblCourse.setBounds(52, 143, 87, 24);
        l2.add(lblCourse);

        JLabel lblBranch = new JLabel("Branch");
        lblBranch.setForeground(Color.BLACK);
        lblBranch.setFont(new Font("Raleway", Font.BOLD, 14));
        lblBranch.setBounds(303, 144, 68, 24);
        l2.add(lblBranch);

        JLabel lblDateOfIssue = new JLabel("Date of Issue");
        lblDateOfIssue.setForeground(Color.BLACK);
        lblDateOfIssue.setFont(new Font("Raleway", Font.BOLD, 14));
        lblDateOfIssue.setBounds(52, 188, 105, 29);
        l2.add(lblDateOfIssue);

        JLabel lblDateOfReturn = new JLabel("Date of Return");
        lblDateOfReturn.setForeground(Color.BLACK);
        lblDateOfReturn.setFont(new Font("Raleway", Font.BOLD, 14));
        lblDateOfReturn.setBounds(52, 234, 118, 29);
        l2.add(lblDateOfReturn);

        tf = new JTextField();
        tf.setForeground(new Color(105, 105, 105));
        tf.setFont(new Font("Arial", Font.BOLD, 14));
        tf.setBounds(128, 56, 105, 20);
        l2.add(tf);
        tf.setColumns(10);

        tf1 = new JTextField();
        tf1.setForeground(new Color(105, 105, 105));
        tf1.setFont(new Font("Arial", Font.BOLD, 14));
        tf1.setBounds(340, 56, 93, 20);
        l2.add(tf1);
        tf1.setColumns(10);

        b1 = new JButton("Search");
        b1.addActionListener(this);
        b1.setBounds(443, 52, 105, 29);
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        l2.add(b1);

        tf2 = new JTextField();
        tf2.setEditable(false);
        tf2.setForeground(new Color(0, 100, 0));
        tf2.setFont(new Font("Arial", Font.BOLD, 13));
        tf2.setBounds(128, 102, 162, 20);
        l2.add(tf2);
        tf2.setColumns(10);

        tf3 = new JTextField();
        tf3.setEditable(false);
        tf3.setForeground(new Color(0, 100, 0));
        tf3.setFont(new Font("Arial", Font.BOLD, 13));
        tf3.setColumns(10);
        tf3.setBounds(369, 102, 179, 20);
        l2.add(tf3);

        tf4 = new JTextField();
        tf4.setEditable(false);
        tf4.setForeground(new Color(0, 100, 0));
        tf4.setFont(new Font("Arial", Font.BOLD, 13));
        tf4.setColumns(10);
        tf4.setBounds(128, 147, 162, 20);
        l2.add(tf4);

        tf5 = new JTextField();
        tf5.setForeground(new Color(0, 100, 0));
        tf5.setFont(new Font("Arial", Font.BOLD, 13));
        tf5.setEditable(false);
        tf5.setColumns(10);
        tf5.setBounds(369, 147, 179, 20);
        l2.add(tf5);

        tf6 = new JTextField();
        tf6.setForeground(new Color(0, 100, 0));
        tf6.setFont(new Font("Arial", Font.BOLD, 13));
        tf6.setEditable(false);
        tf6.setColumns(10);
        tf6.setBounds(167, 194, 162, 20);
        l2.add(tf6);

        dateChooser = new JDateChooser();
        dateChooser.setBorder(new LineBorder(new Color(0, 0, 0), 0, true));
        dateChooser.setBounds(167, 234, 172, 29);
        l2.add(dateChooser);

        b2 = new JButton("Return");
        b2.addActionListener(this);
        b2.setFont(new Font("Arial", Font.BOLD, 15));
        b2.setBorder(new LineBorder(new Color(0, 0, 0), 0, true));
        b2.setBounds(369, 179, 149, 30);
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);

        l2.add(b2);

        b3 = new JButton("Back");
        b3.addActionListener(this);
        b3.setFont(new Font("Arial", Font.BOLD, 15));
        b3.setBorder(new LineBorder(new Color(0, 0, 0), 0, true));
        b3.setBounds(369, 231, 149, 30);
        b3.setBackground(Color.BLACK);
        b3.setForeground(Color.WHITE);
        l2.add(b3);

        JPanel panel = new JPanel();
        panel.setBorder(new TitledBorder(new LineBorder(new Color(255, 69, 0), 2, true), "Return-Panel",
                TitledBorder.LEADING, TitledBorder.TOP, null, new Color(220, 20, 60)));
        panel.setBounds(25, 24, 569, 269);
        panel.setBackground(Color.WHITE);
        l2.add(panel);

        setLocation(200,100);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setSize(650, 400);
        setVisible(true);
    }



    @Override
    public void actionPerformed(ActionEvent ae) {
        try{
            conn con = new conn();
            if(ae.getSource() == b1){
                String sql = "select * from issueBook where STUDENTID= ? and BOOKID =?";
                PreparedStatement st = con.c.prepareStatement(sql);
                st.setString(1, tf1.getText());
                st.setString(2, tf.getText());
                ResultSet rs = st.executeQuery();

                while (rs.next()) {
                    tf2.setText(rs.getString("BNAME"));
                    tf3.setText(rs.getString("SNAME"));
                    tf4.setText(rs.getString("COURSE"));
                    tf5.setText(rs.getString("BRANCH"));
                    tf6.setText(rs.getString("DateOfIssue"));
                }
                st.close();
                rs.close();

            }
            if(ae.getSource() == b2){
                String sql = "insert into returnBok(BOOKID, STUDENTID, BNAME, SNAME,COURSE, BRANCH, DateOfIssue, DateOfReturn) values(?, ?, ?, ?, ?, ?, ?, ?)";
                PreparedStatement st = con.c.prepareStatement(sql);
                st.setString(1, tf.getText());
                st.setString(2, tf1.getText());
                st.setString(3, tf2.getText());
                st.setString(4, tf3.getText());
                st.setString(5, tf4.getText());
                st.setString(6, tf5.getText());
                st.setString(7, tf6.getText());

                st.setString(8, ((JTextField) dateChooser.getDateEditor().getUiComponent()).getText());
                int i = st.executeUpdate();
                if (i > 0) {
                    JOptionPane.showMessageDialog(null, "Processing..");
                    delete();
                } else
                    JOptionPane.showMessageDialog(null, "error");

            }
            if(ae.getSource() == b3){
                this.setVisible(false);
                new eg().setVisible(true);

            }
        }catch(Exception e){

        }

    }
    public static void main(String[] args) {
        new ReturnBook();
    }
}
