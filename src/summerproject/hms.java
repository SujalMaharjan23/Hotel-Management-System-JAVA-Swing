package hotelmanagementsystem;

import java.awt.*;
import java.awt.event.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import summerproject.loading;
import summerproject.loadingbackground;
/**
 *
 * @author SUJAL
 */
public class hms extends JFrame implements ActionListener
{
    hms()
    {
        setTitle("Hotel Attic Empire");
        
        setBounds(225,100,950,525);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        ImageIcon i = new ImageIcon(ClassLoader.getSystemResource("images/Untitled.png"));
        JLabel l = new JLabel(i);
        l.setBounds(0,0,950,525);
        add(l);
        
        JLabel name = new JLabel("Hotel Attic Empire");
        name.setBounds(150,0,650,100);
        name.setForeground(Color.white);
        name.setFont(new Font("Serif",Font.BOLD,75));
        l.add(name);
        
        JButton enter = new JButton("ENTER");
        enter.setBounds(722,425,150,50);
        enter.setFont(new Font("Comic Ssns",Font.BOLD,25));
        enter.setBackground(Color.BLACK);
        enter.setForeground(Color.white);
//        enter.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
//        enter.setFont(new Font("Serif",Font.BOLD,25));
        enter.setFocusable(false);
        enter.setCursor(new Cursor(Cursor.HAND_CURSOR));
        l.add(enter);
        enter.addActionListener(this);
        
        setResizable(false);
        setVisible(true);
        while(true)
        {
            name.setVisible(false);
            try
            {
                Thread.sleep(500);
            }
            catch(Exception e)
            {
                e.printStackTrace();
            }
            
            name.setVisible(true);
            
            try
            {
                Thread.sleep(500);
            }
            catch(Exception e)
            {
                e.printStackTrace();
            }
        }
    }
    
    public static void main(String[] args) 
    {
        loadingbackground l=new loadingbackground();
        l.setVisible(true);
        Thread o;
        o = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(7500);
                    new hms().setVisible(true);
                } catch (InterruptedException ex) {
                    Logger.getLogger(loading.class.getName()).log(Level.SEVERE, null, ex);
                }
                    
                }
            });

        o.start();
        
        
    }

    @Override
    public void actionPerformed(ActionEvent e) 
    {
//        loadingbackground l = new loadingbackground();
//        l.dispose();
        setVisible(false);
//        new Dashboard();
//        new login();
    }
}