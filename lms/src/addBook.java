import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;


public class addBook extends JFrame implements ActionListener {

    JLabel l1,l2,l3,l4,l5,l6,l7,l8;
    JTextField tf1,tf2,tf3,tf4,tf5,tf6,tf7;
    JButton b1,b2;

    addBook(){

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("images/backfront.jpg"));
        Image i2 = i1.getImage().getScaledInstance(800, 800, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l11 = new JLabel(i3);
        l11.setBounds(0, 0, 800, 800);
        add(l11);

        setTitle("LMS-ADD NEW BOOK");
        l1 = new JLabel("ENTER BOOK DETAILS");
        l1.setFont(new Font("Osward", Font.BOLD, 38));
        l1.setBounds(175, 40, 700, 40);
        l11.add(l1);

        l2 = new JLabel("BOOK ID: ");
        l2.setFont(new Font("Raleway", Font.BOLD, 28));
        l2.setBounds(175,150,375,30);
        l11.add(l2);

        tf1 = new JTextField(15);
        tf1.setBounds(400,150,230,30);
        tf1.setFont(new Font("Arial", Font.BOLD, 14));
        l11.add(tf1);

        l3 = new JLabel("NAME: ");
        l3.setFont(new Font("Raleway", Font.BOLD, 28));
        l3.setBounds(175, 220, 375, 30);
        l11.add(l3);

        tf2 = new JTextField(15);
        tf2.setFont(new Font("Arial", Font.BOLD, 14));
        tf2.setBounds(400, 220, 230, 30);
        l11.add(tf2);

        l4 = new JLabel("ISBN: ");
        l4.setFont(new Font("Raleway", Font.BOLD, 28));
        l4.setBounds(175,290,375,30);
        l11.add(l4);

        tf3 = new JTextField(15);
        tf3.setFont(new Font("Arial", Font.BOLD, 14));
        tf3.setBounds(400,290,230,30);
        l11.add(tf3);

        l5 = new JLabel("PUBLISHER:");
        l5.setFont(new Font("Raleway", Font.BOLD, 28));
        l5.setBounds(175, 360, 375, 30);
        l11.add(l5);

        tf4 = new JTextField(15);
        tf4.setFont(new Font("Arial", Font.BOLD, 14));
        tf4.setBounds(400,360,230,30);
        l11.add(tf4);

        l6 = new JLabel("EDITION:");
        l6.setFont(new Font("Raleway", Font.BOLD, 28));
        l6.setBounds(175, 430, 375, 30);
        l11.add(l6);

        tf5 = new JTextField(15);
        tf5.setFont(new Font("Arial", Font.BOLD, 14));
        tf5.setBounds(400,430,230,30);
        l11.add(tf5);

        l7 = new JLabel("PRICE:");
        l7.setFont(new Font("Raleway", Font.BOLD, 28));
        l7.setBounds(175, 500, 375, 30);
        l11.add(l7);

        tf6 = new JTextField(15);
        tf6.setFont(new Font("Arial", Font.BOLD, 14));
        tf6.setBounds(400,500,230,30);
        l11.add(tf6);

        l8 = new JLabel("PAGES:");
        l8.setFont(new Font("Raleway", Font.BOLD, 28));
        l8.setBounds(175, 560, 375, 30);
        l11.add(l8);

        tf7 = new JTextField(15);
        tf7.setFont(new Font("Arial", Font.BOLD, 14));
        tf7.setBounds(400,560,230,30);
        l11.add(tf7);

        b1 = new JButton("ADD BOOK");
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);

        b2 = new JButton("BACK");
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);

        b1.setFont(new Font("Arial", Font.BOLD, 16));
        b1.setBounds(180,640,150,30);
        l11.add(b1);

        b2.setFont(new Font("Arial", Font.BOLD, 16));
        b2.setBounds(430,640,150,30);
        l11.add(b2);

        b1.addActionListener(this);
        b2.addActionListener(this);

        setLocation(150,50);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setSize(800, 750);
        setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent ae) {
        try{
            conn con = new conn();
            if(ae.getSource() == b1){
                String sql = "insert into BOOK1(BOOKID, NAME, ISBN, PUBLISHER, EDITION, PRICE, PAGES) values(?, ?, ?, ?, ?, ?, ?)";
                PreparedStatement st = con.c.prepareStatement(sql);

                st.setString(1, tf1.getText());
                st.setString(2, tf2.getText());
                st.setString(3, tf3.getText());
                st.setString(4, tf4.getText());
                st.setString(5, tf5.getText());
                st.setString(6, tf6.getText());
                st.setString(7, tf7.getText());

                int rs = st.executeUpdate();
                if (rs > 0)
                    JOptionPane.showMessageDialog(null, "Successfully Added");
                else
                    JOptionPane.showMessageDialog(null, "Error");
                tf1.setText("");
                tf2.setText("");
                tf3.setText("");
                tf4.setText("");
                tf5.setText("");
                tf6.setText("");
                tf7.setText("");
                st.close();
            }
            if(ae.getSource() == b2){
                this.setVisible(false);
                new eg().setVisible(true);

            }
            con.c.close();
        }catch(Exception e){

        }
    }
    public static void main(String[] args) {
        new addBook();
    }

}
