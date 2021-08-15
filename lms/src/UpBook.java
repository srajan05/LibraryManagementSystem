import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class UpBook extends JFrame implements ActionListener {
    JLabel l1,l2,l3,l4,l5,l6,l7,l8;
    JTextField tf1,tf2,tf3,tf4,tf5,tf6,tf7;
    JButton b1,b2,b3,b4,b5;

    UpBook(){
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("images/backfront.jpg"));
        Image i2 = i1.getImage().getScaledInstance(800, 800, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l11 = new JLabel(i3);
        l11.setBounds(0, 0, 800, 800);
        add(l11);

        setTitle("LMS-MODIFY BOOK");
        l1 = new JLabel("UPDATE/DELETE BOOK DETAILS ");
        l1.setFont(new Font("Osward", Font.BOLD, 33));
        l1.setBounds(150, 25, 700, 40);
        l11.add(l1);

        l2 = new JLabel("BOOK ID: ");
        l2.setFont(new Font("Raleway", Font.BOLD, 28));
        l2.setBounds(175,90,375,30);
        l11.add(l2);

        tf1 = new JTextField(15);
        tf1.setBounds(400,90,230,30);
        tf1.setFont(new Font("Arial", Font.BOLD, 14));
        l11.add(tf1);

        b1 = new JButton("SEARCH");
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        b1.setFont(new Font("Arial", Font.BOLD, 16));
        b1.setBounds(650,90,100,30);
        l11.add(b1);

        l3 = new JLabel("NAME: ");
        l3.setFont(new Font("Raleway", Font.BOLD, 28));
        l3.setBounds(175, 150, 375, 30);
        l11.add(l3);

        tf2 = new JTextField(15);
        tf2.setFont(new Font("Arial", Font.BOLD, 14));
        tf2.setBounds(400, 150, 230, 30);
        l11.add(tf2);

        l4 = new JLabel("ISBN: ");
        l4.setFont(new Font("Raleway", Font.BOLD, 28));
        l4.setBounds(175,210,375,30);
        l11.add(l4);

        tf3 = new JTextField(15);
        tf3.setFont(new Font("Arial", Font.BOLD, 14));
        tf3.setBounds(400,210,230,30);
        l11.add(tf3);

        l5 = new JLabel("PUBLISHER:");
        l5.setFont(new Font("Raleway", Font.BOLD, 28));
        l5.setBounds(175, 270, 375, 30);
        l11.add(l5);

        tf4 = new JTextField(15);
        tf4.setFont(new Font("Arial", Font.BOLD, 14));
        tf4.setBounds(400,270,230,30);
        l11.add(tf4);

        l6 = new JLabel("EDITION:");
        l6.setFont(new Font("Raleway", Font.BOLD, 28));
        l6.setBounds(175, 330, 375, 30);
        l11.add(l6);

        tf5 = new JTextField(15);
        tf5.setFont(new Font("Arial", Font.BOLD, 14));
        tf5.setBounds(400,330,230,30);
        l11.add(tf5);

        l7 = new JLabel("PRICE:");
        l7.setFont(new Font("Raleway", Font.BOLD, 28));
        l7.setBounds(175, 400, 375, 30);
        l11.add(l7);

        tf6 = new JTextField(15);
        tf6.setFont(new Font("Arial", Font.BOLD, 14));
        tf6.setBounds(400,400,230,30);
        l11.add(tf6);

        l8 = new JLabel("PAGES:");
        l8.setFont(new Font("Raleway", Font.BOLD, 28));
        l8.setBounds(175, 460, 375, 30);
        l11.add(l8);

        tf7 = new JTextField(15);
        tf7.setFont(new Font("Arial", Font.BOLD, 14));
        tf7.setBounds(400,460,230,30);
        l11.add(tf7);

        b2 = new JButton("UPDATE");
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        b2.setFont(new Font("Arial", Font.BOLD, 16));
        b2.setBounds(150,525,200,30);
        l11.add(b2);

        b3 = new JButton("DELETE");
        b3.setBackground(Color.BLACK);
        b3.setForeground(Color.WHITE);
        b3.setFont(new Font("Arial", Font.BOLD, 16));
        b3.setBounds(450,525,200,30);
        l11.add(b3);

        b4 = new JButton("MODIFY STUDENT DETAILS");
        b4.setBackground(Color.BLACK);
        b4.setForeground(Color.WHITE);
        b4.setFont(new Font("Arial", Font.BOLD, 16));
        b4.setBounds(250,580,300,30);
        l11.add(b4);

        b5 = new JButton("GO TO HOME");
        b5.setBackground(Color.BLACK);
        b5.setForeground(Color.WHITE);
        b5.setFont(new Font("Arial", Font.BOLD, 16));
        b5.setBounds(300,640,200,30);
        l11.add(b5);

        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        b4.addActionListener(this);
        b5.addActionListener(this);

        setLocation(150,50);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setSize(800, 750);
        setVisible(true);

    }
    @Override
    public void actionPerformed(ActionEvent ae) {
        try {
            conn con=new conn();
            //FOR SEARCH
            if (ae.getSource() == b1){
                String sql="select * from book1 where BOOKID=?";
                PreparedStatement st = con.c.prepareStatement(sql);
                st.setString(1,tf1.getText());

                ResultSet rs=st.executeQuery();
                while(rs.next()){
                    tf2.setText(rs.getString("NAME"));
                    tf3.setText(rs.getString("ISBN"));
                    tf4.setText(rs.getString("PUBLISHER"));
                    tf5.setText(rs.getString("EDITION"));
                    tf6.setText(rs.getString("PRICE"));
                    tf7.setText(rs.getString("PAGES"));
                }
            }
            //update
            if (ae.getSource() == b2){
                String sql = "update BOOK1 set NAME=?, ISBN=?, PUBLISHER=?, EDITION=?, PRICE=?, PAGES=? where BOOKID=?";
                PreparedStatement st = con.c.prepareStatement(sql);

                st.setString(1, tf2.getText());
                st.setString(2, tf3.getText());
                st.setString(3, tf4.getText());
                st.setString(4, tf5.getText());
                st.setString(5, tf6.getText());
                st.setString(6, tf7.getText());
                st.setString(7, tf1.getText());

                int rs = st.executeUpdate();
                if (rs > 0)
                    JOptionPane.showMessageDialog(null, "Successfully Updated !!");
                else
                    JOptionPane.showMessageDialog(null, "Error");
            }


            //FOR DELETE
            if(ae.getSource() == b3){

                String sql = "delete from book1 where  BOOKID=?";
                PreparedStatement st = con.c.prepareStatement(sql);
                st.setString(1,tf1.getText());

                JDialog.setDefaultLookAndFeelDecorated(true);
                int response = JOptionPane.showConfirmDialog(null, "Do you want to continue?", "Confirm",
                        JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                if (response == JOptionPane.NO_OPTION) {

                } else if (response == JOptionPane.YES_OPTION) {
                    int rs = st.executeUpdate();
                    JOptionPane.showMessageDialog(null, "Deleted !!");
                } else if (response == JOptionPane.CLOSED_OPTION) {

                }
                tf1.setText("");
                tf2.setText("");
                tf3.setText("");
                tf4.setText("");
                tf5.setText("");
                tf6.setText("");
                tf7.setText("");

                st.close();
            }

            if (ae.getSource() == b4){
                this.setVisible(false);
                new UpStd().setVisible(true);
            }
            if (ae.getSource() == b5){
                this.setVisible(false);
                new eg().setVisible(true);
            }
            con.c.close();
        }
        catch (Exception e7){

        }
    }
    public static void main(String[] args) {
        new UpBook();
    }

}
