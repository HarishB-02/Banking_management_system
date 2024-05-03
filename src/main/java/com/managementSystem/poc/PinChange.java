package com.managementSystem.poc;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PinChange extends JFrame implements ActionListener {

    JButton change,back;
    JPasswordField newpin,re_newpin;
    String pin;

    PinChange(String pin){

        this.pin=pin;
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("atm.jpg"));
        Image i2=i1.getImage().getScaledInstance(900,900, Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        setBounds(0,0,900,900);
        add(image);

        JLabel text=new JLabel("Change Your Pin");
        text.setBounds(250,230,500,35);
        text.setFont(new Font("System",Font.BOLD,16));
        text.setForeground(Color.white);
        image.add(text);

        JLabel pintext=new JLabel("New Pin");
        pintext.setBounds(200,320,100,25);
        pintext.setFont(new Font("System",Font.BOLD,16));
        pintext.setForeground(Color.white);
        image.add(pintext);

        newpin= new JPasswordField();
        newpin.setFont(new Font("Raleway",Font.BOLD,25));
        newpin.setBounds(350,320,100,25);
        image.add(newpin);

        JLabel repintext=new JLabel("Re-enter New Pin");
        repintext.setBounds(200,360,150,25);
        repintext.setFont(new Font("System",Font.BOLD,16));
        repintext.setForeground(Color.white);
        image.add(repintext);

        re_newpin= new JPasswordField();
        re_newpin.setFont(new Font("Raleway",Font.BOLD,25));
        re_newpin.setBounds(350,360,100,25);
        image.add(re_newpin);

        change=new JButton("CHANGE");
        change.setBounds(200,425,100,25);
        change.addActionListener(this);
        image.add(change);

        back=new JButton("BACK");
        back.setBounds(350,425,100,25);
        back.addActionListener(this);
        image.add(back);

        setSize(900,900);
        setLocation(300,0);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==change) {
            try {
                String npin = newpin.getText();
                String rpin = re_newpin.getText();

                if(npin.isEmpty()){
                    JOptionPane.showMessageDialog(null,"Please enter the pin");
                }
                if (!npin.isEmpty() && rpin.isEmpty()){
                    JOptionPane.showMessageDialog(null,"Please re-enter the pin");
                }
                if (!npin.equals(rpin)) {
                    JOptionPane.showMessageDialog(null, "PINs doesn't match");
                    return;
                }
                Connect connect=new Connect();
                String query1="update bank_system set pin='"+rpin+"'where pin='"+pin+"'";
                String query2="update signupnexttwo set pin='"+rpin+"'where pin='"+pin+"'";
                String query3="update login set pin='"+rpin+"'where pin='"+pin+"'";

                connect.s.executeUpdate(query1);
                connect.s.executeUpdate(query2);
                connect.s.executeUpdate(query3);

                JOptionPane.showMessageDialog(null,"PIN changed");

                setVisible(false);
                new Transactions(rpin).setVisible(true);
            } catch (Exception e) {
                System.out.println(e);
            }
        }
        if(ae.getSource()==back){
            setVisible(false);
            new Transactions(pin).setVisible(true);
        }
    }
    public static void main(String[] args) {
        new PinChange("").setVisible(true);
    }
}
