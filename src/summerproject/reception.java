package summerproject;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 *
 * @author SUJAL
 */
public class reception extends JFrame implements ActionListener
{
    JButton NewCustomer, Rooms, CustomerInfo, CheckOut, UpdateStatus, RoomStatus, SearchRoom, Logout;
    public reception()
    {
        getContentPane().setBackground(Color.WHITE);
        
        NewCustomer = new JButton("New Customer");
        NewCustomer.setBackground(Color.black);
        NewCustomer.setForeground(Color.white);
        NewCustomer.setBounds(10,50,200,30);
        NewCustomer.setFocusable(false);
        NewCustomer.addActionListener(this);
        
        CustomerInfo = new JButton("Customer Info");
        CustomerInfo.setBackground(Color.black);
        CustomerInfo.setForeground(Color.white);
        CustomerInfo.setBounds(10,100,200,30);
        CustomerInfo.setFocusable(false);
        CustomerInfo.addActionListener(this);
        
        Rooms = new JButton("Rooms");
        Rooms.setBackground(Color.black);
        Rooms.setForeground(Color.white);
        Rooms.setBounds(10,150,200,30);
        Rooms.setFocusable(false);
        Rooms.addActionListener(this);
        
        RoomStatus = new JButton("Room Status");
        RoomStatus.setBackground(Color.black);
        RoomStatus.setForeground(Color.white);
        RoomStatus.setBounds(10,200,200,30);
        RoomStatus.setFocusable(false);
        RoomStatus.addActionListener(this);
        
        SearchRoom = new JButton("Search Rooms");
        SearchRoom.setBackground(Color.black);
        SearchRoom.setForeground(Color.white);
        SearchRoom.setBounds(10,250,200,30);
        SearchRoom.setFocusable(false);
        SearchRoom.addActionListener(this);
                
        UpdateStatus = new JButton("Update Status");
        UpdateStatus.setBackground(Color.black);
        UpdateStatus.setForeground(Color.white);
        UpdateStatus.setBounds(10,300,200,30);
        UpdateStatus.setFocusable(false);
        UpdateStatus.addActionListener(this);
        
        CheckOut = new JButton("CheckOut");
        CheckOut.setBackground(Color.black);
        CheckOut.setForeground(Color.white);
        CheckOut.setBounds(10,350,200,30);
        CheckOut.setFocusable(false);
        CheckOut.addActionListener(this);
        
        Logout = new JButton("Logout");
        Logout.setBackground(Color.black);
        Logout.setForeground(Color.white);
        Logout.setBounds(10,400,200,30);
        Logout.setFocusable(false);
        Logout.addActionListener(this);
        
        ImageIcon i = new ImageIcon(ClassLoader.getSystemResource("images/reception_2.jpg"));
        Image i1 = i.getImage().getScaledInstance(500,450,Image.SCALE_DEFAULT);
        ImageIcon i2 = new ImageIcon(i1);
        JLabel l = new JLabel(i2);
        l.setBounds(250,30,500,450);
        add(l);
        
        add(NewCustomer);
        add(CustomerInfo);
        add(Rooms);
        add(RoomStatus);
        add(SearchRoom);
        add(CheckOut);
        add(UpdateStatus);
               
        add(Logout);
        
        setLayout(null);
        setSize(800,520);
        setLocationRelativeTo(null);
        setVisible(true);
        setResizable(false);
        setTitle("Hotel Attic Empire");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    public static void main(String[] args) 
    {
        new Dashboard();
        new reception();
    }

    @Override
    public void actionPerformed(ActionEvent ae) 
    {
        if(ae.getSource() == NewCustomer)
        {
            setVisible(false);
            new addcustomer();
        }
        
        else if(ae.getSource() == CustomerInfo)
        {
            setVisible(false);
            searchcustomerinfo sc = new searchcustomerinfo();
            sc.setVisible(true);
        }
        
        else if(ae.getSource() == Rooms)
        {
            setVisible(false);
            new room();
        }
        
        else if(ae.getSource() == RoomStatus)
        {
            setVisible(false);
            new roomstatus();
        }
        
        else if(ae.getSource() == SearchRoom)
        {
            setVisible(false);
            new searchroom();
        }
        
        else if(ae.getSource()==UpdateStatus)
        {
            setVisible(false);
            new updatestatus();
        }
        
        else if(ae.getSource() == CheckOut)
        {
            setVisible(false);
            new checkout();
        }
        else if(ae.getSource() == Logout)
        {
            int a = JOptionPane.showConfirmDialog(null, "Do you want to Logout?", "Logging out", JOptionPane.YES_NO_OPTION);
            if(a==0)
            {
                this.setVisible(false);
                new login();
            }
            else
            {
                
            }
        }
    }
}
