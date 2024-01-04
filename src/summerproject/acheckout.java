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
public class acheckout  extends JFrame implements ActionListener
{
    Choice ccustomer;
    
    JButton back,check,checkout;
    JLabel tcheckin,troomnumber,tname,tamountpaid,tpending;
    acheckout()
    {
        getContentPane().setBackground(Color.WHITE);
        
        JLabel head = new JLabel("CheckOut");
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
        troomnumber = new JLabel();
        troomnumber.setBounds(130,110,180,20);
        add(troomnumber);
        
        JLabel name = new JLabel("Name");
        name.setBounds(20,160,100,20);
        add(name);
        tname = new JLabel();
        tname.setBounds(130,160,180,20);
        add(tname);
        
        JLabel checkin = new JLabel("Check-in-Time");
        checkin.setBounds(20,210,200,20);
        add(checkin);
        tcheckin = new JLabel();
        tcheckin.setBounds(130,210,180,20);
        add(tcheckin);
        
        
        JLabel amountpaid = new JLabel("Amount Paid");
        amountpaid.setBounds(20,260,200,20);
        add(amountpaid);
        tamountpaid = new JLabel();
        tamountpaid.setBounds(130,260,180,20);
        add(tamountpaid);
        
        JLabel pending = new JLabel("Pending Amount");
        pending.setBounds(20,310,200,20);
        add(pending);
        tpending = new JLabel();
        tpending.setBounds(130,310,180,20);
        add(tpending);
        
        back = new JButton("Back");
        back.setBounds(20,370,100,25);        
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setCursor(new Cursor(Cursor.HAND_CURSOR));
        add(back);
        back.addActionListener(this);
        
        check = new JButton("Check");
        check.setBounds(60,333,200,25);        
        check.setBackground(Color.YELLOW);
        check.setForeground(Color.BLACK);
        check.setCursor(new Cursor(Cursor.HAND_CURSOR));
        add(check);
        check.addActionListener(this);
        
        checkout = new JButton("Checkout");
        checkout.setBounds(220,370,100,25);        
        checkout.setBackground(Color.BLACK);
        checkout.setForeground(Color.WHITE);
        checkout.setCursor(new Cursor(Cursor.HAND_CURSOR));
        add(checkout);
        checkout.addActionListener(this);
        
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
        new acheckout();
    }

    @Override
    public void actionPerformed(ActionEvent ae) 
    {
        if(ae.getSource()==back)
        {
            setVisible(false);
            new admin();
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
                    tcheckin.setText(rs.getString("date"));
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
                c.close();
            }
            catch(Exception e)
            {
                System.out.println(e);
            }
        }
        else if(ae.getSource()==checkout)
        {
            
            String cno = ccustomer.getSelectedItem();
            String rno = troomnumber.getText();            
            String query1= "delete from customerdatabase where cid='"+ cno +"'";
            String query2 = "update rooms set availability='available' , cleaning_status='dirty' where roomnumber='"+ rno +"'";
            
            try
            {
                C c1 = new C();
                c1.state.executeUpdate(query1);
                c1.state.executeUpdate(query2);
                JOptionPane.showMessageDialog(null,"Checkout Successfull!!!");
                setVisible(false);
                new admin();
            }
            catch(Exception e1)
            {
                System.out.println(e1);
            }
        }
    }
}
