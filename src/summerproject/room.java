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
public class room extends JFrame implements ActionListener
{
    JTable tb;
    JButton back;
    room()
    {
        getContentPane().setBackground(Color.WHITE);
        
        
        JLabel heading = new JLabel("Rooms");
        heading.setBounds(250,30,500,50);
        heading.setFont(new Font("Stencil",Font.BOLD,50));
        heading.setForeground(Color.BLUE);
        add(heading);
        
        JLabel Room_Number = new JLabel("Room_Number");
        Room_Number.setBounds(20,70,500,50);
        add(Room_Number);
        
        JLabel Availability = new JLabel("Availability");
        Availability.setBounds(140,70,500,50);
        add(Availability);
        
        JLabel Cleaning = new JLabel("Cleaning_Status");
        Cleaning.setBounds(260,70,500,50);
        add(Cleaning);
        
        JLabel Price = new JLabel("Price");
        Price.setBounds(380,70,500,50);
        add(Price);
        
        JLabel Bed = new JLabel("Room_Type");
        Bed.setBounds(500,70,500,50);
        add(Bed);
        
        tb = new JTable();
        tb.setBounds(20,120,600,350);
        add(tb);
        
        try
        {
            C c = new C();
            String sql="SELECT * FROM rooms";
            ResultSet rs = c.state.executeQuery(sql);
            tb.setModel(DbUtils.resultSetToTableModel(rs));
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        
        back = new JButton("Back");
        back.setBounds(300,500,100,20);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setCursor(new Cursor(Cursor.HAND_CURSOR));
        add(back);
        back.addActionListener(this);
        
        setLayout(null);
        setSize(700,600);
        setLocationRelativeTo(null);
        setVisible(true);
        setResizable(false);
        setTitle("Hotel Attic Empire");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    public static void main(String[] args) 
    {
        new room();
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource()==back)
        {
            setVisible(false);
            new reception();
        }
    }
}
