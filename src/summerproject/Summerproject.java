package summerproject;

import java.awt.*;
import java.awt.event.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
/**
 *
 * @author SUJAL
 */
public class Summerproject extends JFrame implements ActionListener
{
    JButton enter;
    Summerproject()
    {
        setTitle("Hotel Attic Empire");
        
        setSize(950,525);
        setLocationRelativeTo(null);
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
        
        enter = new JButton("ENTER");
        enter.setBounds(722,425,150,50);
        enter.setFont(new Font("Comic Ssns",Font.BOLD,25));
        enter.setBackground(Color.BLACK);
        enter.setForeground(Color.white);
        enter.setFocusable(false);
        enter.setCursor(new Cursor(Cursor.HAND_CURSOR));
        l.add(enter);
        enter.addActionListener(this);
        enter.addMouseListener(new mouseenter());
        
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
        loading l=new loading();
        l.setVisible(true);
        Thread o;
        o = new Thread(new Runnable() 
        {
            @Override
            public void run() 
            {
                try 
                {
                    Thread.sleep(7000);
                    new Summerproject().setVisible(true);
                } 
                catch (InterruptedException ex) 
                {
                    Logger.getLogger(loading.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        o.start();
    }

    @Override
    public void actionPerformed(ActionEvent e) 
    {
        setVisible(false);
        Dashboard d = new Dashboard();
        d.setVisible(true);
        login l = new login();
        l.setVisible(true);       
    }
    
    class mouseenter implements MouseListener
    {
        @Override
        public void mouseClicked(MouseEvent e) {
        }

        @Override
        public void mousePressed(MouseEvent e) {
        }

        @Override
        public void mouseReleased(MouseEvent e) {
        }

        @Override
        public void mouseEntered(MouseEvent e) 
        {
            enter.setBackground(Color.WHITE);
            enter.setForeground(Color.BLACK);
        }

        @Override
        public void mouseExited(MouseEvent e) 
        {
            enter.setBackground(Color.BLACK);
            enter.setForeground(Color.WHITE);
        }
    }
}