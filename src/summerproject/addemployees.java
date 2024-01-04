package summerproject;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author SUJAL
 */
public class addemployees extends JFrame implements ActionListener
{
    JTextField tname,tage,tsalary,temail,tcontact,tpaddress,taddress;
    JLabel tphoto, l, fphoto;
    JRadioButton male,female;
    JComboBox cmb, cmb1;
    JButton submit, back, pbutton, fbutton;
    Connection c3;
    PreparedStatement state3;
    String s, s1;
    addemployees()
    {
        
        getContentPane().setBackground(Color.WHITE);
                
        JLabel text = new JLabel("NEW EMPLOYEE FORM");
        text.setBounds(150,20,300,25);
        text.setFont(new Font("Stencil",Font.BOLD,25));
        text.setForeground(Color.BLUE);
        
        JLabel name = new JLabel("Name");
        name.setBounds(20,60,35,20);
        tname = new JTextField(50);
        tname.setBounds(150,60,150,20);
        
        JLabel age = new JLabel("Age");
        age.setBounds(20,100,35,20);
        tage = new JTextField(50);
        tage.setBounds(150,100,150,20);
        
        JLabel gender = new JLabel("Gender");
        gender.setBounds(20,140,45,20);
        
        male = new JRadioButton("Male",true);
        male.setBounds(150,140,70,20);
        male.setBackground(Color.white);
        
	female = new JRadioButton("Female",true);
        female.setBounds(230,140,70,20);
        female.setBackground(Color.white);
        
	ButtonGroup bg = new ButtonGroup();
	bg.add(male);
	bg.add(female); 
        
        JLabel paddress = new JLabel("Permanent Address");
        paddress.setBounds(20,180,120,20);
        tpaddress = new JTextField(50);
        tpaddress.setBounds(150,180,150,20);
        
        JLabel address = new JLabel("Temporary Address");
        address.setBounds(20,220,120,20);
        taddress = new JTextField(50);
        taddress.setBounds(150,220,150,20);
        
        JLabel email = new JLabel("Email");
        email.setBounds(20,260,35,20);
        temail = new JTextField(50);
        temail.setBounds(150,260,150,20);
        
        JLabel contact = new JLabel("Contact");
        contact.setBounds(20,300,45,20);
        tcontact = new JTextField(50);
        tcontact.setBounds(150,300,150,20);
        
        JLabel job = new JLabel("Job");
        job.setBounds(20,340,35,20);
        String jobs[] ={"Front Desk","HouseKeeping","Chef","Guard","Waiters/Waitress"};
        cmb = new JComboBox(jobs);
	cmb.setBounds(150,340,150,20);
           
        JLabel salary = new JLabel("Salary");
        salary.setBounds(20,380,40,20);
        tsalary = new JTextField(50);
        tsalary.setBounds(150,380,150,20);
        
        JLabel ID = new JLabel("ID");
        ID.setBounds(20,420,260,20);
        String ids[] ={"","Citizenship","License","VoterCard","Passport"};
        cmb1 = new JComboBox(ids);
	cmb1.setBounds(150,420,150,20);
        cmb1.setBackground(Color.white);
        cmb1.addActionListener(new IdAction());
        
        pbutton = new JButton("Upload ID");
        pbutton.setBounds(20,465,120,25);
        pbutton.setBackground(Color.DARK_GRAY);
        pbutton.setForeground(Color.WHITE);
        pbutton.addActionListener(new uploadAction());
        tphoto = new JLabel("");
        tphoto.setBounds(150,465,250,20);
        
        fbutton = new JButton("Upload Photo");
        fbutton.setBounds(20,500,120,25);
        fbutton.setBackground(Color.DARK_GRAY);
        fbutton.setForeground(Color.WHITE);
        fbutton.addActionListener(new photoAction());
        fphoto = new JLabel("");
        fphoto.setBounds(150,500,250,20);
                
        back = new JButton("Back");
        back.setBounds(20,550,120,25);        
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setCursor(new Cursor(Cursor.HAND_CURSOR));
        back.addActionListener(this);
        
        submit = new JButton("ADD");
        submit.setBounds(150,550,120,25);        
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.setCursor(new Cursor(Cursor.HAND_CURSOR));
        submit.addActionListener(this);
        
        ImageIcon i = new ImageIcon(ClassLoader.getSystemResource("icons/tenth.jpg"));
        Image i1 = i.getImage().getScaledInstance(350,350,Image.SCALE_DEFAULT);
        ImageIcon i2 = new ImageIcon(i1);
        l = new JLabel(i2);
        l.setBounds(320,80,350,300);
        add(l);
        
        add(text);
        add(name);
        add(tname);
        add(age);
        add(tage);
        add(gender);
        add(male);
        add(female);
        add(paddress);
        add(tpaddress);
        add(address);
        add(taddress);
        add(job);
        add(cmb);
        add(salary);
        add(tsalary);
        add(email);
        add(temail);
        add(contact);
        add(tcontact);
        add(ID);
        add(cmb1);
        add(pbutton);
        add(tphoto);
        add(fbutton);
        add(fphoto);
        add(back);
        add(submit);
        
        setLayout(null);
        setSize(700,650);
        setLocationRelativeTo(null);
        setVisible(true);
        setResizable(false);
        setTitle("Hotel Attic Empire");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    public static void main(String[] args) 
    {
        new addemployees();
    }

    @Override
    public void actionPerformed(ActionEvent ae) 
    {
        String dname = tname.getText();
        String dage = tage.getText();
        String dgender = null;
        if(male.isSelected())
        {
            dgender = "Male";
        }
        else if(female.isSelected())
        {
            dgender = "Female";
        }
        String dpaddress = tpaddress.getText();
        String daddress = taddress.getText();
        String demail = temail.getText();
        String dcontact = tcontact.getText();
        String dsalary = tsalary.getText();
        String djob = (String) cmb.getSelectedItem();
        if(ae.getSource()==submit)
        {
            if(validation()==true)
            {
                try 
                {
                    Class.forName("com.mysql.jdbc.Driver");
                    c3 = DriverManager.getConnection("jdbc:mysql://localhost/hotelmanagementsystem","root","");
                    state3 = c3.prepareStatement("insert into employeedatabase (`name`,`age`,`gender`,`permanent_address`,`temporary_address`,`email`,`contact`,`job`,`salary`,`id`,`photo`)values(?,?,?,?,?,?,?,?,?,?,?)");
                    InputStream is = new FileInputStream(new File(s));
                    InputStream is1 = new FileInputStream(new File(s1));
                    state3.setString(1, dname);
                    state3.setString(2, dage);
                    state3.setString(3, dgender);
                    state3.setString(4,dpaddress);
                    state3.setString(5,daddress);
                    state3.setString(6,demail);
                    state3.setString(7,dcontact);
                    state3.setString(8,djob);
                    state3.setString(9,dsalary);
                    state3.setBlob(10, is);
                    state3.setBlob(11, is1);
                    state3.executeUpdate();
                    JOptionPane.showMessageDialog(null,"Employee added successfully!!!");
                    setVisible(false);
                    new addemployees();
                }
                catch(ClassNotFoundException | SQLException e) 
                {
                    System.out.print(e);
                }   
                catch (FileNotFoundException ex) 
                {
                    Logger.getLogger(addemployees.class.getName()).log(Level.SEVERE, null, ex);
                }
                try {
                    c3.close();
                } catch (SQLException ex) {
                    Logger.getLogger(addemployees.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        else if(ae.getSource()==back)
        {
            setVisible(false);
            new admin();
        }
//        try {
//            c3.close();
//        } catch (SQLException ex) {
//            Logger.getLogger(addemployees.class.getName()).log(Level.SEVERE, null, ex);
//        }
    }
    
    class IdAction implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent aae) 
        {
                int i = JOptionPane.showConfirmDialog(null,"Do you want to scan?","Scanner",JOptionPane.YES_NO_OPTION);
                if(i== 0)
                {
                    try 
                    {
                        // Open printer settings
                        // Runtime.getRuntime().exec("control printers");

                        // Open scanner settings
                         Runtime.getRuntime().exec("control /name Microsoft.ScannersAndCameras");
                    } 
                    catch (IOException e) 
                    {
                        e.printStackTrace();
                    }
                }
        }
    }
    
    public ImageIcon ResizeImage(String imgpath)
    {
        ImageIcon myimg = new ImageIcon(imgpath);
        Image imge = myimg.getImage();
        Image newimage = imge.getScaledInstance(l.getWidth(), l.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon image = new ImageIcon(newimage);
        return image;
    }
    
    class uploadAction implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e2) 
        {
            if(e2.getSource()==pbutton)
            {
                JFileChooser filechooser = new JFileChooser();
                filechooser.setCurrentDirectory(new File(System.getProperty("user.home")));
                FileNameExtensionFilter filter = new FileNameExtensionFilter("*.IMAGE","jpg","jpeg","png","gif");
                filechooser.addChoosableFileFilter(filter);
                int result = filechooser.showSaveDialog(null);
                if(result == JFileChooser.APPROVE_OPTION)
                {
                    File selectedfile = filechooser.getSelectedFile();
                    String path = selectedfile.getAbsolutePath();
//                    l.setIcon(ResizeImage(path));
                    s= path;
                    tphoto.setText(s);
                }
            }
        }
    }
    
    class photoAction implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e3) 
        {
            if(e3.getSource()==fbutton)
            {
                int i2 = JOptionPane.showConfirmDialog(null,"Do you want to scan?","Scanner",JOptionPane.YES_NO_OPTION);
                if(i2== 0)
                {
                    try 
                    {
                        // Open printer settings
                        // Runtime.getRuntime().exec("control printers");

                        // Open scanner settings
                         Runtime.getRuntime().exec("control /name Microsoft.ScannersAndCameras");
                    } 
                    catch (IOException e) 
                    {
                        e.printStackTrace();
                    }
                }
                JFileChooser filechooser1 = new JFileChooser();
                filechooser1.setCurrentDirectory(new File(System.getProperty("user.home")));
                FileNameExtensionFilter filter1 = new FileNameExtensionFilter("*.IMAGE","jpg","jpeg","png","gif");
                filechooser1.addChoosableFileFilter(filter1);
                int result1 = filechooser1.showSaveDialog(null);
                if(result1 == JFileChooser.APPROVE_OPTION)
                {
                    File selectedfile1 = filechooser1.getSelectedFile();
                    String path = selectedfile1.getAbsolutePath();
                    l.setIcon(ResizeImage(path));
                    s1= path;
                    fphoto.setText(s1);
                }
            }
        }
    }
    
    public boolean validation()
    {
        if(tname.getText().equals(""))
        {
            JOptionPane.showMessageDialog(this, "Enter name.");
            tname.requestFocus();
            return false;
        }
        if(tcontact.getText().equals(""))
        {
            JOptionPane.showMessageDialog(this, "Enter contact number.");
            tcontact.requestFocus();
            return false;
        }
        if(tpaddress.getText().equals(""))
        {
            JOptionPane.showMessageDialog(this, "Enter permanent address.");
            tpaddress.requestFocus();
            return false;
        }
        if(taddress.getText().equals(""))
        {
            JOptionPane.showMessageDialog(this, "Enter temporary address.");
            taddress.requestFocus();
            return false;
        }
        if(tcontact.getText().equals(""))
        {
            JOptionPane.showMessageDialog(this, "Enter contact number.");
            tcontact.requestFocus();
            return false;
        }
        if(tphoto.getText().equals(""))
        {
            JOptionPane.showMessageDialog(this, "ID not uploaded.");
            pbutton.requestFocus();
            return false;
        }
        if(fphoto.getText().equals(""))
        {
            JOptionPane.showMessageDialog(this, "Photo not uploaded.");
            fbutton.requestFocus();
            return false;
        }
        return true;
    }
}