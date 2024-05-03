package com.managementSystem.poc;

import javax.swing.*;
import java.awt.*;
import java.sql.ResultSet;

public class MiniStatement extends JFrame {
    String pin;
    MiniStatement(String pin){

        this.pin=pin;
        setTitle("Mini Statement");

        setLayout(null);

        JLabel text=new JLabel();
        text.setBounds(20,60,400,200);
        add(text);

        JLabel bank=new JLabel("Stae Bank of India");
        bank.setBounds(150,20,150,20);
        add(bank);

        JLabel card=new JLabel();
        card.setBounds(20,80,300,20);
        add(card);

        JLabel balance=new JLabel();
        balance.setBounds(20,40,400,20);
        add(balance);

        try {
            Connect connect=new Connect();
            ResultSet resultSet=connect.s.executeQuery("select * from login where pin='"+pin+"'");
            while(resultSet.next()){
                card.setText("Card Number : XXXX XXXX XXXX "+resultSet.getString("cardno").substring(12));
            }
        }
        catch (Exception e){
            System.out.println(e);
        }

        try {
            Connect connect=new Connect();
            ResultSet resultSet=connect.s.executeQuery("select * from bank_system where pin='"+pin+"'");
            int bal=0;
            while (resultSet.next()){
                text.setText(text.getText()+"<html>"+
                        resultSet.getString("date")+"  "+
                        resultSet.getString("type")+"  "+
                        resultSet.getString("amount")+"<br><html>");
                if (resultSet.getString("type").equals("deposit")) {
                    bal += Integer.parseInt(resultSet.getString("amount"));
                } else {
                    bal -= Integer.parseInt(resultSet.getString("amount"));
                }
            }
            balance.setText("Your current balance : "+bal);
        }
        catch (Exception e){
            System.out.println(e);
        }

        setSize(400,600);
        setLocation(20,20);
        getContentPane().setBackground(Color.white);
        setVisible(true);
    }
    public static void main(String[] args) {
        new MiniStatement("").setVisible(true);
    }
}
