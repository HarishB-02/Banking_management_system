package com.managementSystem.poc;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

public class Withdrawl extends JFrame implements ActionListener {

    JLabel text;
    JTextField amount;
    JButton withdraw,back;
    String pin;

    Withdrawl(String pin){

        this.pin=pin;
        setLayout(null);

        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("atm.jpg"));
        Image i2=i1.getImage().getScaledInstance(900,900,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);

        text=new JLabel("Enter the amount to withdraw ");
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System",Font.BOLD,16));
        text.setBounds(170,300,400,20);
        image.add(text);

        amount=new JTextField();
        amount.setBounds(170,350,320,20);
        amount.setFont(new Font("Raleway",Font.BOLD,22));
        image.add(amount);

        withdraw=new JButton("Withdraw");
        withdraw.setBounds(355,485,150,30);
        withdraw.addActionListener(this);
        image.add(withdraw);

        back=new JButton("Back");
        back.setBounds(355,520,150,30);
        back.addActionListener(this);
        image.add(back);

        setSize(900,900);
        setLocation(300,0);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent a){
        if (a.getSource()==withdraw){
            String number=amount.getText();
            Date date=new Date();
            if(number.equals("")){
                JOptionPane.showMessageDialog(null,"Please enter the amount");
            }
            else{
                try {
                    Connect con = new Connect();
                    String query = "insert into bank_system values('" + pin + "','" + date + "','withdraw','" + number+"')";
                    con.s.executeUpdate(query);
                    JOptionPane.showMessageDialog(null, "Rs" + number + " withdrawn successfully");
                    setVisible(false);
                    new Transactions(pin).setVisible(true);
                }
                catch (Exception e){
                    System.out.println(e);
                }
            }
        }
        else if (a.getSource()==back) {
            setVisible(false);
            new Transactions(pin).setVisible(true);
        }
    }

    public static void main(String[] args){
        new Withdrawl("").setVisible(true);
    }
}
