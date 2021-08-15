import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class BookDetails extends JFrame implements ActionListener {

    JTextField tf1;
    JButton b1,b2,b3,b4,b5;
    JTable t1;
    JLabel l1;

    public void Book(){

        try {
            conn con = new conn();
            String sql = "select * from book1";
            PreparedStatement st = con.c.prepareStatement(sql);
            ResultSet rs = st.executeQuery();

            t1.setModel(DbUtils.resultSetToTableModel(rs));
            rs.close();
            st.close();
            con.c.close();
        } catch (Exception e) {

        }
    }

    BookDetails(){

        setTitle("LMS-BOOK DETAILS");
        // background image
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("images/bacKfront.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1000, 650, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l11 = new JLabel(i3);
        l11.setBounds(0, 0, 1000, 650);
        add(l11);


        //table adding
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(75, 125, 771, 250);
        l11.add(scrollPane);

        t1 = new JTable();
        t1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent arg0) {
                int row = t1.getSelectedRow();
                tf1.setText(t1.getModel().getValueAt(row, 1).toString());
            }
        });
        t1.setBackground(Color.lightGray);
        t1.setFont(new Font("Trebuchet MS", Font.ITALIC, 16));
        scrollPane.setViewportView(t1);

        l1=new JLabel("BOOK DETAILS:");
        l1.setFont(new Font("Raleway", Font.BOLD, 28));
        l1.setBounds(50,50,300,30);
        l11.add(l1);

        tf1=new JTextField();
        tf1.setBounds(300,50,400,30);
        tf1.setFont(new Font("Arial", Font.BOLD, 14));
        l11.add(tf1);

        b1 = new JButton("SEARCH BOOKS");
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        b1.setFont(new Font("Arial", Font.BOLD, 16));
        b1.setBounds(755,50,200,30);
        l11.add(b1);

        b2 = new JButton("GO TO UPDATE BOOKS");
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        b2.setFont(new Font("Arial", Font.BOLD, 16));
        b2.setBounds(150,425,300,30);
        l11.add(b2);

        b3 = new JButton("GO TO DELETE BOOKS");
        b3.setBackground(Color.BLACK);
        b3.setForeground(Color.WHITE);
        b3.setFont(new Font("Arial", Font.BOLD, 16));
        b3.setBounds(525,425,300,30);
        l11.add(b3);

        b4 = new JButton("GO TO STUDENT DETAILS");
        b4.setBackground(Color.BLACK);
        b4.setForeground(Color.WHITE);
        b4.setFont(new Font("Arial", Font.BOLD, 16));
        b4.setBounds(300,475,400,30);
        l11.add(b4);

        b5 = new JButton("GO TO HOME");
        b5.setBackground(Color.BLACK);
        b5.setForeground(Color.WHITE);
        b5.setFont(new Font("Arial", Font.BOLD, 16));
        b5.setBounds(400,550,200,30);
        l11.add(b5);

        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        b4.addActionListener(this);
        b5.addActionListener(this);

        Book();

        setLocation(200,100);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setSize(1000, 650);
        setVisible(true);
    }

    public static void main(String[] args) {
        new BookDetails();
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        try{

            conn con = new conn();
            if(ae.getSource() == b1){

                String sql = "select * from book1 where concat(NAME, BOOKID) like ?";
                PreparedStatement st = con.c.prepareStatement(sql);
                st.setString(1, "%" + tf1.getText() + "%");
                ResultSet rs = st.executeQuery();

                t1.setModel(DbUtils.resultSetToTableModel(rs));
                rs.close();
                st.close();
            }
            if (ae.getSource() == b2){
                this.setVisible(false);
                new UpBook().setVisible(true);
            }
            if (ae.getSource() == b3){
                this.setVisible(false);
                new UpBook().setVisible(true);
            }
            if (ae.getSource() == b4){
                this.setVisible(false);
                new StudentDetails().setVisible(true);
            }
            if (ae.getSource() == b5){
                this.setVisible(false);
                new eg().setVisible(true);
            }

            con.c.close();
        }catch(Exception e){

        }
    }
}

