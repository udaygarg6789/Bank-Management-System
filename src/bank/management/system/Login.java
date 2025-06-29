package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

// Imported ActionListner so we can handle action events such as buttons, selecting a menu item, or pressing enter in text field
public class Login extends JFrame implements ActionListener {

    // Here we declared lable1 as jlabel so we can use it to show text
    JLabel label1, label2, label3;

    // Here we declared textfields so user can give input
    JTextField textfield2;

    // Here we declared textfield for Password so it is hidden and secure to enter
    JPasswordField passwordfield3;

    // Here we declared jbutton to put few buttons on our login page
    JButton button1, button2, button3;

    Login(){      //created a constructor
        
        super("Bank Management System");

        // Bank Logo Imported and showed here
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/bank.png"));   // imports the image from file location to i1
        Image i2 = i1.getImage().getScaledInstance(100,100,Image.SCALE_DEFAULT);   // scaled the image in i2
        ImageIcon i3 = new ImageIcon(i2);   // put the scaled image in i3
        JLabel image = new JLabel(i3);      // we can't directly display the image so we have to use jlabel here
        image.setBounds(350, 10,100,100);  // to decide the location of the image in the frame
        add(image);

        // Card Hand Image Imported and Showed here
        ImageIcon ii1 = new ImageIcon(ClassLoader.getSystemResource("icon/card.png"));
        Image ii2 = ii1.getImage().getScaledInstance(100,100,Image.SCALE_DEFAULT);
        ImageIcon ii3 = new ImageIcon(ii2);
        JLabel iimage = new JLabel(ii3);
        iimage.setBounds(630, 340,100,100);
        add(iimage);



        // Text on top "Welcome to the ATM" on screen
        label1 = new JLabel("Welcome to the ATM");
        label1.setForeground(Color.white);
        label1.setFont(new Font("AvantGrade", Font.BOLD, 38));
        label1.setBounds(230, 125, 450, 40);
        add(label1);



        //Enter Card Number text on screen
        label2 = new JLabel("Enter Card No:");
        label2.setForeground(Color.black);
        label2.setFont(new Font("Railway", Font.ITALIC | Font.BOLD, 20));
        label2.setBounds(150, 220, 375, 30);
        add(label2);

        // textfield so user can input card no. data
        textfield2 = new JTextField(15);
        textfield2.setBounds(320, 220, 230, 30);
        textfield2.setFont(new Font("Arial", Font.BOLD, 20));
        add(textfield2);



        // Enter PIN text
        label3 = new JLabel("Enter PIN:");
        label3.setForeground(Color.black);
        label3.setFont(new Font("Railway", Font.ITALIC | Font.BOLD, 20));
        label3.setBounds(150,260, 375,30);
        add(label3);

        // Enter PIN Input
        passwordfield3 = new JPasswordField(15);
        passwordfield3.setBounds(320, 260, 230, 30);
        passwordfield3.setFont((new Font("Arial", Font.BOLD, 20)));
        add(passwordfield3);


        // Creating buttons
        button1 = new JButton("SIGN IN");
        button1.setForeground(Color.black);
        button1.setBackground(Color.yellow);
        button1.setFont(new Font("Arial", Font.BOLD, 14));
        button1.setBounds(270, 300, 100, 30);
        button1.addActionListener(this);  // so buttons can work
        add(button1);

        button2 = new JButton("CLEAR");
        button2.setForeground(Color.black);
        button2.setBackground(Color.yellow);
        button2.setFont(new Font("Arial", Font.BOLD, 14));
        button2.setBounds(400, 300, 100, 30);
        button2.addActionListener(this);
        add(button2);

        button3 = new JButton("SIGN UP");
        button3.setForeground(Color.black);
        button3.setBackground(Color.yellow);
        button3.setFont(new Font("Arial", Font.BOLD, 14));
        button3.setBounds(270, 350, 230, 30);
        button3.addActionListener(this);
        add(button3);


        // BackGround Image Imported and Showed here
        ImageIcon iii1 = new ImageIcon(ClassLoader.getSystemResource("icon/backbg.png"));
        Image iii2 = iii1.getImage().getScaledInstance(850,480,Image.SCALE_DEFAULT);
        ImageIcon iii3 = new ImageIcon(iii2);
        JLabel iiimage = new JLabel(iii3);
        iiimage.setBounds(0, 0,850,480);
        add(iiimage);





        setLayout(null);
        setSize(850,480);
        setLocation(390,80);
        setVisible(true);

    }

    // Just remember we have to write this while using ActionEvent
    @Override
    public void actionPerformed(ActionEvent e) {
        // Whenever we click on a button, actionEnvent will store it. So it knows when a button is clicked

        String cardnumber = textfield2.getText();
        String pincode = passwordfield3.getText();
        try {
            if(e.getSource() == button1){
                con maincon = new con();
                String entry = "select * from login where card_number = '"+cardnumber+"' and PIN = '"+pincode+"' ";
                ResultSet re = maincon.statement.executeQuery(entry);
                if(re.next()){
                    setVisible(false);
                    new main_bank(pincode);
                }
                else{
                    JOptionPane.showMessageDialog(null,"Incorrect Card no. or PIN");
                }

            } else if(e.getSource() == button2){
                textfield2.setText("");
                passwordfield3.setText("");

            } else if (e.getSource() == button3) {
                new Signup();
                setVisible(false);
            }

        }
        catch (Exception E){
            E.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new Login(); // created an object

    }
}
