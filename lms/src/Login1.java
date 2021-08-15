import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class Login1 extends JFrame implements ActionListener {

    JLabel l1,l2,l3,l4;
    JTextField tf1;
    JPasswordField pf2;
    JButton b1,b2,b3;

    Login1(){

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("images/backfront.jpg"));
        Image i2 = i1.getImage().getScaledInstance(800, 480, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l11 = new JLabel(i3);
        l11.setBounds(0, 0, 800, 480);
        add(l11);

        setTitle("LIBRARY MANAGEMENT SYSTEM");
        l1 = new JLabel("WELCOME  TO  DIGITAL LIBRARY");
        l1.setFont(new Font("Osward", Font.BOLD, 38));
        l1.setBounds(100,40,700,40);
        l11.add(l1);

        l2 = new JLabel("USERNAME: ");
        l2.setFont(new Font("Raleway", Font.BOLD, 28));
        l2.setBounds(175,150,375,30);
        l11.add(l2);

        tf1 = new JTextField(15);
        tf1.setBounds(400,150,230,30);
        tf1.setFont(new Font("Arial", Font.BOLD, 14));
        l11.add(tf1);

        l3 = new JLabel("PASSWORD: ");
        l3.setFont(new Font("Raleway", Font.BOLD, 28));
        l3.setBounds(175,220,375,30);
        l11.add(l3);

        pf2 = new JPasswordField(15);
        pf2.setFont(new Font("Arial", Font.BOLD, 14));
        pf2.setBounds(400,220,230,30);
        l11.add(pf2);

        b1 = new JButton("SIGN IN");
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);

        b2 = new JButton("SIGN UP");
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);

        b3 = new JButton("FORGET PASSWORD");
        b3.setBackground(Color.BLACK);
        b3.setForeground(Color.WHITE);

        b1.setFont(new Font("Arial", Font.BOLD, 14));
        b1.setBounds(225,300,100,30);
        l11.add(b1);

        b2.setFont(new Font("Arial", Font.BOLD, 14));
        b2.setBounds(430,300,100,30);
        l11.add(b2);

        b3.setFont(new Font("Arial", Font.BOLD, 14));
        b3.setBounds(275,350,230,30);
        l11.add(b3);

        l4=new JLabel("Trouble in Login?");
        l4.setBounds(75,350,230,30);
        l4.setFont(new Font("Raleway", Font.BOLD, 20));
        l11.add(l4);

        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);


        setLayout(null);
        setSize(800,480);
        setLocation(200,150);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource() == b1){
            Boolean status = false;
            try {
                conn con = new conn();
                String q = "select * from account where username=? and password=?";
                PreparedStatement st = con.c.prepareStatement(q);

                st.setString(1, tf1.getText());
                st.setString(2, pf2.getText());

                ResultSet rs = st.executeQuery();

                if (rs.next()) {
                    this.setVisible(false);
                    new loading().setVisible(true);
                } else
                    JOptionPane.showMessageDialog(null, "Invalid Login Details...!.");

            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        if(e.getSource() == b2){
            setVisible(false);
            new signup().setVisible(true);
        }
        if(e.getSource() == b3){
            setVisible(false);
            new forgetpass().setVisible(true);
        }

    }
    public static void main(String[] args) {
        new Login1();
    }

}