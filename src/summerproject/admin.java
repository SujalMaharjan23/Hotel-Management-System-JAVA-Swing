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
public class admin extends JFrame implements ActionListener
{
    JButton AddEmployees, ManageEmployees, NewCustomer, Rooms, CustomerInfo, CheckOut, UpdateStatus, RoomStatus, SearchRoom, Logout, ManageCustomer;
    public admin()
    {
        getContentPane().setBackground(Color.WHITE);
        
        AddEmployees = new JButton("Add Employees");
        AddEmployees.setBackground(Color.black);
        AddEmployees.setForeground(Color.white);
        AddEmployees.setBounds(10,20,200,30);
        AddEmployees.setFocusable(false);
        AddEmployees.addActionListener(this);
        
        ManageEmployees = new JButton("Manage Employees");
        ManageEmployees.setBackground(Color.black);
        ManageEmployees.setForeground(Color.white);
        ManageEmployees.setBounds(10,70,200,30);
        ManageEmployees.setFocusable(false);
        ManageEmployees.addActionListener(this);
        
        NewCustomer = new JButton("New Customer");
        NewCustomer.setBackground(Color.black);
        NewCustomer.setForeground(Color.white);
        NewCustomer.setBounds(10,120,200,30);
        NewCustomer.setFocusable(false);
        NewCustomer.addActionListener(this);
        
        CustomerInfo = new JButton("Customer Info");
        CustomerInfo.setBackground(Color.black);
        CustomerInfo.setForeground(Color.white);
        CustomerInfo.setBounds(10,170,200,30);
        CustomerInfo.setFocusable(false);
        CustomerInfo.addActionListener(this);
        
        ManageCustomer = new JButton("Manage Customer");
        ManageCustomer.setBackground(Color.black);
        ManageCustomer.setForeground(Color.white);
        ManageCustomer.setBounds(10,220,200,30);
        ManageCustomer.setFocusable(false);
        ManageCustomer.addActionListener(this);
        
        Rooms = new JButton("Rooms");
        Rooms.setBackground(Color.black);
        Rooms.setForeground(Color.white);
        Rooms.setBounds(10,270,200,30);
        Rooms.setFocusable(false);
        Rooms.addActionListener(this);
        
        RoomStatus = new JButton("Room Status");
        RoomStatus.setBackground(Color.black);
        RoomStatus.setForeground(Color.white);
        RoomStatus.setBounds(10,320,200,30);
        RoomStatus.setFocusable(false);
        RoomStatus.addActionListener(this);
        
        SearchRoom = new JButton("Search Rooms");
        SearchRoom.setBackground(Color.black);
        SearchRoom.setForeground(Color.white);
        SearchRoom.setBounds(10,370,200,30);
        SearchRoom.setFocusable(false);
        SearchRoom.addActionListener(this);
                
        UpdateStatus = new JButton("Update Status");
        UpdateStatus.setBackground(Color.black);
        UpdateStatus.setForeground(Color.white);
        UpdateStatus.setBounds(10,420,200,30);
        UpdateStatus.setFocusable(false);
        UpdateStatus.addActionListener(this);
        
        CheckOut = new JButton("CheckOut");
        CheckOut.setBackground(Color.black);
        CheckOut.setForeground(Color.white);
        CheckOut.setBounds(10,470,200,30);
        CheckOut.setFocusable(false);
        CheckOut.addActionListener(this);
        
        Logout = new JButton("Logout");
        Logout.setBackground(Color.black);
        Logout.setForeground(Color.white);
        Logout.setBounds(10,520,200,30);
        Logout.setFocusable(false);
        Logout.addActionListener(this);
        
        ImageIcon i = new ImageIcon(ClassLoader.getSystemResource("images/reception_1.jpg"));
        Image i1 = i.getImage().getScaledInstance(520,520,Image.SCALE_DEFAULT);
        ImageIcon i2 = new ImageIcon(i1);
        JLabel l = new JLabel(i2);
        l.setBounds(250,30,520,520);
        add(l);
        
        add(AddEmployees);
        add(ManageEmployees);
        add(NewCustomer);
        add(CustomerInfo);
        add(ManageCustomer);
        add(Rooms);
        add(RoomStatus);
        add(SearchRoom);
        add(CheckOut);
        add(UpdateStatus);
               
        add(Logout);
        
        setLayout(null);
        setSize(800,600);
        setLocationRelativeTo(null);
        setVisible(true);
        setResizable(false);
        setTitle("Hotel Attic Empire");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    public static void main(String[] args) 
    {
        new Dashboard();
        new admin();
    }

    @Override
    public void actionPerformed(ActionEvent ae) 
    {
        if(ae.getSource() == AddEmployees)
        {
            setVisible(false);
            new addemployees();
        }
        
        else if(ae.getSource() == ManageEmployees)
        {
            setVisible(false);
            manageemployees1 me = new manageemployees1();
            me.setVisible(true);
        }
        
        else if(ae.getSource() == NewCustomer)
        {
            setVisible(false);
            new aaaddcustomer();
        }
        
        else if(ae.getSource() == CustomerInfo)
        {
            setVisible(false);
            asearchcustomerinfo asc = new asearchcustomerinfo();
            asc.setVisible(true);
        }
        
        else if(ae.getSource() == ManageCustomer)
        {
            setVisible(false);
            managecustomerinfo m = new managecustomerinfo();
            m.setVisible(true);
        }
        
        else if(ae.getSource() == Rooms)
        {
            setVisible(false);
            new aroom();
        }
        
        else if(ae.getSource() == RoomStatus)
        {
            setVisible(false);
            new aroomstatus();
        }
        
        else if(ae.getSource() == SearchRoom)
        {
            setVisible(false);
            new asearchroom();
        }
        
        else if(ae.getSource()==UpdateStatus)
        {
            setVisible(false);
            new aupdatestatus();
        }
        
        else if(ae.getSource() == CheckOut)
        {
            setVisible(false);
            new acheckout();
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
