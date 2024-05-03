package com.managementSystem.poc;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import com.toedter.calendar.JDateChooser;

public class SignUp extends JFrame implements ActionListener {
    Long randomNum;
    JTextField name1,fname1,email1,address1,city1,state1,pincode1;
    JDateChooser dateChooser;
    JRadioButton mStatus1,mStatus2,mStatus3,gender1,gender2;

    public SignUp() {

        setLayout(null);

        Random random = new Random();
        randomNum=(random.nextLong()%9000L)+1000L;

        JLabel formNo=new JLabel("Application Form No "+randomNum);
        formNo.setFont(new Font("Raleway",Font.BOLD,38));
        formNo.setBounds(140,20,600,40);
        add(formNo);

        JLabel personDetails=new JLabel("Person Details");
        personDetails.setFont(new Font("Raleway",Font.BOLD,22));
        personDetails.setBounds(290,80,400,30);
        add(personDetails);

        JLabel name=new JLabel("Name :");
        name.setFont(new Font("Raleway",Font.BOLD,22));
        name.setBounds(100,140,100,30);
        add(name);

        name1=new JTextField();
        name1.setFont(new Font("Raleway",Font.BOLD,22));
        name1.setBounds(450,140,200,30);
        add(name1);

        JLabel fname=new JLabel("Father's Name :");
        fname.setFont(new Font("Raleway",Font.BOLD,22));
        fname.setBounds(100,190,200,30);
        add(fname);

        fname1=new JTextField();
        fname1.setFont(new Font("Raleway",Font.BOLD,22));
        fname1.setBounds(450,190,200,30);
        add(fname1);

        JLabel dob=new JLabel("Date of Birth :");
        dob.setFont(new Font("Raleway",Font.BOLD,22));
        dob.setBounds(100,240,250,30);
        add(dob);

        dateChooser=new JDateChooser();
        dateChooser.setBounds(450,240,200,30);
        dateChooser.setForeground(Color.black);
        add(dateChooser);

        JLabel gender=new JLabel("Gender :");
        gender.setFont(new Font("Raleway",Font.BOLD,22));
        gender.setBounds(100,290,250,30);
        add(gender);

        gender1=new JRadioButton("Male");
        gender1.setBounds(450,290,100,30);
        gender1.setBackground(Color.white);
        add(gender1);

        gender2=new JRadioButton("Female");
        gender2.setBounds(550,290,100,30);
        gender2.setBackground(Color.white);
        add(gender2);

        ButtonGroup group1=new ButtonGroup();
        group1.add(gender1);
        group1.add(gender2);

        JLabel email=new JLabel("Email Id :");
        email.setFont(new Font("Raleway",Font.BOLD,22));
        email.setBounds(100,340,250,30);
        add(email);

        email1=new JTextField();
        email1.setFont(new Font("Raleway",Font.BOLD,22));
        email1.setBounds(450,340,200,30);
        add(email1);

        JLabel mStatus=new JLabel("Marital Status :");
        mStatus.setFont(new Font("Raleway",Font.BOLD,22));
        mStatus.setBounds(100,390,250,30);
        add(mStatus);

        mStatus1=new JRadioButton("Married");
        mStatus1.setBounds(450,390,70,30);
        mStatus1.setBackground(Color.white);
        add(mStatus1);

        mStatus2=new JRadioButton("Unmarried");
        mStatus2.setBounds(520,390,90,30);
        mStatus2.setBackground(Color.white);
        add(mStatus2);

        mStatus3=new JRadioButton("Others");
        mStatus3.setBounds(610,390,70,30);
        mStatus3.setBackground(Color.white);
        add(mStatus3);

        ButtonGroup group2=new ButtonGroup();
        group2.add(mStatus1);
        group2.add(mStatus2);
        group2.add(mStatus3);

        JLabel address=new JLabel("Address :");
        address.setFont(new Font("Raleway",Font.BOLD,22));
        address.setBounds(100,440,250,30);
        add(address);

        address1=new JTextField();
        address1.setFont(new Font("Raleway",Font.BOLD,22));
        address1.setBounds(450,440,200,30);
        add(address1);

        JLabel city=new JLabel("City :");
        city.setFont(new Font("Raleway",Font.BOLD,22));
        city.setBounds(100,490,250,30);
        add(city);

        city1=new JTextField();
        city1.setFont(new Font("Raleway",Font.BOLD,22));
        city1.setBounds(450,490,200,30);
        add(city1);

        JLabel state=new JLabel("State :");
        state.setFont(new Font("Raleway",Font.BOLD,22));
        state.setBounds(100,540,250,30);
        add(state);

        state1=new JTextField();
        state1.setFont(new Font("Raleway",Font.BOLD,22));
        state1.setBounds(450,540,200,30);
        add(state1);

        JLabel pincode=new JLabel("Pincode :");
        pincode.setFont(new Font("Raleway",Font.BOLD,22));
        pincode.setBounds(100,590,250,30);
        add(pincode);

        pincode1=new JTextField();
        pincode1.setFont(new Font("Raleway",Font.BOLD,22));
        pincode1.setBounds(450,590,200,30);
        add(pincode1);

        JButton next = new JButton("Next");
        next.setBackground(Color.black);
        next.setForeground(Color.white);
        next.setBounds(350,660,100,30);
        next.addActionListener(this);
        add(next);

        getContentPane().setBackground(Color.white);

        setSize(850, 800);
        setLocation(350,10);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e){
        String formNo=""+randomNum;
        String name=name1.getText();
        String fname=fname1.getText();
        String email=email1.getText();
        String dob=((JTextField)dateChooser.getDateEditor().getUiComponent()).getText();
        String gender=null;
        if (gender1.isSelected()){
            gender="Male";
        }
        else if (gender2.isSelected()){
            gender="Female";
        }
        String mStatus=null;
        if (mStatus1.isSelected()){
            mStatus="Married";
        }
        else if (mStatus2.isSelected()){
            mStatus="Unmarried";
        }
        else if (mStatus3.isSelected()){
            mStatus="Others";
        }
        String address=address1.getText();
        String city=city1.getText();
        String state=state1.getText();
        String pincode=pincode1.getText();
        try {
            if (name.equals("")){
                JOptionPane.showMessageDialog(null,"Please enter your Name!");
            }
            else{
                Connect c=new Connect();
                String query=
                        "insert into signup values('"+
                                formNo+"','"+
                                name+"','"+
                                fname+"','"+
                                dob+"','"+
                                gender+"','"+
                                email+"','"+
                                address+"','"+
                                city+"','"+
                                pincode+"','"+
                                state+"')";
                c.s.executeUpdate(query);
                setVisible(false);
                new SignUpNext(formNo).setVisible(true);
            }
        }
        catch (Exception ex){
            System.out.println(ex);
        }
    }
    public static void main(String[] args) {
        new SignUp();
    }
}
