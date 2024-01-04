package summerproject;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
/**
 *
 * @author SUJAL
 */
public class login extends JFrame implements ActionListener
{
    JTextField user, pass;
    JButton login, cancel;
    JComboBox select;
    JLabel topic;
    login()
    {
        getContentPane().setBackground(Color.WHITE);
        
        topic = new JLabel("Login");
        topic.setBounds(150,5,175,30);
        topic.setFont(new Font("Stencil",Font.BOLD,25));
        topic.setForeground(Color.BLUE);
        add(topic);
        
        JLabel selectuser = new JLabel("User/Admin");
        selectuser.setBounds(40,50,100,30);
        add(selectuser);
        String selection[] = {"","user","admin"};
        select = new JComboBox(selection);
        select.setBounds(150,50,150,30);
        select.setBackground(Color.white);
        add(select);
        select.addActionListener(new SelectAction());
        
        JLabel username = new JLabel("Username");
        username.setBounds(40,95,100,30);
        add(username);
        user = new JTextField(20);
        user.setBounds(150,95,150,30);
        add(user);
        
        JLabel password = new JLabel("Password");
        password.setBounds(40,135,100,30);
        add(password);
        pass = new JPasswordField(20);
        pass.setBounds(150,135,150,30);
        add(pass);
        pass.addKeyListener(new LoginKeyListener());
        
        login = new JButton("Login");
        login.setBounds(40,200,120,30);
        login.setBackground(Color.BLACK);
        login.setForeground(Color.WHITE);
        login.setCursor(new Cursor(Cursor.HAND_CURSOR));
        add(login);
        login.addActionListener(this);
        
        cancel = new JButton("Cancel");
        cancel.setBounds(180,200,120,30);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.setCursor(new Cursor(Cursor.HAND_CURSOR));
        add(cancel);
        cancel.addActionListener(this);
        
        ImageIcon i = new ImageIcon(ClassLoader.getSystemResource("images/second.jpg"));
        Image i1 = i.getImage().getScaledInstance(200,200,Image.SCALE_DEFAULT);
        ImageIcon i2 = new ImageIcon(i1);
        JLabel l = new JLabel(i2);
        l.setBounds(350,10,200,200);
        add(l);
        
        setLayout(null);
        setSize(600,290);
        setLocationRelativeTo(null);
        setVisible(true);
//        setAlwaysOnTop(true);
        setResizable(false);
        setTitle("Hotel Attic Empire");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
    }
    public static void main(String[] args) 
    {
        new login();
    }

    class SelectAction implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e) 
        {
            String selectedItem = (String) select.getSelectedItem();
            if (selectedItem.equals("user")) 
            {
                topic.setText("User Login");
            } 
            else if (selectedItem.equals("admin")) 
            {
                topic.setText("Admin Login");
            }
        }      
    }
    
    class LoginKeyListener extends KeyAdapter 
    {
        public void keyPressed(KeyEvent e) 
        {
            if (e.getKeyCode() == KeyEvent.VK_ENTER) 
            {
                // Simulate a button click
                login.doClick();
            }
        }
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) 
    {
        String selectedItem = (String) select.getSelectedItem();
        if(ae.getSource()==login)
        {
            if((user.getText().toString().equals("admin") && pass.getText().toString().equals("admin") && selectedItem.equals("admin")))
            {
                setVisible(false);
                new admin();
            }
            else if((user.getText().toString().equals("sujal") && pass.getText().toString().equals("sujal") && selectedItem.equals("user")))
            {
                JOptionPane.showMessageDialog(null,"Logged in successfully.");
                setVisible(false);
                new reception();
            }
            else if(user.getText().toString().equals("") && pass.getText().toString().equals(""))
            {
                JOptionPane.showMessageDialog(null,"Enter username and password !!!");
            }
            else if(pass.getText().toString().equals(""))
            {
                JOptionPane.showMessageDialog(null,"Enter the password !!!");
            }
            else
            {
                JOptionPane.showMessageDialog(null,"Invalid username and password !!!");
                pass.setText("");
                user.setText("");
                user.requestFocus();
            }
        }
        else if(ae.getSource()==cancel)
        {
            int i = JOptionPane.showConfirmDialog(null,"Do you want to cancel?","Cancel?",JOptionPane.YES_NO_OPTION);
            if(i==0)
            {
                System.exit(0);
            }
            else{}
        }
    }
}
