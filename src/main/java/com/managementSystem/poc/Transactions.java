package com.managementSystem.poc;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Transactions extends JFrame implements ActionListener {

    JButton deposit,withdrawl,mini,fastcash,exit,pin_change,balance;
    String pin;

    Transactions(String pin){

        this.pin=pin;
        setLayout(null);

        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("atm.jpg"));
        Image i2=i1.getImage().getScaledInstance(900,900, Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel l1=new JLabel(i3);
        l1.setBounds(0,0,900,900);
        add(l1);

        JLabel text=new JLabel("Please Select Your Transaction");
        text.setBounds(215,300,700,35);
        text.setForeground(Color.white);
        text.setFont(new Font("System", Font.BOLD, 16));
        l1.add(text);

        deposit=new JButton("Deposit");
        deposit.setBounds(180,415,150,30);
        deposit.addActionListener(this);
        add(deposit);

        withdrawl=new JButton("Withdrawl");
        withdrawl.setBounds(180,450,150,30);
        withdrawl.addActionListener(this);
        add(withdrawl);

        fastcash=new JButton("FastCash");
        fastcash.setBounds(180,485,150,30);
        fastcash.addActionListener(this);
        add(fastcash);

        mini=new JButton("Mini statement");
        mini.setBounds(350,415,150,30);
        mini.addActionListener(this);
        add(mini);

        pin_change=new JButton("Pin Change");
        pin_change.setBounds(350,450,150,30);
        pin_change.addActionListener(this);
        add(pin_change);

        balance=new JButton("Balance");
        balance.setBounds(350,485,150,30);
        balance.addActionListener(this);
        add(balance);

        exit=new JButton("Exit");
        exit.setBounds(265,520,150,30);
        exit.addActionListener(this);
        add(exit);

        setSize(900,900);
        setLocation(300,0);
        setUndecorated(true);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e){
        if(e.getSource()==deposit){
            setVisible(false);
            new Deposit(pin).setVisible(true);
        }
        else if(e.getSource()==withdrawl){
            setVisible(false);
            new Withdrawl(pin).setVisible(true);
        }
        else if(e.getSource()==fastcash){
            setVisible(false);
            new FastCash(pin).setVisible(true);
        }
        else if(e.getSource()==mini){
            new MiniStatement(pin).setVisible(true);
        }
        else if(e.getSource()==pin_change){
            setVisible(false);
            new PinChange(pin).setVisible(true);
        }
        else if(e.getSource()==balance){
            setVisible(false);
            new BalanceEnquiry(pin).setVisible(true);
        }
        else if(e.getSource()==exit){
            System.exit(0);
        }
    }

    public static void main(String[] args) {
        new Transactions("");
    }
}
