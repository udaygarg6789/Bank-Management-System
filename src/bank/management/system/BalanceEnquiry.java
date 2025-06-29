package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.text.NumberFormat;

public class BalanceEnquiry extends JFrame implements ActionListener {
    String pincode;
    JLabel currentbalance;
    JButton backbut;
    BalanceEnquiry(String pincode){

        this.pincode = pincode;

        JLabel toplabel = new JLabel("This is your Current Balance :");
        toplabel.setBounds(310, 130, 380, 30 );
        toplabel.setFont(new Font("Arial", Font.BOLD, 25));
        toplabel.setForeground(Color.WHITE);

        add(toplabel);

        currentbalance = new JLabel();
        currentbalance.setBounds(440, 210, 200, 30);
        currentbalance.setFont(new Font("Arial", Font.BOLD, 30));
        currentbalance.setForeground(Color.WHITE);
        add(currentbalance);

        backbut = new JButton("Back");
        backbut.setBounds(635, 330, 100, 30);
        backbut.setBackground(new Color(0x0A66C2));
        backbut.setForeground(Color.WHITE);
        backbut.setFont(new Font("Arial", Font.BOLD, 15));
        backbut.addActionListener(this);
        add(backbut);

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



        int balance = 0;
        try{
            Connn conamount = new Connn();
            ResultSet result = conamount.statement.executeQuery("select * from bank where PIN ='"+pincode+"' ");

            while(result.next()){
                if(result.getString("type").equals("Deposit")){
                    balance += Integer.parseInt(result.getString("amount"));

                }
                else{
                    balance -= Integer.parseInt(result.getString("amount"));
                }

            }
        }

        catch (Exception E){
            E.printStackTrace();
        }
        NumberFormat formatter = NumberFormat.getInstance();
        currentbalance.setText("Rs. " + formatter.format(balance));
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == backbut){
            new main_bank(pincode);
            setVisible(false);
        }

    }

    public static void main(String[] args) {
        new BalanceEnquiry("");
    }
}
