package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

public class Deposit extends JFrame implements ActionListener {
    JTextField f1;
    JButton confirm, cancel;
    String pincode;

    Deposit( String pin){
        super("Deposit Page");

        this.pincode = pin;
        JLabel l1 = new JLabel("Enter the amount you want to deposit");
        l1.setForeground(Color.WHITE);
        l1.setFont(new Font("Arial", Font.BOLD, 17));
        l1.setBounds(370, 120, 400, 30);
        add(l1);

        f1 = new JTextField();
        f1.setBackground(Color.DARK_GRAY);
        f1.setForeground(Color.WHITE);
        f1.setFont(new Font("Arial", Font.BOLD, 25));
        f1.setHorizontalAlignment(JTextField.CENTER);
        f1.setBounds(393, 160, 250, 32);
        add(f1);



        ImageIcon ii = new ImageIcon(ClassLoader.getSystemResource("icon/rupee.png"));
        Image ii2 = ii.getImage().getScaledInstance(15, 20, Image.SCALE_DEFAULT);
        ImageIcon ii3 = new ImageIcon(ii2);
        JLabel rupeeimage = new JLabel(ii3);
        rupeeimage.setBounds(650,165, 15, 20);
        add(rupeeimage);

        confirm = new JButton("CONFIRM");
        confirm.setFont(new Font("Arial", Font.BOLD, 12));
        confirm.setForeground(Color.WHITE);
        confirm.setBackground(new Color(0x29CA16));
        confirm.setMargin(new Insets(2,5,2,5));
        confirm.setBounds(650, 290, 70, 25);
        confirm.addActionListener(this);
        add(confirm);

        cancel = new JButton("CANCEL");
        cancel.setFont(new Font("Arial", Font.BOLD, 12));
        cancel.setForeground(Color.WHITE);
        cancel.setBackground(new Color(0xC81717));
        cancel.setMargin(new Insets(2,5,2,5));
        cancel.setBounds(650, 330, 70, 25);
        cancel.addActionListener(this);
        add(cancel);

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
        String amount = f1.getText();
        Date date = new Date();


        try{
            if(e.getSource() == confirm){
                if(f1.getText().equals("")){
                    JOptionPane.showMessageDialog(null,"Please enter the amount to want to deposit");
                }
                else{
                    con con4 = new con();
                    con4.statement.executeUpdate("insert into bank values('"+pincode+"','"+date+"', 'Deposit', '"+amount+"' )");
                    JOptionPane.showMessageDialog(null, "Rs. "+amount+" Deposited Successfully");
                    setVisible(false);
                    new main_bank(pincode);
                }

            }
            if(e.getSource() == cancel){
                new main_bank(pincode);
                setVisible(false);
            }
        }
        catch (Exception E){
            E.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new Deposit("");
    }
}
