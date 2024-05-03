package com.managementSystem.poc;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Login extends JFrame implements ActionListener {
    JButton login,clear,signup;
    JTextField cardTextField;
    JPasswordField pinTextField;
    Login(){
        setTitle("Automated Teller Machine");

        setLayout(null);

        System.out.println("Sample Text");

        ImageIcon image=new ImageIcon(ClassLoader.getSystemResource("bank_logo.jpg"));
        Image image1=image.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        ImageIcon image2=new ImageIcon(image1);
        JLabel label=new JLabel(image2);
        label.setBounds(70,10,100,100);
        add(label);

        JLabel text=new JLabel("Welcome to ATM");
        text.setFont(new Font("Oswald", Font.BOLD, 38));
        text.setBounds(200,40,400,40);
        add(text);

        JLabel card_no=new JLabel("Card No");
        card_no.setFont(new Font("Raleway", Font.BOLD, 28));
        card_no.setBounds(120,150,250,30);
        add(card_no);

        cardTextField=new JTextField();
        cardTextField.setBounds(300,150,250,30);
        cardTextField.setFont(new Font("Arial", Font.BOLD, 14));
        add(cardTextField);

        JLabel pin=new JLabel("PIN");
        pin.setFont(new Font("Raleway", Font.BOLD, 28));
        pin.setBounds(120,220,250,30);
        add(pin);

        pinTextField= new JPasswordField();
        pinTextField.setBounds(300,220,250,30);
        pinTextField.setFont(new Font("Arial", Font.BOLD, 14));
        add(pinTextField);

        login=new JButton("Login");
        login.setBounds(300,300,100,30);
        login.setBackground(Color.black);
        login.setForeground(Color.white);
        login.addActionListener(this);
        add(login);

        clear=new JButton("Clear");
        clear.setBounds(450,300,100,30);
        clear.setBackground(Color.black);
        clear.setForeground(Color.white);
        clear.addActionListener(this);
        add(clear);

        signup=new JButton("Sign Up");
        signup.setBounds(300,350,250,30);
        signup.setBackground(Color.black);
        signup.setForeground(Color.white);
        signup.addActionListener(this);
        add(signup);

        getContentPane().setBackground(Color.WHITE);

        setSize(800,480);
        setVisible(true);
        setLocation(200,200);
    }
    public void actionPerformed(ActionEvent e){
        if(e.getSource()==login){
            Connect con=new Connect();
            String cardno=cardTextField.getText();
            String pinno=pinTextField.getText();
            String query="select * from login where cardno='"+cardno+"' and pin='"+pinno+"'";
            try {
                ResultSet result =con.s.executeQuery(query);
                if(result.next()){
                    setVisible(false);
                    new Transactions(pinno).setVisible(true);
                }
                else{
                    JOptionPane.showMessageDialog(null,"Incorrect Card Number or Pin");
                }
            }
            catch (Exception ex){

            }
        }
        else if(e.getSource()==clear){
            cardTextField.setText("Enter Card No");
            pinTextField.setText("Enter PIN");
        }
        else if(e.getSource()==signup){
            setVisible(false);
            new SignUp().setVisible(true);
        }
    }
    public static void main(String[] args) {
         new Login();
    }
}
