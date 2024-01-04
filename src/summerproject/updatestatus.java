/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package summerproject;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;

/**
 *
 * @author SUJAL
 */
public class updatestatus  extends JFrame implements ActionListener
{
    Choice ccustomer;
    JTextField troomnumber,tname,tamountpaid,tpending;
    JButton back,check,update;
    JLabel tcheckin;
    updatestatus()
    {
        getContentPane().setBackground(Color.WHITE);
        
        JLabel head = new JLabel("Update Status");
        head.setBackground(Color.white);
        head.setForeground(Color.blue);
        head.setFont(new Font("Stencil",Font.BOLD,30));
        head.setBounds(100,20,350,30);
        add(head);
        
        JLabel Customer = new JLabel("Customer ID");
        Customer.setBounds(20,70,100,20);
        add(Customer);
        ccustomer = new Choice();
        ccustomer.setBounds(130,70,180,20);
            
        try
        {
            C con = new C();
            String sql = "SELECT * FROM customerdatabase";
            ResultSet rs = con.state.executeQuery(sql);
            while(rs.next()) 
            {
                ccustomer.add(rs.getString("cid"));
            }
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        add(ccustomer);
        
        JLabel RoomNumber = new JLabel("Room Number");
        RoomNumber.setBounds(20,110,100,20);
        add(RoomNumber);
        troomnumber = new JTextField();
        troomnumber.setBounds(130,110,180,20);
        add(troomnumber);
        
        JLabel name = new JLabel("Name");
        name.setBounds(20,150,100,20);
        add(name);
        tname = new JTextField();
        tname.setBounds(130,150,180,20);
        add(tname);
        
        JLabel checkin = new JLabel("Check-in-Time");
        checkin.setBounds(20,190,200,20);
        add(checkin);
        tcheckin = new JLabel();
        tcheckin.setBounds(130,190,180,20);
        add(tcheckin);
        
        
        JLabel amountpaid = new JLabel("Amount Paid");
        amountpaid.setBounds(20,230,200,20);
        add(amountpaid);
        tamountpaid = new JTextField();
        tamountpaid.setBounds(130,230,180,20);
        add(tamountpaid);
        
        JLabel pending = new JLabel("Pending Amount");
        pending.setBounds(20,270,200,20);
        add(pending);
        tpending = new JTextField();
        tpending.setBounds(130,270,180,20);
        add(tpending);
        
        check = new JButton("Check");
        check.setBounds(70,310,200,25);        
        check.setBackground(Color.YELLOW);
        check.setForeground(Color.BLACK);
        check.setCursor(new Cursor(Cursor.HAND_CURSOR));
        add(check);
        check.addActionListener(this);
        
        back = new JButton("Back");
        back.setBounds(20,360,120,25);        
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setCursor(new Cursor(Cursor.HAND_CURSOR));
        add(back);
        back.addActionListener(this);
        
        update = new JButton("Update");
        update.setBounds(200,360,120,25);        
        update.setBackground(Color.BLACK);
        update.setForeground(Color.WHITE);
        update.setCursor(new Cursor(Cursor.HAND_CURSOR));
        add(update);
        update.addActionListener(this);
        
        ImageIcon i = new ImageIcon(ClassLoader.getSystemResource("icons/sixth.jpg"));
        Image i1 = i.getImage().getScaledInstance(450,300,Image.SCALE_DEFAULT);
        ImageIcon i2 = new ImageIcon(i1);
        JLabel l = new JLabel(i2);
        l.setBounds(330,50,450,300);
        add(l);
        
        setLayout(null);
        setSize(800,450);
        setLocationRelativeTo(null);
        setVisible(true);
        setResizable(false);
        setTitle("Hotel Attic Empire");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public static void main(String[] args) 
    {
        new updatestatus();
    }

    @Override
    public void actionPerformed(ActionEvent ae) 
    {
        if(ae.getSource()==back)
        {
            setVisible(false);
            new reception();
        }
        else if(ae.getSource()==check)
        {
            String id = ccustomer.getSelectedItem();
            String sql = "select * from customerdatabase where cid = '"+id+"'";
            try
            {
                C c = new C();
                
                ResultSet rs = c.state.executeQuery(sql);
                while(rs.next())
                {
                    troomnumber.setText(rs.getString("room"));
                    tname.setText(rs.getString("name"));
                    tcheckin.setText(rs.getString("time"));
                    tamountpaid.setText(rs.getString("deposit"));
                }
                String sql2 = "select * from rooms where roomnumber = '"+troomnumber.getText()+"'";
                ResultSet rs2 = c.state.executeQuery(sql2);
                while(rs2.next())
                {
                    String p = rs2.getString("price");
                    int remaining = Integer.parseInt(p)-Integer.parseInt(tamountpaid.getText());
                    tpending.setText(remaining +"");
                }
            }
            catch(Exception e)
            {
                System.out.println(e);
            }
        }
        else if(ae.getSource()==update)
        {
            String cno = ccustomer.getSelectedItem();
            String rno = troomnumber.getText();
            String cn = tname.getText();
            String pa = tamountpaid.getText();
            String sql = "update customerdatabase set room = '"+ rno +"', deposit = '"+ pa +"' where cid ='"+ cno +"'";
            String sql1 = "update rooms set availability = 'occupied' where roomnumber = '"+rno+"'";
            try
            {
                C c = new C();
                c.state.executeUpdate(sql);
                c.state.executeUpdate(sql1);
                JOptionPane.showMessageDialog(null,"Customer status updated successfully.");
                setVisible(false);
                new reception();
            }
            catch(Exception e)
            {
                System.out.println(e);
            }
        }
    }
}
