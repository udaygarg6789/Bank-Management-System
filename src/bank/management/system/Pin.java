package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Pin extends JFrame implements ActionListener {
    String pincode;
    JButton back, ok;
    JPasswordField p1,p2;
    Pin(String pincode){
        super("Change PIN");


        this.pincode = pincode;

        JLabel head = new JLabel("Please Enter Your New PIN :");
        head.setBounds(320, 120, 410, 30);
        head.setFont(new Font("Arial", Font.BOLD, 21));
        head.setForeground(Color.WHITE);
        add(head);
        p1 = new JPasswordField();
        p1.setForeground(Color.WHITE);
        p1.setBackground(Color.BLACK);
        p1.setBounds(320, 160, 200, 30);
        p1.setHorizontalAlignment(JPasswordField.CENTER);
        p1.setFont(new Font("Arial", Font.BOLD, 25));
        add(p1);

        JLabel again = new JLabel("Please Re-Enter Your New PIN :");
        again.setBounds(320, 210, 410, 30);
        again.setFont(new Font("Arial", Font.BOLD, 21));
        again.setForeground(Color.WHITE);
        add(again);
        p2 = new JPasswordField();
        p2.setForeground(Color.WHITE);
        p2.setBackground(Color.BLACK);
        p2.setHorizontalAlignment(JPasswordField.CENTER);
        p2.setBounds(320, 250, 200, 30);
        p2.setFont(new Font("Arial", Font.BOLD, 25));
        add(p2);

        ok = new JButton("Confirm");
        ok.setBounds(520, 330, 100, 30);
        ok.setBackground(new Color(0x0A66C2));
        ok.setForeground(Color.WHITE);
        ok.setFont(new Font("Arial", Font.BOLD, 15));
        ok.addActionListener(this);
        add(ok);

        back = new JButton("Back");
        back.setBounds(635, 330, 100, 30);
        back.setBackground(new Color(0x0A66C2));
        back.setForeground(Color.WHITE);
        back.setFont(new Font("Arial", Font.BOLD, 15));
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
        try{
            String pin1 = p1.getText();
            String pin2 = p2.getText();

            if(e.getSource() == back){
                new main_bank(pincode);
                setVisible(false);
                return;
            }

            if(e.getSource() == ok){
                if(p1.getText().equals("")){
                    JOptionPane.showMessageDialog(null, "Please Enter your new PIN");
                    return;
                }
                if(p2.getText().equals("")){
                    JOptionPane.showMessageDialog(null, "Please Re-Enter your new PIN");
                    return;
                }
            }
            if(!pin1.equals(pin2)){
                JOptionPane.showMessageDialog(null,"Entered PIN Does Not match");
                return;
            }
            con conpin = new con();
            String q1 = "update bank set PIN = '"+pin1+"' where PIN ='"+pincode+"' ";
            String q2 = "update login set PIN = '"+pin1+"' where PIN ='"+pincode+"' ";
            String q3 = "update signup set pincode = '"+pin1+"' where pincode ='"+pincode+"' ";

            conpin.statement.executeUpdate(q1);
            conpin.statement.executeUpdate(q2);
            conpin.statement.executeUpdate(q3);

            JOptionPane.showMessageDialog(null, "PIN Changed Successfully");
            setVisible(false);
            new main_bank(pincode);


        }
            catch (Exception E){
            E.printStackTrace();
        }


    }

    public static void main(String[] args) {
        new Pin("");
    }
}
