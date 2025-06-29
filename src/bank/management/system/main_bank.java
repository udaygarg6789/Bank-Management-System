package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class main_bank extends JFrame implements ActionListener {
    String pincode;
    JButton dep, fc, pc, cw, ms, be, exit;

    main_bank(String pincode){
        super("Welcome to your Bank Account");

        this.pincode = pincode;
        JLabel headlabel = new JLabel("Hello, How can I help you today?");
        headlabel.setForeground(Color.WHITE);
        headlabel.setFont(new Font("Arial", Font.BOLD, 20));
        headlabel.setBounds(380, 120, 400, 30);
        add(headlabel);


        dep = new JButton("Deposit");
        dep.setBounds(310, 205, 130, 33);
        dep.setBackground(new Color(0x0A66C2));
        dep.setForeground(Color.WHITE);
        dep.setFont(new Font("Arial", Font.BOLD, 15));
        dep.addActionListener(this);
        add(dep);

        fc = new JButton("Fast Cash");
        fc.setBounds(310, 250, 130, 33);
        fc.setBackground(new Color(0x0A66C2));
        fc.setForeground(Color.WHITE);
        fc.setFont(new Font("Arial", Font.BOLD, 15));
        fc.addActionListener(this);
        add(fc);

        pc = new JButton("PIN Change");
        pc.setBounds(310, 295, 130, 33);
        pc.setBackground(new Color(0x0A66C2));
        pc.setForeground(Color.WHITE);
        pc.setFont(new Font("Arial", Font.BOLD, 15));
        pc.addActionListener(this);
        add(pc);

        cw = new JButton("Cash Withdrawal");
        cw.setBounds(580, 205, 160, 33);
        cw.setBackground(new Color(0x0A66C2));
        cw.setForeground(Color.WHITE);
        cw.setFont(new Font("Arial", Font.BOLD, 15));
        cw.addActionListener(this);
        add(cw);

        ms = new JButton("MINI Statements");
        ms.setBounds(580, 250, 160, 33);
        ms.setBackground(new Color(0x0A66C2));
        ms.setForeground(Color.WHITE);
        ms.setFont(new Font("Arial", Font.BOLD, 15));
        ms.addActionListener(this);
        add(ms);

        be = new JButton("Balance Enquiry");
        be.setBounds(580, 295, 160, 35);
        be.setBackground(new Color(0x0A66C2));
        be.setForeground(Color.WHITE);
        be.setFont(new Font("Arial", Font.BOLD, 15));
        be.addActionListener(this);
        add(be);

        exit = new JButton("Exit");
        exit.setBounds(580, 340, 160, 33);
        exit.setBackground(new Color(0x0A66C2));
        exit.setForeground(Color.WHITE);
        exit.setFont(new Font("Arial", Font.BOLD, 15));
        exit.addActionListener(this);
        add(exit);







        ImageIcon i = new ImageIcon(ClassLoader.getSystemResource("icon/atm.png"));
        Image i2 = i.getImage().getScaledInstance(900, 690, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel atmimage = new JLabel(i3);
        atmimage.setBounds(200,0, 900, 690);
        add(atmimage);

        setLayout(null);
        setSize(1400, 1000);
        getContentPane().setBackground(new Color(0x414145));
        setLocation(0,0);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            if (e.getSource() == dep) {
                new Deposit(pincode);
                setVisible(false);
            }
            else if(e.getSource() == cw){
                new Withdrawal(pincode);
                setVisible(false);
            }
            else if(e.getSource() == be){
                new BalanceEnquiry(pincode);
                setVisible(false);
            }
            else if(e.getSource() == pc){
                new Pin(pincode);
                setVisible(false);
            }
            else if(e.getSource() == fc){
                new FastCash(pincode);
                setVisible(false);
            } else if(e.getSource() == ms){
                new MiniStatement(pincode);

            }



            if(e.getSource() == exit){
                System.exit(0);
            }
        }
        catch (Exception E){
            E.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new main_bank("");
    }
}
