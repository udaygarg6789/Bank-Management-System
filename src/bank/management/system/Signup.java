package bank.management.system;

import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class Signup extends JFrame implements ActionListener {

    JRadioButton r1, r2, m1, m2, m3;      // this is for making select buttons in gender (male 'r1' or female 'r2')
    JDateChooser dateChooser;
    JTextField nametext, fnametext,textmail, textadd, textc, textpc, textst;
    Random ran = new Random();
    long first4 = (ran.nextLong() % 9000L) + 1000L;
    String first = "" + Math.abs(first4);

    Signup(){
        super("APPLICATION FORM PAGE-1");

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/bank.png"));
        Image i2 = i1.getImage().getScaledInstance(100,100,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(25, 10,100,100);
        add(image);

        JLabel label1 = new JLabel("APPLICATION FORM NO." + first);
        label1.setBounds(180, 20, 600, 40);
        label1.setFont(new Font("Raleway", Font.BOLD, 38));
        add(label1);

        JLabel label2 = new JLabel("Page 1");
        label2.setBounds(330, 70, 600, 30);
        label2.setFont(new Font("Raleway", Font.BOLD, 22));
        add(label2);

        JLabel label3 = new JLabel("Personal Details");
        label3.setBounds(290, 90, 600, 30);
        label3.setFont(new Font("Raleway", Font.BOLD, 22));
        add(label3);

        JLabel label4 = new JLabel("Name :");
        label4.setBounds(130, 170, 100, 25);
        label4.setFont(new Font("Raleway", Font.BOLD, 20));
        add(label4);
        nametext = new JTextField();
        nametext.setBounds(300, 170, 300, 25);
        nametext.setFont(new Font("Arial", Font.BOLD, 14));
        add(nametext);

        JLabel label5 = new JLabel("Father's Name :");
        label5.setBounds(130, 210, 200, 25);
        label5.setFont(new Font("Raleway", Font.BOLD, 20));
        add(label5);
        fnametext = new JTextField();
        fnametext.setBounds(300, 210, 300, 25);
        fnametext.setFont(new Font("Arial", Font.BOLD, 14));
        add(fnametext);

        JLabel labelgd = new JLabel("Gender :");
        labelgd.setBounds(130, 250, 100, 25);
        labelgd.setFont(new Font("Raleway", Font.BOLD, 20));
        add(labelgd);
        r1 = new JRadioButton("Male");
        r1.setFont(new Font("Arial",Font.BOLD, 17));
        r1.setBounds(300, 250, 100, 25);
        r1.setBackground(new Color(222, 255, 228));
        add(r1);
        r2 = new JRadioButton("female");
        r2.setFont(new Font("Arial",Font.BOLD, 17));
        r2.setBounds(400, 250, 100, 25);
        r2.setBackground(new Color(222, 255, 228));
        add(r2);

        ButtonGroup firstgroup = new ButtonGroup();
        firstgroup.add(r1);
        firstgroup.add(r2);

        JLabel DOB = new JLabel("Choose DOB :");
        DOB.setBounds(130, 290, 200, 25);
        DOB.setFont(new Font("Raleway", Font.BOLD, 20));
        add(DOB);
        dateChooser = new JDateChooser();
        dateChooser.setForeground(new Color(105,105,105));
        dateChooser.setBounds(300, 290, 300, 25);
        add(dateChooser);

        JLabel labelmail = new JLabel("Email address :");
        labelmail.setBounds(130, 330, 200, 25);
        labelmail.setFont(new Font("Raleway", Font.BOLD, 20));
        add(labelmail);
        textmail = new JTextField();
        textmail.setBounds(300, 330, 300, 25);
        textmail.setFont(new Font("Arial", Font.BOLD, 14));
        add(textmail);

        JLabel labelms = new JLabel("Marital Status :");
        labelms.setBounds(130, 370, 200, 25);
        labelms.setFont(new Font("Raleway", Font.BOLD, 20));
        add(labelms);
        m1 = new JRadioButton("Married");
        m1.setFont(new Font("Arial",Font.BOLD, 17));
        m1.setBounds(300, 370, 100, 25 );
        m1.setBackground(new Color(222, 255, 228));
        add(m1);
        m2 = new JRadioButton("Single");
        m2.setBounds(400, 370, 100, 25);
        m2.setFont(new Font("Arial",Font.BOLD, 17));
        m2.setBackground(new Color(222, 255, 228));
        add(m2);
        m3 = new JRadioButton("Divorced");
        m3.setBounds(500, 370, 100, 25);
        m3.setFont(new Font("Arial", Font.BOLD, 17));
        m3.setBackground(new Color(222, 255, 228));
        add(m3);
        ButtonGroup secondgroup = new ButtonGroup();
        secondgroup.add(m1);
        secondgroup.add(m2);
        secondgroup.add(m3);

        JLabel labeladd = new JLabel("Address :");
        labeladd.setBounds(130, 410, 100, 25);
        labeladd.setFont(new Font("Raleway", Font.BOLD, 20));
        add(labeladd);
        textadd = new JTextField();
        textadd.setBounds(300, 410, 300, 25);
        textadd.setFont(new Font("Arial", Font.BOLD, 14));
        add(textadd);

        JLabel labelc = new JLabel("City :");
        labelc.setBounds(130, 450, 100, 25);
        labelc.setFont(new Font("Raleway", Font.BOLD, 20));
        add(labelc);
        textc = new JTextField();
        textc.setBounds(300, 450, 300, 25);
        textc.setFont(new Font("Arial", Font.BOLD, 20));
        add(textc);

        JLabel labelpc = new JLabel("Set PIN Code :");
        labelpc.setBounds(130, 490, 150, 25);
        labelpc.setFont(new Font("Raleway", Font.BOLD, 20));
        add(labelpc);
        textpc = new JTextField();
        textpc.setBounds(300, 490, 300, 25);
        textpc.setFont(new Font("Arial", Font.BOLD, 20));
        add(textpc);

        JLabel labelst = new JLabel("State :");
        labelst.setFont(new Font("Raleway", Font.BOLD, 20));
        labelst.setBounds(130, 530, 100, 25);
        add(labelst);
        textst = new JTextField();
        textst.setBounds(300, 530, 300, 25);
        textst.setFont(new Font("Arial", Font.BOLD, 20));
        add(textst);

        JButton butnext = new JButton("Next");
        butnext.setForeground(Color.WHITE);
        butnext.setBackground(Color.BLACK);
        butnext.setFont(new Font("Arial", Font.BOLD, 14));
        butnext.setBounds(500, 590, 100, 25);
        butnext.addActionListener(this);
        add(butnext);

        getContentPane().setBackground(new Color(222, 255, 228));
        setLayout(null);
        setSize(850, 700);
        setLocation(360,30);
        setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String formno = first;
        String name = nametext.getText();
        String fname = fnametext.getText();
        String dob = ((JTextField) dateChooser.getDateEditor().getUiComponent()).getText();
        String gender = null;
        if(r1.isSelected()){
            gender = "Male";
        }else if(r2.isSelected()){
            gender = "Female";
        }
        String email = textmail.getText();
        String maritalstatus = null;
        if(m1.isSelected()){
            maritalstatus = "Married";
        }else if(m2.isSelected()){
            maritalstatus = "Single";
        }else if(m3.isSelected()){
            maritalstatus = "Divorced";
        }
        String address = textadd.getText();
        String city = textc.getText();
        String PIN = textpc.getText();
        String state = textst.getText();

        try{
            if(nametext.getText().equals("")){
                JOptionPane.showMessageDialog(null, "Fill all the fields");
            }else if(textpc.getText().equals("")){
                JOptionPane.showMessageDialog(null,"Please set your PIN Code");

            }else if (!textpc.getText().matches("\\d{4}")) {
                JOptionPane.showMessageDialog(null, "PIN Code must be exactly 4 digits (numbers only)");
            }
            else{
                con con1 = new con();
                String q = "insert into signup values('"+formno+"', '"+name+"', '"+fname+"', '"+dob+"', '"+gender+"', '"+email+"', '"+maritalstatus+"', '"+address+"', '"+city+"', '"+PIN+"', '"+state+"')";
                con1.statement.executeUpdate(q);
                new Signup2(first, PIN);
                setVisible(false);

            }

        } catch (Exception E){
            E.printStackTrace();
        }

    }

    public static void main(String[] args) {
        new Signup();
    }
}
