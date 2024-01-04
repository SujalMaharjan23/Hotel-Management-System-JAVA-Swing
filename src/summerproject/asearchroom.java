package summerproject;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import javax.swing.*;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author SUJAL
 */
public class asearchroom extends JFrame implements ActionListener
{
    JTable tb;
    JButton back,checks;
    JComboBox cmb;
    JCheckBox check;
    asearchroom()
    {
        getContentPane().setBackground(Color.WHITE);
        
        JLabel head = new JLabel("Search Rooms");
        head.setBackground(Color.white);
        head.setForeground(Color.blue);
        head.setFont(new Font("Stencil",Font.BOLD,30));
        head.setBounds(280,20,350,30);
        add(head);
        
        JLabel bedtype = new JLabel("Room Bed Type");
        bedtype.setBounds(10,60,150,30);
        add(bedtype);
        String bedtypeoption[] = {"Suite-King Bed","Deluxe-King Bed","Deluxe-Twin Bed","Deluxe-Triple Bed"};
        cmb = new JComboBox(bedtypeoption);
        cmb.setBounds(130,60,150,20);
        cmb.setBackground(Color.white);
        add(cmb);
        
        check = new JCheckBox("Display only available rooms");
        check.setBounds(500,60,200,30);
        check.setBackground(Color.WHITE);
        add(check);
        
        
        JLabel Room_Number = new JLabel("Room_Number");
        Room_Number.setBounds(20,90,500,50);
        add(Room_Number);
        
        JLabel Availability = new JLabel("Availability");
        Availability.setBounds(140,90,500,50);
        add(Availability);
        
        JLabel Cleaning = new JLabel("Cleaning_Status");
        Cleaning.setBounds(260,90,500,50);
        add(Cleaning);
        
        JLabel Price = new JLabel("Price");
        Price.setBounds(380,90,500,50);
        add(Price);
        
        JLabel Bed = new JLabel("Bed_Type");
        Bed.setBounds(500,90,500,50);
        add(Bed);
        
        tb = new JTable();
        tb.setBounds(20,140,600,400);
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
        back.setBounds(200,570,100,25);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setCursor(new Cursor(Cursor.HAND_CURSOR));
        add(back);
        back.addActionListener(this);
        
        checks = new JButton("Check");
        checks.setBounds(400,570,100,25);
        checks.setBackground(Color.YELLOW);
        checks.setForeground(Color.BLACK);
        checks.setCursor(new Cursor(Cursor.HAND_CURSOR));
        add(checks);
        checks.addActionListener(this);
        
        setLayout(null);
        setSize(800,650);
        setLocationRelativeTo(null);
        setVisible(true);
        setResizable(false);
        setTitle("Hotel Attic Empire");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    public static void main(String[] args) 
    {
        new asearchroom();
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) 
    {
        
        if(ae.getSource()==checks)
        {
            try
            {
                String query1 = "SELECT * FROM rooms where room_type = '"+ cmb.getSelectedItem() +"'";
                String query2 = "SELECT * FROM rooms where availability = 'Available' AND room_type = '"+ cmb.getSelectedItem() +"'";
                
                C c = new C();
                ResultSet rs;
                if(check.isSelected())
                {
                    rs = c.state.executeQuery(query2);
                }
                else
                {
                    rs = c.state.executeQuery(query1);
                }
                               
                tb.setModel(DbUtils.resultSetToTableModel(rs));
            }
            catch(Exception e)
            {
                System.out.println(e);
            }
        }
        else if(ae.getSource()==back)
        {
            setVisible(false);
            new admin();
        }
    }
    
}
