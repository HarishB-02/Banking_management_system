package com.managementSystem.poc;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Date;

public class FastCash extends JFrame implements ActionListener {

    JButton deposit,withdrawl,mini,fastcash,back,pin_change,balance;
    String pin;

    FastCash(String pin){

        pin=this.pin;
        setLayout(null);

        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("atm.jpg"));
        Image i2=i1.getImage().getScaledInstance(900,900, Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel l1=new JLabel(i3);
        l1.setBounds(0,0,900,900);
        add(l1);

        JLabel text=new JLabel("Select Withdrawl Amount");
        text.setBounds(215,300,700,35);
        text.setForeground(Color.white);
        text.setFont(new Font("System", Font.BOLD, 16));
        l1.add(text);

        deposit=new JButton("Rs.100");
        deposit.setBounds(180,415,150,30);
        deposit.addActionListener(this);
        add(deposit);

        withdrawl=new JButton("Rs.500");
        withdrawl.setBounds(180,450,150,30);
        withdrawl.addActionListener(this);
        add(withdrawl);

        fastcash=new JButton("Rs.2000");
        fastcash.setBounds(180,485,150,30);
        fastcash.addActionListener(this);
        add(fastcash);

        mini=new JButton("Rs.200");
        mini.setBounds(350,415,150,30);
        mini.addActionListener(this);
        add(mini);

        pin_change=new JButton("Rs.1000");
        pin_change.setBounds(350,450,150,30);
        pin_change.addActionListener(this);
        add(pin_change);

        balance=new JButton("Rs.5000");
        balance.setBounds(350,485,150,30);
        balance.addActionListener(this);
        add(balance);

        back=new JButton("BACK");
        back.setBounds(265,520,150,30);
        back.addActionListener(this);
        add(back);

        setSize(900,900);
        setLocation(300,0);
        setUndecorated(true);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==back){
            setVisible(false);
            new Transactions(pin).setVisible(true);
        }
        else{
            String amount=((JButton) ae.getSource()).getText().substring(3);
            Connect con=new Connect();
            try {
                ResultSet resultSet=con.s.executeQuery("select  * from bank_system where pin='"+ pin+"'");
                int balance=0;
                while (resultSet.next()){
                    if (resultSet.getString("type").equals("deposit")){
                        balance+=Integer.parseInt(resultSet.getString("amount"));
                    }
                    else{
                        balance-=Integer.parseInt(resultSet.getString("amount"));
                    }
                }
                if(ae.getSource()!=back &&  balance<Integer.parseInt(amount)){
                    JOptionPane.showMessageDialog(null,"Insufficient Balance");
                    return;
                }
                Date date=new Date();
                String query="insert into bank_system values('"+pin+"','"+date+"','withdraw','"+amount+"')";
                con.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null,"Rs."+amount+" debited successfully");
                setVisible(false);
                new Transactions(pin).setVisible(true);
            }
            catch (Exception e){
                System.out.println(e);
            }
        }
    }

    public static void main(String[] args) {
        new FastCash("");
    }
}

