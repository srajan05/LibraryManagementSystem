import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class eg extends JFrame implements ActionListener {

    JButton b1,b2,b3,b4,b5,b6,b7,b8;
    JMenu menu1,menu2,menu3,menu4;
    JMenuItem itm1,itm2,itm3,itm4,itm5,itm7,itm8;

    eg(){

        setTitle("LIBRARY MANAGEMENT SYSTEM");
        //background
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("images/bg.png"));
        Image i2 = i1.getImage().getScaledInstance(1200, 800, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l11 = new JLabel(i3);
        l11.setBounds(0, 0, 1200, 800);
        add(l11);

        //new student
        ImageIcon j1=new ImageIcon(ClassLoader.getSystemResource("images/add1.png"));
        Image j2=j1.getImage().getScaledInstance(75,75,Image.SCALE_DEFAULT);
        ImageIcon j3=new ImageIcon(j2);
        JLabel l1=new JLabel(j3);
        l1.setBounds(50,300,75,75);
        l11.add(l1);

        //new book
        ImageIcon k1=new ImageIcon(ClassLoader.getSystemResource("images/add2.png"));
        Image k2=k1.getImage().getScaledInstance(75,75,Image.SCALE_DEFAULT);
        ImageIcon k3=new ImageIcon(k2);
        JLabel l2=new JLabel(k3);
        l2.setBounds(50,400,75,75);
        l11.add(l2);

        //new account
        ImageIcon m1=new ImageIcon(ClassLoader.getSystemResource("images/add3.png"));
        Image m2=m1.getImage().getScaledInstance(75,75,Image.SCALE_DEFAULT);
        ImageIcon m3=new ImageIcon(m2);
        JLabel l3=new JLabel(m3);
        l3.setBounds(50,500,75,75);
        l11.add(l3);

        //Statics
        ImageIcon n1=new ImageIcon(ClassLoader.getSystemResource("images/add4.png"));
        Image n2=n1.getImage().getScaledInstance(75,75,Image.SCALE_DEFAULT);
        ImageIcon n3=new ImageIcon(n2);
        JLabel l4=new JLabel(n3);
        l4.setBounds(50,600,75,75);
        l11.add(l4);

        //Issue
        ImageIcon o1=new ImageIcon(ClassLoader.getSystemResource("images/add5.png"));
        Image o2=o1.getImage().getScaledInstance(75,75,Image.SCALE_DEFAULT);
        ImageIcon o3=new ImageIcon(o2);
        JLabel l5=new JLabel(o3);
        l5.setBounds(1120,300,75,75);
        l11.add(l5);

        //return
        ImageIcon p1=new ImageIcon(ClassLoader.getSystemResource("images/add6.png"));
        Image p2=p1.getImage().getScaledInstance(75,75,Image.SCALE_DEFAULT);
        ImageIcon p3=new ImageIcon(p2);
        JLabel l6=new JLabel(p3);
        l6.setBounds(1120,400,75,75);
        l11.add(l6);

        //search
        ImageIcon q1=new ImageIcon(ClassLoader.getSystemResource("images/add7.png"));
        Image q2=q1.getImage().getScaledInstance(75,75,Image.SCALE_DEFAULT);
        ImageIcon q3=new ImageIcon(q2);
        JLabel l7=new JLabel(q3);
        l7.setBounds(1120,500,75,75);
        l11.add(l7);

        //modify
        ImageIcon r1=new ImageIcon(ClassLoader.getSystemResource("images/mod.png"));
        Image r2=r1.getImage().getScaledInstance(75,75,Image.SCALE_DEFAULT);
        ImageIcon r3=new ImageIcon(r2);
        JLabel l8=new JLabel(r3);
        l8.setBounds(1120,600,75,75);
        l11.add(l8);

        JLabel l9=new JLabel("OPERATION");
        l9.setFont(new Font("Osward", Font.BOLD, 20));
        l9.setBounds(150,200,200,30);
        l11.add(l9);

        JLabel l10=new JLabel("ACTION");
        l10.setFont(new Font("Osward", Font.BOLD, 20));
        l10.setBounds(950,200,100,30);
        l11.add(l10);

        JLabel t=new JLabel("DIGITAL LIBRARY MANAGEMENT SYSTEM");
        t.setFont(new Font("Osward", Font.BOLD, 50));
        t.setBounds(100,50,1200,40);
        l11.add(t);

        b1 = new JButton("ADD STUDENT");
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);

        b2 = new JButton("ADD BOOK");
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);

        b3 = new JButton("ADD ACCOUNT");
        b3.setBackground(Color.BLACK);
        b3.setForeground(Color.WHITE);

        b4 = new JButton("STATICS");
        b4.setBackground(Color.BLACK);
        b4.setForeground(Color.WHITE);

        b1.setFont(new Font("Arial", Font.BOLD, 14));
        b1.setBounds(150,325,230,30);
        l11.add(b1);

        b2.setFont(new Font("Arial", Font.BOLD, 14));
        b2.setBounds(150,425,230,30);
        l11.add(b2);

        b3.setFont(new Font("Arial", Font.BOLD, 14));
        b3.setBounds(150,525,230,30);
        l11.add(b3);

        b4.setFont(new Font("Arial", Font.BOLD, 14));
        b4.setBounds(150,625,230,30);
        l11.add(b4);

        // right wale button
        b5 = new JButton("ISSUE BOOK");
        b5.setBackground(Color.BLACK);
        b5.setForeground(Color.WHITE);

        b6 = new JButton("RETURN BOOK");
        b6.setBackground(Color.BLACK);
        b6.setForeground(Color.WHITE);

        b7 = new JButton("SEARCH");
        b7.setBackground(Color.BLACK);
        b7.setForeground(Color.WHITE);

        b8 = new JButton("MODIFY");
        b8.setBackground(Color.BLACK);
        b8.setForeground(Color.WHITE);

        b5.setFont(new Font("Arial", Font.BOLD, 14));
        b5.setBounds(875,325,230,30);
        l11.add(b5);

        b6.setFont(new Font("Arial", Font.BOLD, 14));
        b6.setBounds(875,425,230,30);
        l11.add(b6);

        b7.setFont(new Font("Arial", Font.BOLD, 14));
        b7.setBounds(875,525,230,30);
        l11.add(b7);

        b8.setFont(new Font("Arial", Font.BOLD, 14));
        b8.setBounds(875,625,230,30);
        l11.add(b8);

        // ADDING MENU BAR

        JMenuBar menuBar=new JMenuBar();
        menu1=new JMenu("RECORD");
        menu2=new JMenu("UPDATE");
        menu3=new JMenu("HELP");
        menu4=new JMenu("EXIT");

        itm1 = new JMenuItem("Student Details");
        itm2 = new JMenuItem("Book Details");
        itm3 = new JMenuItem("Modify Student");
        itm4 = new JMenuItem("Modify Book");
        itm5 = new JMenuItem("Forget Password");
        itm7 = new JMenuItem("Sign Out");
        itm8 = new JMenuItem("Exit");

        menu1.add(itm1);
        menu1.add(itm2);
        menu2.add(itm3);
        menu2.add(itm4);
        menu3.add(itm5);
        menu4.add(itm7);
        menu4.add(itm8);

        menuBar.add(menu1);
        menuBar.add(menu2);
        menuBar.add(menu3);
        menuBar.add(menu4);
        setJMenuBar(menuBar);

        //adding action listners
        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        b4.addActionListener(this);
        b5.addActionListener(this);
        b6.addActionListener(this);
        b7.addActionListener(this);
        b8.addActionListener(this);

        itm1.addActionListener(this);
        itm2.addActionListener(this);
        itm3.addActionListener(this);
        itm4.addActionListener(this);
        itm5.addActionListener(this);
        itm7.addActionListener(this);
        itm8.addActionListener(this);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setSize(1400,800);
        setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent ae) {

        String msg = ae.getActionCommand();

        if (msg.equals("Sign Out")) {
            setVisible(false);
            new Login1().setVisible(true);
        } else if (msg.equals("Exit")) {
            System.exit(ABORT);
        } else if (msg.equals("Book Details")) {
            setVisible(false);
            new BookDetails().setVisible(true);
        } else if (msg.equals("Student Details")) {
            setVisible(false);
            new StudentDetails().setVisible(true);
        } else if (msg.equals("Forget Password")) {
            setVisible(false);
            new forget2().setVisible(true);
        } else if (msg.equals("Modify Book")) {
            setVisible(false);
            new UpBook().setVisible(true);
        } else if (msg.equals("Modify Student")) {
            setVisible(false);
            new UpStd().setVisible(true);
        }

        if (ae.getSource() == b1) {
            this.setVisible(false);
            new addStudent().setVisible(true);
        }
        if (ae.getSource() == b2) {
            this.setVisible(false);
            new addBook().setVisible(true);
        }
        if (ae.getSource() == b3) {
            this.setVisible(false);
            new signup2().setVisible(true);
        }
        if (ae.getSource() == b4) {
            this.setVisible(false);
            new statics().setVisible(true);
        }
        if (ae.getSource() == b5) {
            this.setVisible(false);
            new IssueBook().setVisible(true);
        }
        if (ae.getSource() == b6) {
            this.setVisible(false);
            new ReturnBook().setVisible(true);
        }
        if (ae.getSource() == b7) {
            this.setVisible(false);
            new BookDetails().setVisible(true);
        }
        if (ae.getSource() == b8) {
            this.setVisible(false);
            new UpBook().setVisible(true);
        }
    }
    public static void main(String[] args) {
        new eg();
    }
}
