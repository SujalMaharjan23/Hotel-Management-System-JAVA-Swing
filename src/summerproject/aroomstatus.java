package summerproject;

import java.awt.Choice;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author SUJAL
 */
public class aroomstatus extends JFrame implements ActionListener
{
    
    JTextField available,clean;
    JButton back,check,update;
    Choice room;
    JComboBox a, c;
    aroomstatus()
    {
        getContentPane().setBackground(Color.WHITE);
        
        
        JLabel head = new JLabel("Update Room Status");
        head.setBackground(Color.white);
        head.setForeground(Color.blue);
        head.setFont(new Font("Stencil",Font.BOLD,30));
        head.setBounds(20,20,350,30);
        add(head);
        
                
        JLabel RoomNumber = new JLabel("Room Number");
        RoomNumber.setBounds(20,100,100,30);
        add(RoomNumber);
        room = new Choice();
        room.setBounds(130,100,180,20);
            
        try
        {
            C con = new C();
            String sql = "SELECT * FROM rooms";
            ResultSet rs = con.state.executeQuery(sql);
            while(rs.next()) 
            {
                room.add(rs.getString("roomnumber"));
            }
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        add(room);
        
        JLabel Availability = new JLabel("Availability");
        Availability.setBounds(20,160,200,30);
        add(Availability);

        available = new JTextField();
        available.setBounds(130,160,180,20);
        available.setBackground(Color.white);
        add(available);
        
        JLabel Cleaning_Status = new JLabel("Cleaning Status");
        Cleaning_Status.setBounds(20,220,200,30);
        add(Cleaning_Status);

        clean = new JTextField();
        clean.setBounds(130,220,180,20);
        clean.setBackground(Color.white);
        add(clean);
              
        check = new JButton("Check");
        check.setBounds(70,280,200,25);        
        check.setBackground(Color.YELLOW);
        check.setForeground(Color.BLACK);
        check.setCursor(new Cursor(Cursor.HAND_CURSOR));
        add(check);
        check.addActionListener(this);
               
        back = new JButton("Back");
        back.setBounds(20,340,120,25);        
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setCursor(new Cursor(Cursor.HAND_CURSOR));
        add(back);
        back.addActionListener(this);
        
        update = new JButton("Update");
        update.setBounds(200,340,120,25);        
        update.setBackground(Color.BLACK);
        update.setForeground(Color.WHITE);
        update.setCursor(new Cursor(Cursor.HAND_CURSOR));
        add(update);
        update.addActionListener(this);
        
        ImageIcon i = new ImageIcon(ClassLoader.getSystemResource("images/suite_4.jpg"));
        Image i1 = i.getImage();
        Image i2 =i1.getScaledInstance(450, 300, Image.SCALE_SMOOTH);
        ImageIcon image = new ImageIcon(i2);
        JLabel l = new JLabel(image);
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
        new aroomstatus();
    }

    @Override
    public void actionPerformed(ActionEvent ae) 
    {
        if(ae.getSource()==back)
        {
            setVisible(false);
            
            new admin();
        }
        

        else if(ae.getSource()==update)
        {
            String id = room.getSelectedItem();
            String cl = clean.getText();
            String avl = available.getText();
            String sql = "update rooms set cleaning_status = '"+ cl +"', availability = '"+ avl +"' where roomnumber ='"+ id +"'";
            try
            {
                C c = new C();
                c.state.executeUpdate(sql);
                JOptionPane.showMessageDialog(null,"Room status updated successfully.");
                setVisible(false);
                new admin();
            }
            catch(Exception e)
            {
                System.out.println(e);
            }
        }
        
        else if(ae.getSource()==check)
        {
            String id = room.getSelectedItem();
            String sql = "select * from rooms where roomnumber = '"+id+"'";
            try
            {
                C c = new C();
                ResultSet rs = c.state.executeQuery(sql);
                while(rs.next())
                {
                    available.setText(rs.getString("availability"));
                    clean.setText(rs.getString("cleaning_status"));
                }
            }
            catch(Exception e)
            {
                System.out.println(e);
            }
        }
    }
}
