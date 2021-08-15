import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class addStudent extends JFrame implements ActionListener {
    JLabel l1,l2,l3,l4,l5,l6,l7,l8;
    JTextField tf1,tf2,tf3;
    JComboBox c1,c2,c3;
    JRadioButton male,female;
    JButton b1,b2;

    addStudent(){
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("images/backfront.jpg"));
        Image i2 = i1.getImage().getScaledInstance(800, 800, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l11 = new JLabel(i3);
        l11.setBounds(0, 0, 800, 800);
        add(l11);

        l1 = new JLabel("ENTER STUDENT DETAILS");
        l1.setFont(new Font("Osward", Font.BOLD, 38));
        l1.setBounds(175, 40, 700, 40);
        l11.add(l1);

        l2 = new JLabel("STUDENT ID: ");
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

        l4 = new JLabel("FATHER'S NAME: ");
        l4.setFont(new Font("Raleway", Font.BOLD, 25));
        l4.setBounds(175,290,375,30);
        l11.add(l4);

        tf3 = new JTextField(15);
        tf3.setFont(new Font("Arial", Font.BOLD, 14));
        tf3.setBounds(400,290,230,30);
        l11.add(tf3);

        l5 = new JLabel("GENDER: ");
        l5.setFont(new Font("Raleway", Font.BOLD, 28));
        l5.setBounds(175,360,375,30);
        l11.add(l5);

        male=new JRadioButton("Male",true);
        female=new JRadioButton("Female");
        ButtonGroup bg=new ButtonGroup();
        bg.add(male);
        bg.add(female);
        male.setBounds(400,360,100,30);
        female.setBounds(500,360,100,30);
        male.setFont(new Font("Arial", Font.BOLD, 14));
        female.setFont(new Font("Arial", Font.BOLD, 14));
        l11.add(male);
        l11.add(female);

        String str1[]={"B.tech","M.tech","B.Sc","M.Sc"};
        String str2[]={"Computer","Electrical","Civil","Mechanical"};
        String str3[]={"1","2","3","4","5","6","7","8"};
        c1=new JComboBox(str1);
        c2=new JComboBox(str2);
        c3=new JComboBox(str3);

        l6 = new JLabel("COURSE: ");
        l6.setFont(new Font("Raleway", Font.BOLD, 28));
        l6.setBounds(175,430,375,30);
        l11.add(l6);
        c1.setBounds(400,430,200,30);
        l11.add(c1);

        l7 = new JLabel("BRANCH: ");
        l7.setFont(new Font("Raleway", Font.BOLD, 28));
        l7.setBounds(175,500,375,30);
        l11.add(l7);
        c2.setBounds(400,500,200,30);
        l11.add(c2);

        l8 = new JLabel("SEMESTER: ");
        l8.setFont(new Font("Raleway", Font.BOLD, 28));
        l8.setBounds(175,560,375,30);
        l11.add(l8);
        c3.setBounds(400,560,200,30);
        l11.add(c3);

        b1 = new JButton("ADD STUDENT");
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);

        b2 = new JButton("BACK");
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);

        b1.setFont(new Font("Arial", Font.BOLD, 14));
        b1.setBounds(160, 630, 200, 30);
        l11.add(b1);

        b2.setFont(new Font("Arial", Font.BOLD, 14));
        b2.setBounds(430, 630, 200, 30);
        l11.add(b2);

        b1.addActionListener(this);
        b2.addActionListener(this);
        setLayout(null);
        setSize(800, 750);
        setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent ae) {
        try{

            if(ae.getSource() == b1){
                try{
                    conn con = new conn();
                    String sql = "insert into student1(STUDENTID, NAME, FNAME, GENDER, COURSE, BRANCH, SEM) values(?, ?, ?, ?, ?, ?, ?)";
                    PreparedStatement st = con.c.prepareStatement(sql);
                    st.setString(1, tf1.getText());
                    st.setString(2, tf2.getText());
                    st.setString(3, tf3.getText());

                    if (male.isSelected()){
                        st.setString(4, "Male");
                    }
                    if (female.isSelected()){
                        st.setString(4, "Female");
                    }

                    st.setString(5, (String) c1.getSelectedItem());
                    st.setString(6, (String) c2.getSelectedItem());
                    st.setString(7, (String) c3.getSelectedItem());

                    int i = st.executeUpdate();
                    if (i > 0){
                        JOptionPane.showMessageDialog(null, "Successfully Added");
                        this.setVisible(false);
                        new eg().setVisible(true);
                    }
                    else
                        JOptionPane.showMessageDialog(null, "error");
                }catch(Exception e){
                    e.printStackTrace();
                }
            }

            if(ae.getSource() == b2){
                this.setVisible(false);
                new eg().setVisible(true);
            }
        }catch(Exception e){

        }
    }
    public static void main(String[] args) {
        new addStudent();
    }

}
