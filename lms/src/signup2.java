import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class signup2 extends JFrame implements ActionListener {

    JLabel l1,l2,l3,l4,l5,l6;
    JTextField tf1,tf2,tf3;
    JPasswordField pf2;
    JButton b1,b2;
    JComboBox j1;

    signup2() {

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("images/backfront.jpg"));
        Image i2 = i1.getImage().getScaledInstance(800, 800, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l11 = new JLabel(i3);
        l11.setBounds(0, 0, 800, 800);
        add(l11);

        setTitle("LMS-REGISTRATION FORM");
        l1 = new JLabel("REGISTRATION  FORM");
        l1.setFont(new Font("Osward", Font.BOLD, 38));
        l1.setBounds(175, 40, 700, 40);
        l11.add(l1);

        l2 = new JLabel("USERNAME: ");
        l2.setFont(new Font("Raleway", Font.BOLD, 28));
        l2.setBounds(175, 150, 375, 30);
        l11.add(l2);

        tf1 = new JTextField(15);
        tf1.setBounds(400, 150, 230, 30);
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

        l4 = new JLabel("PASSWORD: ");
        l4.setFont(new Font("Raleway", Font.BOLD, 28));
        l4.setBounds(175,290,375,30);
        l11.add(l4);

        pf2 = new JPasswordField(15);
        pf2.setFont(new Font("Arial", Font.BOLD, 14));
        pf2.setBounds(400,290,230,30);
        l11.add(pf2);

        l5 = new JLabel("QUESTION:");
        l5.setFont(new Font("Raleway", Font.BOLD, 28));
        l5.setBounds(175, 360, 375, 30);
        l11.add(l5);

        String str[]={"Favourite sport?","Your nickname?"};
        j1=new JComboBox(str);
        j1.setBounds(400,360,230,30);
        l11.add(j1);

        l6 = new JLabel("ANSWER: ");
        l6.setFont(new Font("Raleway", Font.BOLD, 28));
        l6.setBounds(175, 430, 375, 30);
        l11.add(l6);

        tf3 = new JTextField(15);
        tf3.setBounds(400, 430, 230, 30);
        tf3.setFont(new Font("Arial", Font.BOLD, 14));
        l11.add(tf3);

        b1 = new JButton("SUBMIT");
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);

        b2 = new JButton("BACK");
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);

        b1.setFont(new Font("Arial", Font.BOLD, 14));
        b1.setBounds(225, 550, 100, 30);
        l11.add(b1);

        b2.setFont(new Font("Arial", Font.BOLD, 14));
        b2.setBounds(430, 550, 100, 30);
        l11.add(b2);

        b1.addActionListener(this);
        b2.addActionListener(this);

        setLayout(null);
        setSize(800, 750);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try{
            conn con = new conn();

            if(e.getSource() == b1){
                String sql = "insert into account(username, name, password, question, answer) values(?, ?, ?, ?, ?)";
                PreparedStatement st = con.c.prepareStatement(sql);

                st.setString(1, tf1.getText());
                st.setString(2, tf2.getText());
                st.setString(3, pf2.getText());
                st.setString(4, (String) j1.getSelectedItem());
                st.setString(5, tf3.getText());

                int i = st.executeUpdate();
                if (i > 0){
                    JOptionPane.showMessageDialog(null, "successfully Created");
                }

                tf1.setText("");
                tf2.setText("");
                pf2.setText("");
                tf3.setText("");
            }
            if(e.getSource() == b2){
                this.setVisible(false);
                new eg().setVisible(true);

            }
        }catch(Exception ae){
            ae.printStackTrace();
        }
    }
    public static void main(String[] args) {
        new signup2();
    }
}
