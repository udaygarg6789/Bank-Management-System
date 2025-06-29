package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Signup2 extends JFrame implements ActionListener {
    String formno;
    String pinno;
    JComboBox combobox, combo2,combo3, educombo, occucombo;
    JTextField panno, addharno;
    JRadioButton m1, m2, e1, e2;
    JButton nextbutton;
    Signup2(String first, String pincode){
        super("APPLICATION FORM PAGE-2");

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/bank.png"));
        Image i2 = i1.getImage().getScaledInstance(100,100,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(25, 10,100,100);
        add(image);

        this.formno = first;
        this.pinno = pincode;
        JLabel l1 = new JLabel("Page 2 :-");
        l1.setBounds(150, 30, 300, 50);
        l1.setFont(new Font("Arial", Font.BOLD, 30));
        add(l1);

        JLabel l2 = new JLabel("Additional Details :");
        l2.setBounds(150, 80, 300, 30);
        l2.setFont(new Font("Raleway", Font.BOLD, 25));
        add(l2);

        JLabel l3 = new JLabel("Religion :");
        l3.setBounds(120, 140, 200, 30);
        l3.setFont(new Font("Arial", Font.BOLD, 20));
        add(l3);
        String religion[] = {"Hindu", "Muslim", "sikh", "Christian", "Others"};
        combobox = new JComboBox(religion);
        combobox.setBounds(320, 140, 300, 30);
        combobox.setFont(new Font("Arial", Font.BOLD, 20));
        combobox.setBackground(new Color(252, 208, 76));
        add(combobox);

        JLabel l4 = new JLabel("Category :");
        l4.setBounds(120, 190, 150, 30);
        l4.setFont(new Font("Arial", Font.BOLD, 20));
        add(l4);
        String category[] = {"General", "OBC", "SC", "ST", "Other"};
        combo2 = new JComboBox(category);
        combo2.setBounds(320, 190, 300, 30);
        combo2.setFont(new Font("Arial", Font.BOLD, 20));
        add(combo2);

        JLabel l5 = new JLabel("Income :");
        l5.setBounds(120, 230, 100, 30);
        l5.setFont(new Font("Arial", Font.BOLD, 20));
        add(l5);
        String income[] = {"Null", "<1,50,000", "<2,50,000", "5,00,000", "Below 10,00,000", "Above 10,00,000"};
        combo3 = new JComboBox(income);
        combo3.setBounds(320, 230, 300, 30);
        combo3.setFont(new Font("Arial", Font.BOLD, 20));
        add(combo3);

        JLabel l6 = new JLabel("Education :");
        l6.setBounds(120, 270, 300, 30);
        l6.setFont(new Font("Arial", Font.BOLD, 20));
        add(l6);
        String education[] = {"Non-Graduate", "Graduate", "Post-Graduate", "Doctrate", "Others"};
        educombo = new JComboBox(education);
        educombo.setBounds(320, 270, 300, 30);
        educombo.setFont(new Font("Arial", Font.BOLD, 20));
        add(educombo);

        JLabel occulabel = new JLabel("Occupation");
        occulabel.setBounds(120, 310, 250, 30);
        occulabel.setFont(new Font("Arial", Font.BOLD, 20));
        add(occulabel);
        String occupation[] = {"Working Employee",  "Bussiness", "Self-Employed", "Student", "Retiered", "Others"};
        occucombo = new JComboBox(occupation);
        occucombo.setBounds(320, 310, 300, 30);
        occucombo.setFont(new Font("Arial", Font.BOLD, 20));
        add(occucombo);
        JLabel panlabel = new JLabel("PAN Number :");
        panlabel.setBounds(120, 350, 250, 30);
        panlabel.setFont(new Font("Arial", Font.BOLD, 20));
        add(panlabel);

        panno = new JTextField();
        panno.setBounds(320, 350, 300, 30);
        panno.setFont(new Font("Raleway", Font.BOLD, 20));
        add(panno);

        JLabel adharlabel = new JLabel("Aadhar Number :");
        adharlabel.setBounds(120, 400, 300, 30);
        adharlabel.setFont(new Font("Arial", Font.BOLD, 20));
        add(adharlabel);
        addharno = new JTextField();
        addharno.setBounds(320, 400, 300, 30);
        addharno.setFont(new Font("Raleway", Font.BOLD, 20));
        add(addharno);

        JLabel sec = new JLabel("Senior Citizen :");
        sec.setBounds(120, 440, 300, 30);
        sec.setFont(new Font("Arial", Font.BOLD, 20));;
        add(sec);
        m1 = new JRadioButton("Yes");
        m1.setBounds(350, 440, 70, 30);
        m1.setBackground(new Color(247, 221, 126));
        m1.setFont(new Font("Arial", Font.BOLD, 20));
        add(m1);
        m2 = new JRadioButton("No");
        m2.setBounds(480, 440, 70, 30);
        m2.setBackground(new Color(247, 221, 126));
        m2.setFont(new Font("Arial", Font.BOLD, 20));
        add(m2);
        ButtonGroup firstgroup = new ButtonGroup();
        firstgroup.add(m1);
        firstgroup.add(m2);

        JLabel exa = new JLabel("Existing Account :");
        exa.setBounds(120, 480, 300, 30);
        exa.setFont(new Font("Arial", Font.BOLD, 20));
        add(exa);
        e1 = new JRadioButton("Yes");
        e1.setBounds(350, 480, 70, 30);
        e1.setBackground(new Color(247, 221, 126));
        e1.setFont(new Font("Arial", Font.BOLD, 20));
        add(e1);
        e2 = new JRadioButton("No");
        e2.setBounds(480, 480, 60, 30);
        e2.setBackground(new Color(247, 221, 126));
        e2.setFont(new Font("Arial", Font.BOLD, 20));
        add(e2);
        ButtonGroup secondgroup = new ButtonGroup();
        secondgroup.add(e1);
        secondgroup.add(e2);

        JLabel forment = new JLabel("Form no :");
        forment.setBounds(670, 10, 100,30);
        forment.setFont(new Font("Arial", Font.BOLD, 20));
        add(forment);
        JLabel formlabel = new JLabel(formno);
        formlabel.setBounds(770, 10, 60, 30);
        formlabel.setFont(new Font("Arial", Font.BOLD, 20));
        add(formlabel);

        nextbutton = new JButton("Next");
        nextbutton.setBounds(540, 550, 80, 25);
        nextbutton.setForeground(new Color(0x000000));
        nextbutton.setBackground(new Color(0xFFFFFF));
        nextbutton.setFont(new Font("Raleway", Font.BOLD, 17));
        nextbutton.addActionListener(this);
        add(nextbutton);



        setLayout(null);
        setSize(850, 700);
        getContentPane().setBackground(new Color(247, 221, 126));
        setLocation(360,30);
        setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String rel = (String) combobox.getSelectedItem();
        String cate = (String) combo2.getSelectedItem();
        String inc = (String) combo3.getSelectedItem();
        String edu = (String) educombo.getSelectedItem();
        String occu = (String) occucombo.getSelectedItem();
        String pan = panno.getText();
        String aad = addharno.getText();
        String seniorcity = null;
        if(m1.isSelected()){
            seniorcity = "Yes";
        }
        else if(m2.isSelected()){
            seniorcity = "No";
        }
        String existingac = null;
        if(e1.isSelected()){
            existingac = "Yes";

        }
        else if(e2.isSelected()){
            existingac = "No";
        }
        try{
            if(panno.getText().equals("") ){
                JOptionPane.showMessageDialog(null, "Please enter your PAN");
            }
            else if(addharno.getText().equals("")){
                JOptionPane.showMessageDialog(null, "Please enter your Aadhar Number");
            }
            else{
                Connn con2 = new Connn();
                String p = "insert into signup2 values ('"+formno+"', '"+rel+"', '"+cate+"', '"+inc+"', '"+edu+"', '"+occu+"', '"+pan+"', '"+aad+"', '"+seniorcity+"', '"+existingac+"')";
                con2.statement.executeUpdate(p);
                new Signup3(formno, pinno);
                setVisible(false);

            }
        } catch (Exception E){
            E.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new Signup2("", "");
    }
}
