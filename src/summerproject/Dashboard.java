package summerproject;

import java.awt.*;
import javax.swing.*;

/**
 *
 * @author SUJAL
 */
public class Dashboard extends JFrame //implements ActionListener
{
    public Dashboard() 
    {
        ImageIcon i = new ImageIcon(ClassLoader.getSystemResource("images/Untitled.png"));
        Image i1 = i.getImage().getScaledInstance(1500,750,Image.SCALE_DEFAULT);
        ImageIcon i2 = new ImageIcon(i1);
        JLabel image = new JLabel(i2);
        image.setBounds(0,0,1500,750);
        add(image);
        
        JLabel name = new JLabel("Hotel Attic Empire");
        name.setBounds(250,50,900,100);
        name.setForeground(Color.WHITE);
        name.setFont(new Font("Stencil",Font.BOLD,85));
        image.add(name);
        
        setBounds(-6,0,1500,750);
        setLayout(null);
        setAlwaysOnTop(false);
        setUndecorated(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
    
    public static void main(String[] args) 
    {
        new Dashboard();
        
    }
}