package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class Signup3 extends JFrame implements ActionListener {
    String formno;
    String pin;
    JRadioButton a1,a2,a3,a4;
    JCheckBox c1,c2,c3,c4,c5,c6;
    JButton s, c;
    Random ran = new Random();      // using Random to generate no.
    Long first = (ran.nextLong()%90000000L) + 1409963000000000L;        // for the 16-digit card no.
    String cdno = "" + Math.abs(first);
    String last4 = cdno.substring(cdno.length()-4);             // with this now only last 4 rendom digits are choosen from the random generated 16 digit letter
    String maskedcard = "XXXX-XXXX-XXXX-" + last4;



    Signup3(String first , String pincode){
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/bank.png"));
        Image i2 = i1.getImage().getScaledInstance(100,100,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(25, 10,100,100);
        add(image);
        this.formno = first;
        this.pin = pincode;

        JLabel aptext = new JLabel("Account Type :");
        aptext.setBounds(130, 130, 150, 30);
        aptext.setForeground(Color.WHITE);
        aptext.setFont(new Font("Arial", Font.BOLD, 20));
        add(aptext);
        a1 = new JRadioButton("Saving Account");
        a1.setBounds(150, 180, 150, 30);
        a1.setForeground(Color.WHITE);
        a1.setFont(new Font("Arial", Font.BOLD, 17));
        a1.setOpaque(false);
        add(a1);
        a2 = new JRadioButton("Fixed Deposit Account");
        a2.setBounds(400, 180, 230, 30);
        a2.setFont(new Font("Arial", Font.BOLD, 17));
        a2.setForeground(Color.WHITE);
        a2.setOpaque(false);
        add(a2);
        a3 = new JRadioButton("Current Account");
        a3.setBounds(150, 230, 160, 30);
        a3.setFont(new Font("Arial", Font.BOLD, 17));
        a3.setForeground(Color.WHITE);
        a3.setOpaque(false);
        add(a3);
        a4 = new JRadioButton("Recurring Deposit Account");
        a4.setBounds(400, 230, 240, 30);
        a4.setFont(new Font("Arial", Font.BOLD, 17));
        a4.setForeground(Color.WHITE);
        a4.setOpaque(false);
        add(a4);
        ButtonGroup buttongroup = new ButtonGroup();
        buttongroup.add(a1);
        buttongroup.add(a2);
        buttongroup.add(a3);
        buttongroup.add(a4);

        JLabel cnlabel = new JLabel("Card Number :");
        cnlabel.setForeground(Color.WHITE);
        cnlabel.setBounds(130, 280, 180, 30);
        cnlabel.setFont(new Font("Arial", Font.BOLD, 20));
        add(cnlabel);
        JLabel cnunder = new JLabel("(Your 16-digit Card Number)");
        cnunder.setForeground(Color.WHITE);
        cnunder.setBounds(130, 310, 180, 20);
        cnunder.setFont(new Font("Raleway", Font.BOLD, 13));
        add(cnunder);

        JLabel cno = new JLabel(maskedcard);
        cno.setForeground(Color.WHITE);
        cno.setBounds(380, 280, 230, 30);
        cno.setFont(new Font("Arial", Font.BOLD, 20));
        add(cno);

        JLabel cnounder = new JLabel("(It would appear on ATM Card/Cheque Book and statements)");
        cnounder.setForeground(Color.WHITE);
        cnounder.setBounds(380, 310, 390, 20);
        cnounder.setFont(new Font("Raleway", Font.BOLD, 13));
        add(cnounder);

        JLabel pin = new JLabel("PIN :");
        pin.setForeground(Color.WHITE);
        pin.setBounds(130, 350, 80, 30);
        pin.setFont(new Font("Arial", Font.BOLD, 20));
        add(pin);
        JLabel pinno = new JLabel("XXXX");
        pinno.setForeground(Color.WHITE);
        pinno.setBounds(380, 350, 80, 30);
        pinno.setFont(new Font("Arial", Font.BOLD, 20));
        add(pinno);
        JLabel pinunder = new JLabel("(4-digit password)");
        pinunder.setForeground(Color.WHITE);
        pinunder.setBounds(130,380, 120, 20);
        pinunder.setFont(new Font("Raleway", Font.BOLD, 13));
        add(pinunder);

        JLabel srlabel = new JLabel("Services Required :");
        srlabel.setForeground(Color.WHITE);
        srlabel.setBounds(130, 420, 200, 30);
        srlabel.setFont(new Font("Arial", Font.BOLD, 20));
        add(srlabel);

        c1 = new JCheckBox("ATM Card");
        c1.setBounds(140, 460, 110, 20 );
        c1.setForeground(Color.WHITE);
        c1.setFont(new Font("Arial", Font.BOLD, 17));
        c1.setOpaque(false);
        add(c1);
        c2 = new JCheckBox("Internet Banking");
        c2.setBounds(400, 460, 170, 20 );
        c2.setForeground(Color.WHITE);
        c2.setFont(new Font("Arial", Font.BOLD, 17));
        c2.setOpaque(false);
        add(c2);
        c3 = new JCheckBox("Mobile Banking");
        c3.setBounds(140, 500, 170, 20 );
        c3.setForeground(Color.WHITE);
        c3.setFont(new Font("Arial", Font.BOLD, 17));
        c3.setOpaque(false);
        add(c3);
        c4 = new JCheckBox("E-mail Alerts");
        c4.setBounds(400, 500, 140, 20 );
        c4.setForeground(Color.WHITE);
        c4.setFont(new Font("Arial", Font.BOLD, 17));
        c4.setOpaque(false);
        add(c4);
        c5 = new JCheckBox("Cheque Book");
        c5.setBounds(140, 540, 150, 20 );
        c5.setForeground(Color.WHITE);
        c5.setFont(new Font("Arial", Font.BOLD, 17));
        c5.setOpaque(false);
        add(c5);
        c6 = new JCheckBox("E-Statement");
        c6.setBounds(400, 540, 140, 20 );
        c6.setForeground(Color.WHITE);
        c6.setFont(new Font("Arial", Font.BOLD, 17));
        c6.setOpaque(false);
        add(c6);

        JCheckBox last = new JCheckBox("I here by declares that the above entered details correct to the best of my knowledge.");
        last.setForeground(Color.BLACK);
        last.setBounds(140, 590, 700, 20);
        last.setFont(new Font("Arial", Font.BOLD, 12));
        last.setOpaque(false);
        add(last);

        JLabel fno = new JLabel("Form no :");
        fno.setBounds(640, 50, 120, 30);
        fno.setForeground(Color.WHITE);
        fno.setFont(new Font("Arial", Font.BOLD, 20));
        add(fno);
        JLabel formlabel = new JLabel(formno);
        formlabel.setBounds(730, 50, 60, 30);
        formlabel.setForeground(Color.WHITE);
        formlabel.setFont(new Font("Arial", Font.BOLD, 20));
        add(formlabel);

        s = new JButton("Submit");
        s.setBackground(new Color(0xAAE8AB));
        s.setForeground(Color.black);
        s.setBounds(450, 615, 80, 30);
        s.setFont(new Font("Arial", Font.BOLD, 13));
        s.addActionListener(this);
        add(s);
        c = new JButton("Cancel");
        c.setBackground(new Color(0xAAE8AB));
        c.setForeground(Color.black);
        c.setBounds(250, 615, 80, 30);
        c.setFont(new Font("Arial", Font.BOLD, 13));
        c.addActionListener(this);
        add(c);





        ImageIcon ii1 = new ImageIcon(ClassLoader.getSystemResource("icon/coolbackgrounds-gradient-ocean.png"));
        Image ii2 = ii1.getImage().getScaledInstance(850,700,Image.SCALE_DEFAULT);
        ImageIcon ii3 = new ImageIcon(ii2);
        JLabel iimage = new JLabel(ii3);
        iimage.setBounds(0, 0,850,700);
        add(iimage);



        setLayout(null);
        setSize(850, 700);
        setLocation(360,30);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String actype = null;
        String pno = pin;
        if(a1.isSelected()){
            actype = "Saving Account";
        }
        else if(a2.isSelected()){
            actype = "Fixed Deposit Account";
        }
        else if(a3.isSelected()){
            actype = "Current Account";
        }
        else if(a4.isSelected()){
            actype = "Recurring Deposit Account";
        }
        String demands = "";
        if(c1.isSelected()){
            demands = demands+"ATM Card ";
        }
        if(c2.isSelected()){
            demands = demands+"Internet Banking, ";
        }
        if(c3.isSelected()){
            demands = demands+"Mobile Banking, ";
        }
        if(c4.isSelected()){
            demands = demands+"E-mail Alerts, ";
        }
        if(c5.isSelected()){
            demands = demands+"Cheque Book, ";
        }
        if(c6.isSelected()){
            demands = demands+"E-Statement, ";
        }
        // remove last comma and space if present
        if (!demands.isEmpty()) {
            demands = demands.substring(0, demands.length() - 2);
        }
        try{
            if(e.getSource() == s){
                if(actype.equals("")){
                    JOptionPane.showMessageDialog(null,"Please select the account type");
                }
                else{
                    Connn con3 = new Connn();
                    String r = "insert into signup3 values ('"+formno+"', '"+actype+"', '"+cdno+"', '"+pno+"', '"+demands+"')";
                    String s = "insert into login values ('"+formno+"', '"+cdno+"', '"+pno+"') ";
                    con3.statement.executeUpdate(r);
                    con3.statement.executeUpdate(s);
                    setVisible(false);
                    new Login();
                    JOptionPane.showMessageDialog(null , "Card Number :" +cdno+ "\n PIN Code :" + pno);


                }
            }
            else if(e.getSource() == c){
                try{
                    Connn con3 = new Connn();
                    String deletesignup = "delete from signup where form_no = '"+formno+"'";
                    String deletesignup2 = "delete from signup2 where form_no = '"+formno+"'";
                    String deletesignup3 = "delete from signup3 where form_no = '"+formno+"'";
                    con3.statement.executeUpdate(deletesignup);
                    con3.statement.executeUpdate(deletesignup2);
                    con3.statement.executeUpdate(deletesignup3);
                    setVisible(false);
                }
                catch (Exception ex){
                    ex.printStackTrace();
                }
                System.exit(0);
            }

        }
        catch(Exception E){
            E.printStackTrace();

        }


    }

    public static void main(String[] args) {
        new Signup3("", "");
    }
}
