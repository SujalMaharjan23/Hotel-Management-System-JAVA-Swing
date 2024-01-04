/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package summerproject;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import net.proteanit.sql.*;
import javax.swing.JTable;
public class acustomerinfo extends JFrame implements ActionListener
{
    JTable tb;
    JButton back;
    acustomerinfo()
    {
        getContentPane().setBackground(Color.WHITE);
          
        JLabel heading = new JLabel("Customers");
        heading.setBounds(400,30,500,50);
        heading.setFont(new Font("Stencil",Font.BOLD,50));
        heading.setForeground(Color.BLUE);
        add(heading);
        
        JLabel CustomerId = new JLabel("Customer Id");
        CustomerId.setBounds(20,70,500,50);
        add(CustomerId);
        
        JLabel Name = new JLabel("Name");
        Name.setBounds(140,70,500,50);
        add(Name);
        
        JLabel Contact = new JLabel("Contact");
        Contact.setBounds(250,70,500,50);
        add(Contact);
        
        JLabel Gender = new JLabel("Gender");
        Gender.setBounds(350,70,500,50);
        add(Gender);
        
        JLabel ID = new JLabel("ID");
        ID.setBounds(470,70,500,50);
        add(ID);
        
        JLabel Country = new JLabel("Country");
        Country.setBounds(580,70,500,50);
        add(Country);
        
        JLabel Email = new JLabel("Email");
        Email.setBounds(690,70,500,50);
        add(Email);
        
        JLabel Roomno = new JLabel("Roomno");
        Roomno.setBounds(800,70,500,50);
        add(Roomno);
        
        JLabel Deposit = new JLabel("Deposit");
        Deposit.setBounds(910,70,500,50);
        add(Deposit);
        
        JLabel CheckInTime = new JLabel("CheckInTime");
        CheckInTime.setBounds(1025,70,500,50);
        add(CheckInTime);
        
        tb = new JTable();
        tb.setBounds(20,120,1100,400);
        add(tb);
        
        try
        {
            C c = new C();
            String sql="SELECT * FROM customer";
            ResultSet rs = c.state.executeQuery(sql);
            tb.setModel(DbUtils.resultSetToTableModel(rs));
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }

        
        back = new JButton("Back");
        back.setBounds(500,525,100,20);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        add(back);
        back.addActionListener(this);
       
        
        setLayout(null);
        setBounds(150,50,1200,600);
        setVisible(true);
        setTitle("Hotel Attic Empire");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    public static void main(String[] args) 
    {
        new acustomerinfo();
    }

    @Override
    public void actionPerformed(ActionEvent ae) 
    {
        if(ae.getSource()==back)
        {
            setVisible(false);
            new admin();
        }
    }
}
