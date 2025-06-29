package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class MiniStatement extends JFrame implements ActionListener {
    String pincode;
    JButton button;
    MiniStatement(String pincode){

        this.pincode = pincode;

        JTextArea textArea = new JTextArea();
        textArea.setEditable(false);
        textArea.setFont(new Font("System", Font.PLAIN, 12));
        textArea.setBackground(new Color(0xFDF6E3));
        JScrollPane scrollPane = new JScrollPane(textArea);
        scrollPane.setBounds(10, 140, 300, 250);
        add(scrollPane);

        JLabel label2 = new JLabel("Your Statements :");
        label2.setFont(new Font("System", Font.BOLD,15));
        label2.setBounds(100,20,200,20);
        add(label2);

        JLabel label3 = new JLabel();
        label3.setFont(new Font("System", Font.BOLD,12));
        label3.setBounds(20,80,300,20);
        add(label3);

        JLabel label4 = new JLabel();
        label4.setBounds(20,400,300,20);
        add(label4);

        try{
            Connn constatement = new Connn();
            ResultSet resultSet = constatement.statement.executeQuery("select * from login where PIN = '"+pincode+"'");
            while (resultSet.next()){
                label3.setText("Card Number:  "+ resultSet.getString("card_number").substring(0,4) + "-XXXX-XXXX-"+ resultSet.getString("card_number").substring(12));
            }
        }catch (Exception e ){
            e.printStackTrace();
        }

        try{
            int balance =0;
            Connn c = new Connn();
            ResultSet resultSet = c.statement.executeQuery("select * from bank where PIN = '"+pincode+"'");
            while (resultSet.next()){

                textArea.append(resultSet.getString("date") + "   " +
                        resultSet.getString("type") + "   " +
                        resultSet.getString("amount") + "\n\n");

                if (resultSet.getString("type").equals("Deposit")){
                    balance += Integer.parseInt(resultSet.getString("amount"));
                }else {
                    balance -= Integer.parseInt(resultSet.getString("amount"));
                }
            }
            label4.setText("Your Total Balance is Rs "+balance);
        }catch (Exception e){
            e.printStackTrace();
        }
        button = new JButton("Exit");
        button.setBounds(200,450,100,25);
        button.addActionListener(this);
        button.setBackground(Color.BLACK);
        button.setForeground(Color.WHITE);
        add(button);



        setLayout(null);
        setSize(320, 500);
        getContentPane().setBackground(new Color(0xFDF6E3));
        setLocation(819,90);
        setUndecorated(true);
        setVisible(true);


    }

    @Override
    public void actionPerformed(ActionEvent e) {
        setVisible(false);
    }

    public static void main(String[] args) {
        new MiniStatement("");
    }
}
