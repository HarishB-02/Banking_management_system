package com.managementSystem.poc;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BalanceEnquiry extends JFrame implements ActionListener {
    String pin;
    JButton back;

    BalanceEnquiry(String pin){

        setLayout(null);
        this.pin=pin;

        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("atm.jpg"));
        Image i2=i1.getImage().getScaledInstance(900,900,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);

        back=new JButton("BACK");
        back.setBounds(355,520,150,30);
        back.addActionListener(this);
        image.add(back);
        Connect con=new Connect();
        try {
            ResultSet resultSet = con.s.executeQuery("select  * from bank_system where pin='" + pin + "'");
            int balance = 0;
            while (resultSet.next()) {
                if (resultSet.getString("type").equals("deposit")) {
                    balance += Integer.parseInt(resultSet.getString("amount"));
                } else {
                    balance -= Integer.parseInt(resultSet.getString("amount"));
                }
            }
            JLabel balanceshow=new JLabel("Your Current Balance :"+balance);
            balanceshow.setForeground(Color.white);
            balanceshow.setBounds(170,300,400,30);
            image.add(balanceshow);
        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }

            setSize(900,900);
            setLocation(300,0);
            setVisible(true);
    }

        public void actionPerformed(ActionEvent ae){
        setVisible(false);
        new Transactions(pin).setVisible(true);
    }

    public static void main(String[] args) {
        new BalanceEnquiry("").setVisible(true);
    }
}
