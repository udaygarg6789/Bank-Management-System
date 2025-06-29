package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.sql.ResultSet;

public class FastCash extends JFrame implements ActionListener {
    String pincode;
    JButton hundred,five_hundred, thousand, two_thousand, five_thousand, ten_thousand, back ;
    FastCash(String pincode){
        super("Fast Cash");

        this.pincode = pincode;

        JLabel toplabel = new JLabel("Select your Withdrawl Amount :");
        toplabel.setBounds(310, 130, 380, 30);
        toplabel.setFont(new Font("Arial", Font.BOLD, 25));
        toplabel.setFont(new Font("Arial", Font.BOLD, 25));
        toplabel.setForeground(Color.WHITE);
        add(toplabel);

        hundred = new JButton("Rs 100");
        hundred.setBounds(310, 205, 130, 33);
        hundred.setBackground(new Color(0x0A66C2));
        hundred.setForeground(Color.WHITE);
        hundred.setFont(new Font("Arial", Font.BOLD, 20));
        hundred.addActionListener(this);
        add(hundred);

        five_hundred = new JButton("Rs 500");
        five_hundred.setBounds(310, 250, 130, 33);
        five_hundred.setBackground(new Color(0x0A66C2));
        five_hundred.setForeground(Color.WHITE);
        five_hundred.setFont(new Font("Arial", Font.BOLD, 20));
        five_hundred.addActionListener(this);
        add(five_hundred);

        thousand = new JButton("Rs 1,000");
        thousand.setBounds(310, 295, 130, 33);
        thousand.setBackground(new Color(0x0A66C2));
        thousand.setForeground(Color.WHITE);
        thousand.setFont(new Font("Arial", Font.BOLD, 20));
        thousand.addActionListener(this);
        add(thousand);

        two_thousand = new JButton("Rs 2,000");
        two_thousand.setBounds(580, 205, 160, 33);
        two_thousand.setBackground(new Color(0x0A66C2));
        two_thousand.setForeground(Color.WHITE);
        two_thousand.setFont(new Font("Arial", Font.BOLD, 20));
        two_thousand.addActionListener(this);
        add(two_thousand);

        five_thousand = new JButton("Rs 5,000");
        five_thousand.setBounds(580, 250, 160, 33);
        five_thousand.setBackground(new Color(0x0A66C2));
        five_thousand.setForeground(Color.WHITE);
        five_thousand.setFont(new Font("Arial", Font.BOLD, 20));
        five_thousand.addActionListener(this);
        add(five_thousand);

        ten_thousand = new JButton("Rs 10,000");
        ten_thousand.setBounds(580, 295, 160, 35);
        ten_thousand.setBackground(new Color(0x0A66C2));
        ten_thousand.setForeground(Color.WHITE);
        ten_thousand.setFont(new Font("Arial", Font.BOLD, 20));
        ten_thousand.addActionListener(this);
        add(ten_thousand);


        back = new JButton("Back");
        back.setBounds(580, 340, 160, 33);
        back.setBackground(new Color(0x0A66C2));
        back.setForeground(Color.WHITE);
        back.setFont(new Font("Arial", Font.BOLD, 20));
        back.addActionListener(this);
        add(back);


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
        if (e.getSource()==back) {
            setVisible(false);
            new main_bank(pincode);
        }else {
            String amount = ((JButton)e.getSource()).getText().substring(3).replace(",", "").trim();
            con fccon = new con();
            Date date = new Date();
            try{
                ResultSet resultSet = fccon.statement.executeQuery("select * from bank where pin = '"+pincode+"'");
                int balance =0;
                while (resultSet.next()){
                    if (resultSet.getString("type").equals("Deposit")){
                        balance += Integer.parseInt(resultSet.getString("amount"));
                    }else {
                        balance -= Integer.parseInt(resultSet.getString("amount"));
                    }
                }

                if (e.getSource() != back && balance < Integer.parseInt(amount)){
                    JOptionPane.showMessageDialog(null, "Insufficient Balance");
                    return;
                }

                fccon.statement.executeUpdate("insert into bank values('"+pincode+"','"+date+"', 'withdrawal', '"+amount+"')");
                JOptionPane.showMessageDialog(null, "Rs. "+amount+" Debited Successfully");
            }catch (Exception E){
                E.printStackTrace();
            }
            setVisible(false);
            new BalanceEnquiry(pincode);
        }
    }

    public static void main(String[] args) {
        new FastCash("");
    }
}
