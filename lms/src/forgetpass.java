import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class forgetpass extends JFrame implements ActionListener {
    JLabel l1,l2,l3,l4,l5,l6;
    JTextField tf1,tf2,tf3,tf4,tf5;
    JButton b1,b2,b3;

    forgetpass(){
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("images/backfront.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1000, 600, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l11 = new JLabel(i3);
        l11.setBounds(0, 0, 1000, 600);
        add(l11);

        setTitle("LMS-FORGET PASSWORD");
        l1 = new JLabel("  ENTER DETAILS TO FETCH PASSWORD");
        l1.setFont(new Font("Osward", Font.BOLD, 28));
        l1.setBounds(150,25,700,40);
        l11.add(l1);

        l2 = new JLabel("USERNAME: ");
        l2.setFont(new Font("Raleway", Font.BOLD, 28));
        l2.setBounds(200,100,375,30);
        l11.add(l2);

        tf1 = new JTextField(15);
        tf1.setBounds(500,100,230,30);
        tf1.setFont(new Font("Arial", Font.BOLD, 14));
        l11.add(tf1);

        b3 = new JButton("SEARCH");
        b3.setBackground(Color.BLACK);
        b3.setForeground(Color.WHITE);
        b3.setFont(new Font("Arial", Font.BOLD, 14));
        b3.setBounds(750, 100, 200, 30);
        l11.add(b3);

        l3 = new JLabel("NAME:");
        l3.setFont(new Font("Raleway", Font.BOLD, 28));
        l3.setBounds(200, 160, 375, 30);
        l11.add(l3);

        tf2 = new JTextField(15);
        tf2.setBounds(500,160,230,30);
        tf2.setFont(new Font("Arial", Font.BOLD, 14));
        tf2.setEditable(false);
        l11.add(tf2);

        l4 = new JLabel("YOUR QUESTION: ");
        l4.setFont(new Font("Raleway", Font.BOLD, 28));
        l4.setBounds(200, 220, 375, 30);
        l11.add(l4);

        tf3 = new JTextField(15);
        tf3.setBounds(500, 220, 230, 30);
        tf3.setFont(new Font("Arial", Font.BOLD, 14));
        l11.add(tf3);

        l5 = new JLabel("ANSWER: ");
        l5.setFont(new Font("Raleway", Font.BOLD, 28));
        l5.setBounds(200,290,375,30);
        l11.add(l5);

        tf4 = new JPasswordField(15);
        tf4.setFont(new Font("Arial", Font.BOLD, 14));
        tf4.setBounds(500,290,230,30);
        l11.add(tf4);

        b1 = new JButton("GET PASSWORD");
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        b1.setFont(new Font("Arial", Font.BOLD, 14));
        b1.setBounds(750, 290, 200, 30);
        l11.add(b1);

        l6 = new JLabel("PASSWORD:");
        l6.setFont(new Font("Raleway", Font.BOLD, 28));
        l6.setBounds(200, 360, 375, 30);
        l11.add(l6);

        tf5 = new JTextField(15);
        tf5.setBounds(500,360,230,30);
        tf5.setFont(new Font("Arial", Font.BOLD, 14));
        tf2.setEditable(false);
        l11.add(tf5);

        b2 = new JButton("BACK");
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        b2.setFont(new Font("Arial", Font.BOLD, 14));
        b2.setBounds(430, 440, 200, 30);
        l11.add(b2);

        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);

        setLayout(null);
        setSize(1000,600);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        try{
            conn con = new conn();
            if(ae.getSource() == b3){
                String sql = "select * from account where username=?";
                PreparedStatement st = con.c.prepareStatement(sql);

                st.setString(1, tf1.getText());
                ResultSet rs = st.executeQuery();

                while (rs.next()) {
                    tf2.setText(rs.getString("name"));
                    tf3.setText(rs.getString("question"));
                }

            }
            if(ae.getSource() == b1){
                String sql = "select * from account where answer=?";
                PreparedStatement st = con.c.prepareStatement(sql);

                st.setString(1, tf4.getText());
                ResultSet rs = st.executeQuery();

                while (rs.next()) {
                    tf5.setText(rs.getString("password"));
                }

            }
            if(ae.getSource() == b2){
                this.setVisible(false);
                new Login1().setVisible(true);

            }
        }catch(Exception e){

        }
    }
    public static void main(String[] args) {
        new forgetpass();
    }

}
